package arshsingh93.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import arshsingh93.interactivestory.R;
import arshsingh93.interactivestory.model.Page;
import arshsingh93.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    private static final String TAG = StoryActivity.class.getSimpleName();

    private Story myStory = new Story();
    private ImageView myImageView;
    private TextView myTextView;
    private Button myChoice1;
    private Button myChoice2;
    private String myName; //this was made a member variable of the class here b/c it was needed in the loadPage method.
    private Page myCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        myName = intent.getStringExtra(getString(R.string.key_name));
        if (myName == null) {
            myName = "Friend";
        }
        Log.d(TAG, myName);

        myImageView = (ImageView) findViewById(R.id.storyImageView);
        myTextView = (TextView) findViewById(R.id.storyTextView);
        myChoice1 = (Button) findViewById(R.id.choiceButton1);
        myChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int theChoice) {
        myCurrentPage = myStory.getPage(theChoice);

        Drawable drawable = getResources().getDrawable(myCurrentPage.getMyImageId());
        myImageView.setImageDrawable(drawable);

        String pageText = myCurrentPage.getMyText();
        //Add myName into the pageText string if placeholder (%1$s) is  included. myName won't be
        // added if there isn't a placeholder with the pageText string.
        pageText = String.format(pageText, myName);
        myTextView.setText(pageText);

        if (myCurrentPage.isMyFinal()) {
            myChoice1.setVisibility(View.INVISIBLE);
            myChoice2.setText("PLAY AGAIN");
            myChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });


        } else {
            myChoice1.setText(myCurrentPage.getMyChoice1().getMyText());
            myChoice2.setText(myCurrentPage.getMyChoice2().getMyText());

            myChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        int nextPage = myCurrentPage.getMyChoice1().getMyNextPage();
                        loadPage(nextPage);
                }
            });

        myChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPage(myCurrentPage.getMyChoice2().getMyNextPage());
            }
        });

    }

    }











}

package arshsingh93.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import arshsingh93.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText myNameField;
    private Button myStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myNameField = (EditText) findViewById(R.id.nameEditText);
        myStartButton = (Button) findViewById(R.id.startButton);

        myStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = myNameField.getText().toString();
                startStory(name);

            }
        });
    }

    private void startStory(String theName) {
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), theName);
        startActivity(intent);

    }


}

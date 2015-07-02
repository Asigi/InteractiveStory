package arshsingh93.interactivestory.model;

/**
 * Created by Student on 7/1/2015.
 */
public class Choice {

    private String myText;
    private int myNextPage;

    public Choice(String theText, int theNextPage) {
        myText = theText;
        myNextPage = theNextPage;
    }


    public String getMyText() {
        return myText;
    }

    public void setMyText(String myText) {
        this.myText = myText;
    }

    public int getMyNextPage() {
        return myNextPage;
    }

    public void setMyNextPage(int myNextPage) {
        this.myNextPage = myNextPage;
    }





}

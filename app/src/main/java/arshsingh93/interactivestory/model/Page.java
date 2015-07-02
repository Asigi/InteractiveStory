package arshsingh93.interactivestory.model;

/**
 * Created by Student on 7/1/2015.
 */
public class Page {

    private int myImageId;
    private String myText;
    private Choice myChoice1;
    private Choice myChoice2;
    private boolean myFinal = false;

    public Page(int theID, String theText, Choice theChoice1, Choice theChoice2) {
        myImageId = theID;
        myText = theText;
        myChoice1 = theChoice1;
        myChoice2 = theChoice2;

    }

    public Page(int theID, String theText) {
        myImageId = theID;
        myText = theText;
        myChoice1 = null;
        myChoice2 = null;
        myFinal = true;
    }

    public int getMyImageId() {
        return myImageId;
    }

    public void setMyImageId(int myImageId) {
        this.myImageId = myImageId;
    }

    public String getMyText() {
        return myText;
    }

    public void setMyText(String myText) {
        this.myText = myText;
    }

    public Choice getMyChoice1() {
        return myChoice1;
    }

    public void setMyChoice1(Choice myChoice1) {
        this.myChoice1 = myChoice1;
    }

    public Choice getMyChoice2() {
        return myChoice2;
    }

    public void setMyChoice2(Choice myChoice2) {
        this.myChoice2 = myChoice2;
    }


    public boolean isMyFinal() {
        return myFinal;
    }

    public void setMyFinal(boolean myFinal) {
        this.myFinal = myFinal;
    }

}

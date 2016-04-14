package pojo;

/**
 * Created by krumo on 2016/3/16.
 */
public class text {
    private int textID;
    private String sentence;
    private String emotion;
    private String frequency;
    private int maleread;
    private int femaleread;
    private int skip;

    public text() {
    }

    public text(int textID, String sentence, String emotion, String frequency) {
        this.textID = textID;
        this.sentence = sentence;
        this.emotion = emotion;
        this.frequency = frequency;
        this.maleread=0;
        this.femaleread=0;
    }

    public text(int textID, String sentence, String emotion, String frequency, int maleread, int femaleread) {
        this.textID = textID;
        this.sentence = sentence;
        this.emotion = emotion;
        this.frequency = frequency;
        this.maleread = maleread;
        this.femaleread = femaleread;
    }

    public text(int textID, String sentence, String emotion, String frequency, int maleread, int femaleread, int skip) {
        this.textID = textID;
        this.sentence = sentence;
        this.emotion = emotion;
        this.frequency = frequency;
        this.maleread = maleread;
        this.femaleread = femaleread;
        this.skip = skip;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getMaleread() {
        return maleread;
    }

    public void setMaleread(int maleread) {
        this.maleread = maleread;
    }

    public int getFemaleread() {
        return femaleread;
    }

    public void setFemaleread(int femaleread) {
        this.femaleread = femaleread;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getTextID() {
        return textID;
    }

    public void setTextID(int textID) {
        this.textID = textID;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}

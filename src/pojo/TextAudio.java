package pojo;

/**
 * Created by krumo on 2016/3/16.
 */
public class TextAudio {
    private int AudioID;
    private int userID;
    private int textID;
    private String relativeAddress;

    public TextAudio() {
    }

    public TextAudio(int textRadioID, int uID, int tID, String relativeAddress) {
        this.AudioID = textRadioID;
        this.userID = uID;
        this.textID = tID;
        this.relativeAddress = relativeAddress;
    }

    public int getAudioID() {
        return AudioID;
    }

    public void setAudioID(int audioID) {
        AudioID = audioID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTextID() {
        return textID;
    }

    public void setTextID(int textID) {
        this.textID = textID;
    }

    public String getRelativeAddress() {
        return relativeAddress;
    }

    public void setRelativeAddress(String relativeAddress) {
        this.relativeAddress = relativeAddress;
    }
}

package com.alykhaled.clubhouseclone;

import com.google.gson.annotations.SerializedName;

public class UserItem {
    @SerializedName("user_id")
    private int userID;
    @SerializedName("name")
    private String mName;
    @SerializedName("photo_url")
    private String mImage;
    @SerializedName("user_name")
    private String mUsername;

    private String mState;

    private boolean muted = true;

    private boolean speaking = false;

    public UserItem(int userID, String mName, String mImage, String mUsername, String mState, boolean muted, boolean speaking) {
        this.userID = userID;
        this.mName = mName;
        this.mImage = mImage;
        this.mUsername = mUsername;
        this.mState = mState;
        this.muted = muted;
        this.speaking = speaking;
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }

    public String getState() {
        return mState;
    }

    public void setState(String mState) {
        this.mState = mState;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public boolean isSpeaking() {
        return speaking;
    }

    public void setSpeaking(boolean speaking) {
        this.speaking = speaking;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

}

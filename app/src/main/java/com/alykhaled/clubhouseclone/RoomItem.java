package com.alykhaled.clubhouseclone;

public class RoomItem {
    private String mRoomName;
    private String mClubName;
    private String mImage;
    private int listenersNum;

    public RoomItem(String mRoomName, String mClubName, String mImage, int listenersNum) {
        this.mRoomName = mRoomName;
        this.mClubName = mClubName;
        this.mImage = mImage;
        this.listenersNum = listenersNum;
    }

    public String getRoomName() {
        return mRoomName;
    }

    public void setRoomName(String mRoomName) {
        this.mRoomName = mRoomName;
    }

    public String getClubName() {
        return mClubName;
    }

    public void setClubName(String mClubName) {
        this.mClubName = mClubName;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }

    public int getListenersNum() {
        return listenersNum;
    }

    public void setListenersNum(int listenersNum) {
        this.listenersNum = listenersNum;
    }
}

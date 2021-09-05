package com.alykhaled.clubhouseclone;

import com.google.gson.annotations.SerializedName;

public class ChannelItem {

    @SerializedName("creator_user_profile_id")
    private String creatorProfileId;

    @SerializedName("channel_id")
    private String channelID;

    @SerializedName("channel")
    private String channel;

    @SerializedName("topic")
    private String topic;

    @SerializedName("is_private")
    private boolean isPrivate;

    @SerializedName("is_social_mode")
    private boolean isSocialMode;

    @SerializedName("url")
    private String url;

    @SerializedName("club")
    private ClubItem club;

    @SerializedName("num_speakers")
    private int speakersNum;

    @SerializedName("num_all")
    private int peopleNum;

    public ChannelItem(String creatorProfileId, String channelID, String channel, String topic, boolean isPrivate, boolean isSocialMode, String url, ClubItem club, int speakersNum, int peopleNum) {
        this.creatorProfileId = creatorProfileId;
        this.channelID = channelID;
        this.channel = channel;
        this.topic = topic;
        this.isPrivate = isPrivate;
        this.isSocialMode = isSocialMode;
        this.url = url;
        this.club = club;
        this.speakersNum = speakersNum;
        this.peopleNum = peopleNum;
    }

    public String getCreatorProfileId() {
        return creatorProfileId;
    }

    public void setCreatorProfileId(String creatorProfileId) {
        this.creatorProfileId = creatorProfileId;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public boolean isSocialMode() {
        return isSocialMode;
    }

    public void setSocialMode(boolean socialMode) {
        isSocialMode = socialMode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ClubItem getClub() {
        return club;
    }

    public void setClub(ClubItem club) {
        this.club = club;
    }

    public int getSpeakersNum() {
        return speakersNum;
    }

    public void setSpeakersNum(int speakersNum) {
        this.speakersNum = speakersNum;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }
}

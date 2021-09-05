package com.alykhaled.clubhouseclone.api.responses;

import com.alykhaled.clubhouseclone.UserItem;
import com.google.gson.annotations.SerializedName;

public class CompleteAuthResponse {

    @SerializedName("success")
    public boolean success;

    @SerializedName("is_waitlisted")
    public boolean waitlisted;

    @SerializedName("user_profile")
    public UserItem user;

    @SerializedName("auth_token")
    public String authToken;

    @SerializedName("refresh_token")
    public String refreshToken;

    @SerializedName("access_token")
    public String accessToken;



}

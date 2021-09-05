package com.alykhaled.clubhouseclone.api;

import com.alykhaled.clubhouseclone.api.responses.ChannelsResponse;
import com.alykhaled.clubhouseclone.api.responses.CompleteAuthResponse;
import com.alykhaled.clubhouseclone.api.responses.StartAuthResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest{

    @POST("start_phone_number_auth")
    Call<StartAuthResponse> phoneAuth(@Body JsonObject phoneNum);

    @POST("complete_phone_number_auth")
    Call<CompleteAuthResponse> completeAuth(@Body JsonObject codeAndPhoneNum);

    @GET("get_channels")
    Call<ChannelsResponse> getChannels();
}

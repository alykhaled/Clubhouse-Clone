package com.alykhaled.clubhouseclone.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.alykhaled.clubhouseclone.UserItem;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {
    public static Retrofit retrofit;
    public static String API_BASE = "https://www.clubhouseapi.com/api/";
    public static String authToken;
    public static String accessToken;
    public static UserItem user;
    public static ApiRequest apiCall;

    public static void setValues(Context context)
    {
        SharedPreferences shared = context.getSharedPreferences("session", Context.MODE_PRIVATE);
        authToken = shared.getString("authToken",null);
        accessToken = shared.getString("accessToken",null);
    }

    public static void start() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder build = original.newBuilder()
                        .header("CH-Languages", "en_US")
                        .header("CH-Locale", "en_US")
                        .header("Accept", "application/json")
                        .header("CH-AppBuild", "304")
                        .header("CH-AppVersion", "0.1.28")
                        .header("User-Agent", "clubhouse/304 (iPhone; iOS 13.5.1; Scale/3.00)")
                        .header("CH-DeviceId", "A64D047A-1A03-494E-BA21-E0C4F8462685")
                        .header("Content-Type","application/json; charset=utf-8")
                        .method(original.method(), original.body());
                if (accessToken != null)
                {
                    build.header("Authorization","Token " + authToken);
                }
                return chain.proceed(build.build());
            }
        });
        OkHttpClient client = httpClient.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        apiCall = retrofit.create(ApiRequest.class);
    }
}

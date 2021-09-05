package com.alykhaled.clubhouseclone.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alykhaled.clubhouseclone.MainActivity;
import com.alykhaled.clubhouseclone.R;
import com.alykhaled.clubhouseclone.api.ApiRequest;
import com.alykhaled.clubhouseclone.api.ApiUtils;
import com.alykhaled.clubhouseclone.api.responses.CompleteAuthResponse;
import com.alykhaled.clubhouseclone.api.responses.StartAuthResponse;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {
    TextInputLayout phoneNumField;
    TextInputLayout codeField;
    MaterialButton nextBtn;
    boolean IsCodeSent = false;

    public LoginFragment() {

    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        phoneNumField = view.findViewById(R.id.phoneNumField);
        codeField = view.findViewById(R.id.codeField);
        nextBtn = view.findViewById(R.id.nextBtn);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("CH-Languages", "en_US")
                    .header("CH-Locale", "en_US")
                    .header("Accept", "application/json")
                    .header("CH-AppBuild", "304")
                    .header("CH-AppVersion", "0.1.28")
                    .header("User-Agent", "clubhouse/304 (iPhone; iOS 13.5.1; Scale/3.00)")
                    .header("CH-DeviceId", "A64D047A-1A03-494E-BA21-E0C4F8462685")
                    .header("Content-Type","application/json; charset=utf-8")
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.clubhouseapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        ApiRequest apiCall = retrofit.create(ApiRequest.class);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IsCodeSent)
                {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("phone_number", "+201100030143");
                    obj.addProperty("verification_code", codeField.getEditText().getText().toString());
                    Call<CompleteAuthResponse> call = apiCall.completeAuth(obj);
                    call.enqueue(new Callback<CompleteAuthResponse>() {
                        @Override
                        public void onResponse(Call<CompleteAuthResponse> call, retrofit2.Response<CompleteAuthResponse> response) {
                            if (response.code() == 200)
                            {
                                Toast.makeText(getContext(), "DONE" , Toast.LENGTH_LONG).show();
                                SharedPreferences sharedPref = getContext().getSharedPreferences("session", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("authToken", response.body().authToken);
                                editor.putString("accessToken", response.body().accessToken);
                                editor.putInt("userId", response.body().user.getUserID());
                                editor.apply();

                                Fragment fragment = new MainFragment();
                                ((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction()
                                        .setCustomAnimations(
                                                R.anim.slide_in,  // enter
                                                R.anim.fade_out,  // exit
                                                R.anim.fade_in,   // popEnter
                                                R.anim.slide_out  // popExit
                                        )
                                        .replace(R.id.mainView, fragment)
                                        .addToBackStack(null)
                                        .commit();
                            }
                            else
                            {
                                Toast.makeText(getContext(), "Check your connection" , Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CompleteAuthResponse> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                }
                else
                {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("phone_number", "+201100030143");

                    Call<StartAuthResponse> call = apiCall.phoneAuth(obj);
                    call.enqueue(new Callback<StartAuthResponse>() {
                        @Override
                        public void onResponse(Call<StartAuthResponse> call, retrofit2.Response<StartAuthResponse> response) {
                            if (response.code() == 200)
                            {
                                Toast.makeText(getContext(), "Code Sent" , Toast.LENGTH_LONG).show();
                                codeField.setVisibility(View.VISIBLE);
                                nextBtn.setText("Confirm");
                                IsCodeSent = true;
                            }
                            else
                            {
                                Toast.makeText(getContext(), "Check your connection" , Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<StartAuthResponse> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });

                }
            }
        });
        return view;
    }
}
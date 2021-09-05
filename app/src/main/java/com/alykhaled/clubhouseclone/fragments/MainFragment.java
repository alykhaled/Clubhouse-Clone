package com.alykhaled.clubhouseclone.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alykhaled.clubhouseclone.ChannelItem;
import com.alykhaled.clubhouseclone.MainActivity;
import com.alykhaled.clubhouseclone.R;
import com.alykhaled.clubhouseclone.RoomItem;
import com.alykhaled.clubhouseclone.adapters.RoomAdapter;
import com.alykhaled.clubhouseclone.api.ApiUtils;
import com.alykhaled.clubhouseclone.api.responses.ChannelsResponse;
import com.alykhaled.clubhouseclone.api.responses.CompleteAuthResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    Button searchBtn;
    RecyclerView mRoomsView;
    LinearLayoutManager RecentLayoutManager;
    List<ChannelItem> mChannelsList;
    RoomAdapter mRoomAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        searchBtn = view.findViewById(R.id.searchBtn);
        mRoomsView = view.findViewById(R.id.rooms_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager HorizontalLayout;
        HorizontalLayout = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        //Popular View
        mRoomsView.setLayoutManager(mLayoutManager);
        mRoomsView.setHasFixedSize(true);
        mRoomsView.setLayoutManager(HorizontalLayout);

        mChannelsList = new ArrayList<>();

        /*List<ChannelItem> cc = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            cc.add(mChannelsList.get(i));
        }*/

        Call<ChannelsResponse> call = ApiUtils.apiCall.getChannels();
        call.enqueue(new Callback<ChannelsResponse>() {
            @Override
            public void onResponse(Call<ChannelsResponse> call, Response<ChannelsResponse> response) {
                Toast.makeText(getContext(), "DONE" , Toast.LENGTH_LONG).show();
                mChannelsList = response.body().channels;
                mRoomAdapter = new RoomAdapter(getContext(), mChannelsList);
                mRoomsView.setAdapter(mRoomAdapter);

            }

            @Override
            public void onFailure(Call<ChannelsResponse> call, Throwable t) {
                Toast.makeText(getContext(), "FF" , Toast.LENGTH_LONG).show();

            }
        });


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SearchFragment();
                ((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_right_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.fade_in,   // popEnter
                                R.anim.slide_right_out  // popExit
                        )
                        .replace(R.id.mainView, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
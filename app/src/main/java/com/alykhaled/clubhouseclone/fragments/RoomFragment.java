package com.alykhaled.clubhouseclone.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alykhaled.clubhouseclone.R;
import com.alykhaled.clubhouseclone.UserItem;
import com.alykhaled.clubhouseclone.adapters.UsersAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoomFragment extends Fragment {

    Button allRoomsBtn;
    RecyclerView usersView;
    ArrayList<UserItem> usersList;
    public RoomFragment() {
        // Required empty public constructor
    }

    public static RoomFragment newInstance(String param1, String param2) {
        RoomFragment fragment = new RoomFragment();
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
        View view = inflater.inflate(R.layout.fragment_main_room, container, false);
        allRoomsBtn = view.findViewById(R.id.allRoomsBtn);
        usersView = view.findViewById(R.id.usersView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager HorizontalLayout;;
        HorizontalLayout = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        usersView.setLayoutManager(new GridLayoutManager(getContext(),3));
        usersList = new ArrayList<>();
        for (int i = 0; i < 15; i++)
        {
            usersList.add(new UserItem(i,"test","test","test","test",i % 2 == 0, i % 2 == 0));
        }
        usersView.setAdapter(new UsersAdapter(getContext(),usersList));
        allRoomsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();

            }
        });
        return view;
    }
}
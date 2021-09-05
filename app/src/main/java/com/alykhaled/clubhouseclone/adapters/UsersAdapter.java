package com.alykhaled.clubhouseclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alykhaled.clubhouseclone.R;
import com.alykhaled.clubhouseclone.UserItem;
import com.alykhaled.clubhouseclone.fragments.UserFragment;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<UserItem> mUsersList;

    public UsersAdapter(Context mContext, ArrayList<UserItem> mUsersList) {
        this.mContext = mContext;
        this.mUsersList = mUsersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.user_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserItem currentItem = mUsersList.get(position);
        String userName = currentItem.getName();
        String imageUrl = currentItem.getImage();
        String mState = currentItem.getState();
        boolean muted = currentItem.isMuted();
        boolean speaking = currentItem.isSpeaking();
        holder.userName.setText(userName);
        holder.micImage.setVisibility(muted ? View.VISIBLE : View.GONE);
        holder.userCardView.setStrokeWidth(speaking ? 10 : 0);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.class,mainRoomFragment.this);
                Fragment fragment = new UserFragment();
                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.fade_in,   // popEnter
                                R.anim.slide_out  // popExit
                        )
                        .add(R.id.mainView, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView userName;
        private ImageView userImage;
        private ImageView micImage;
        private MaterialCardView userCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userImage = itemView.findViewById(R.id.userImage);
            micImage = itemView.findViewById(R.id.noMicImage);
            userCardView = itemView.findViewById(R.id.userCardView);
        }

    }
}

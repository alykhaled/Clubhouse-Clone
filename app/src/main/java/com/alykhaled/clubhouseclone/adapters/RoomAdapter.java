package com.alykhaled.clubhouseclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alykhaled.clubhouseclone.ChannelItem;
import com.alykhaled.clubhouseclone.R;
import com.alykhaled.clubhouseclone.RoomItem;
import com.alykhaled.clubhouseclone.fragments.RoomFragment;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ExampleViewHolder> {
    private Context mContext;
    private List<ChannelItem> mRoomList;
    private OnItemClickListener mListener;
    private MaterialCardView currentRoom;

    public interface OnItemClickListener {
        void onItemClick(int position, ArrayList<RoomItem> t, ImageView image);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public RoomAdapter(Context context, List<ChannelItem> List, MaterialCardView currentRoom) {
        mContext = context;
        mRoomList = List;
        this.currentRoom = currentRoom;
    }

    public RoomAdapter(Context mContext, List<ChannelItem> mRoomList) {
        this.mContext = mContext;
        this.mRoomList = mRoomList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.room_item, parent, false);
        return new ExampleViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        ChannelItem currentItem = mRoomList.get(position);
        String roomName = currentItem.getTopic();
        String clubName = currentItem.getClub() == null ? "" : currentItem.getClub().getName();
        int listenersNum = currentItem.getPeopleNum();
        int speakerNum = currentItem.getSpeakersNum();

        if (clubName.equals(""))
        {
            holder.clubName.setVisibility(View.GONE);
        }
        holder.roomName.setText(roomName);
        holder.clubName.setText(clubName);
        //holder.image.setText(image);
        //holder.listenersNum.setText(listenersNum);
        //Picasso.get().load(posterurl).fit().centerInside().into(holder.mMoviePoster);
        //ViewCompat.setTransitionName(holder.mMoviePoster, currentItem.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.class,mainRoomFragment.this);
                Fragment fragment = new RoomFragment();
                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.fade_in,   // popEnter
                                R.anim.slide_out  // popExit
                        )
                        .replace(R.id.mainView, fragment)
                        .addToBackStack(null)
                        .commit();
                currentRoom.setVisibility(View.VISIBLE);
                //currentRoom.setRadius(0);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mRoomList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        private TextView roomName;
        private TextView clubName;
        private TextView image;
        private TextView listenersNum;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            roomName = itemView.findViewById(R.id.roomName);
            clubName = itemView.findViewById(R.id.clubName);
            //image = itemView.findViewById(R.id.movie_category);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position,mExampleList);
                        }
                    }
                }
            });*/
        }
    }
}
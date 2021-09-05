package com.alykhaled.clubhouseclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alykhaled.clubhouseclone.adapters.RoomAdapter;
import com.alykhaled.clubhouseclone.api.ApiUtils;
import com.alykhaled.clubhouseclone.fragments.LoginFragment;
import com.alykhaled.clubhouseclone.fragments.MainFragment;
import com.alykhaled.clubhouseclone.fragments.SearchFragment;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    MaterialCardView currentRoom;
    Button leaveRoomBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiUtils.setValues(MainActivity.this);
        ApiUtils.start();

        if (ApiUtils.accessToken == null)
        {
            Fragment fragment = new LoginFragment();
            MainActivity.this.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainView, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        else
        {
            Fragment fragment = new MainFragment();
            MainActivity.this.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainView, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        currentRoom = findViewById(R.id.currentRoomBar);
        leaveRoomBtn = findViewById(R.id.leaveRoomBtn);

        // Hide the status bar.
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

       /* ItemTouchHelper.SimpleCallback touchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            private final ColorDrawable background = new ColorDrawable(getResources().getColor(R.color.colorAccent));

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.showMenu(viewHolder.getAdapterPosition());
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                View itemView = viewHolder.itemView;

                if (dX > 0) {
                    background.setBounds(itemView.getLeft(), itemView.getTop(), itemView.getLeft() + ((int) dX), itemView.getBottom());
                } else if (dX < 0) {
                    background.setBounds(itemView.getRight() + ((int) dX), itemView.getTop(), itemView.getRight(), itemView.getBottom());
                } else {
                    background.setBounds(0, 0, 0, 0);
                }

                background.draw(c);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelperCallback);
        itemTouchHelper.attachToRecyclerView(mRoomsView);*/

        leaveRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom.setVisibility(View.GONE);
                currentRoom.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //currentRoom.setVisibility(View.GONE);
        /*float dip = 25f;
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dip,r.getDisplayMetrics());*/
        //currentRoom.setRadius(px);
        /*currentRoom.setShapeAppearanceModel(currentRoom.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopLeftCorner(CornerFamily.ROUNDED,px)
      .setTopRightCorner(CornerFamily.ROUNDED,px)
      .setBottomRightCorner(CornerFamily.ROUNDED,0)
                .setBottomLeftCornerSize(0)
                .build());*/
    }

}
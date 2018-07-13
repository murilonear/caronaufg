package caronaufg.android.com.caronaufg.history;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.menu.MenuDriverActivity;
import caronaufg.android.com.caronaufg.model.TravelDriver;
import caronaufg.android.com.caronaufg.recycler.RecyclerViewAdapter;

public class TravelHistoryDriverActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private DatabaseReference databaseReference;
    private List<TravelDriver> allRides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_history_driver);

        allRides = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView = (RecyclerView)findViewById(R.id.ride_list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        databaseReference.child("caronasMotorista").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getAllRides(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getAllRides(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        getSupportActionBar().hide();
    }

    private void getAllRides(DataSnapshot dataSnapshot){
        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            TravelDriver ride = new TravelDriver();
            ride.setBeginDriver(singleSnapshot.child("beginDriver").getValue().toString());
            ride.setGoalDriver(singleSnapshot.child("goalDriver").getValue().toString());
            ride.setDateDriver(singleSnapshot.child("dateDriver").getValue().toString());
            ride.setTime(singleSnapshot.child("time").getValue().toString());
            ride.setNumberPlaces(Integer.parseInt(singleSnapshot.child("numberPlaces").getValue().toString()));
            ride.setValueDriver(Double.parseDouble(singleSnapshot.child("valueDriver").getValue().toString()));
            allRides.add(ride);
            recyclerViewAdapter = new RecyclerViewAdapter(TravelHistoryDriverActivity.this, allRides);
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    }
}

package caronaufg.android.com.caronaufg.history;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.model.TravelPassenger;
import caronaufg.android.com.caronaufg.recycler.passenger.RecyclerViewAdapter;

public class TravelHistoryPassengerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private DatabaseReference databaseReference;
    private List<TravelPassenger> allRides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_history);

        allRides = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView = (RecyclerView)findViewById(R.id.ride_list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        databaseReference.child("caronasPassageiro").addChildEventListener(new ChildEventListener() {
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
            TravelPassenger ride = new TravelPassenger();
            ride.setBeginPassenger(singleSnapshot.child("beginPassenger").getValue().toString());
            ride.setGoalPassenger(singleSnapshot.child("goalPassenger").getValue().toString());
            ride.setDatePassenger(singleSnapshot.child("datePassenger").getValue().toString());
            ride.setTimePassenger(singleSnapshot.child("timePassenger").getValue().toString());
            allRides.add(ride);
            recyclerViewAdapter = new RecyclerViewAdapter(TravelHistoryPassengerActivity.this, allRides);
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    }

}

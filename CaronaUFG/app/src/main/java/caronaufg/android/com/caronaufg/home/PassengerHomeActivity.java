package caronaufg.android.com.caronaufg.home;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.menu.MenuPassengerActivity;
import caronaufg.android.com.caronaufg.model.TravelDriver;
import caronaufg.android.com.caronaufg.model.TravelPassenger;

public class PassengerHomeActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference travelReference = databaseReference.child("caronasPassageiro");
    private DatabaseReference idReference = travelReference.child("Id");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_home);
        getSupportActionBar().hide();
        setupButtonSavePassengerConfig();
    }

    private void registerTravel(String begin, String goal, String datePassenger, String time){
        TravelPassenger travelPassenger = new TravelPassenger();
        travelPassenger.setBeginPassenger(begin);
        travelPassenger.setGoalPassenger(goal);
        travelPassenger.setDatePassenger(datePassenger);
        travelPassenger.setTimePassenger(time);

        database = FirebaseDatabase.getInstance();
        String key = idReference.push().getKey();
        idReference.child(key).setValue(travelPassenger);
    }

    private void setupButtonSavePassengerConfig(){
        final TextInputEditText beginPassenger = findViewById(R.id.beginPassengerId);
        final TextInputEditText goalPassenger = findViewById(R.id.goalPassengerId);
        final TextInputEditText datePassenger = findViewById(R.id.datePassengerId);
        final TextInputEditText timePassenger = findViewById(R.id.timePassengerId);
        Button savePassenger = findViewById(R.id.savePassengerConfigId);

        savePassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerTravel(beginPassenger.getText().toString(),goalPassenger.getText().toString(),datePassenger.getText().toString(), timePassenger.getText().toString());
                Toast.makeText(PassengerHomeActivity.this,"Salvando alterações",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PassengerHomeActivity.this,MenuPassengerActivity.class));
            }
        });

    }
}

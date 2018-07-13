package caronaufg.android.com.caronaufg.home;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.menu.MenuDriverActivity;
import caronaufg.android.com.caronaufg.model.TravelDriver;


public class DriverHomeActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference travelReference = databaseReference.child("caronasMotorista");
    private DatabaseReference idReference = travelReference.child("Id");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_home);
        getSupportActionBar().hide();
        setupSaveDriverConfig();
    }
    private void registerTravel(String begin, String goal, String dateDriver, String time, int numberPlaces, double valueDriver){
        TravelDriver travelDriver = new TravelDriver();
        travelDriver.setBeginDriver(begin);
        travelDriver.setGoalDriver(goal);
        travelDriver.setDateDriver(dateDriver);
        travelDriver.setNumberPlaces(numberPlaces);
        travelDriver.setValueDriver(valueDriver);
        travelDriver.setTime(time);
        database = FirebaseDatabase.getInstance();
        String key = idReference.push().getKey();
        idReference.child(key).setValue(travelDriver);
    }
    private void setupSaveDriverConfig() {
        final TextInputEditText beginDriver = findViewById(R.id.beginDriverId);
        final TextInputEditText goalDriver = findViewById(R.id.goalDriverId);
        final TextInputEditText dateDriver = findViewById(R.id.dateDriverId);
        final TextInputEditText horaryDriver = findViewById(R.id.timeDriverId);
        final TextInputEditText numberPlaces = findViewById(R.id.numberPlaceDriverId);
        final TextInputEditText valueDriver = findViewById(R.id.valueDriverId);
        Button saveDriverConfig = findViewById(R.id.saveDriverConfigId);
        saveDriverConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final double value = Double.parseDouble(valueDriver.getText().toString());
                final int places = Integer.parseInt(numberPlaces.getText().toString());
                final String date = dateDriver.getText().toString();
                registerTravel(beginDriver.getText().toString(),goalDriver.getText().toString(),date, horaryDriver.getText()
                    .toString(), places, value);
                Toast.makeText(DriverHomeActivity.this, "Carona salva com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DriverHomeActivity.this, MenuDriverActivity.class));
            }
        });
    }
}

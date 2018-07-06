package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import caronaufg.android.com.caronaufg.R;

public class PassengerHomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_home);
        getSupportActionBar().hide();
        setupButtonSavePassengerConfig();
    }
    private void setupButtonSavePassengerConfig(){
        TextInputEditText beginPassenger = findViewById(R.id.beginPassengerId);
        TextInputEditText goalPassenger = findViewById(R.id.goalPassengerId);
        TextInputEditText horaryPassenger = findViewById(R.id.horaryPassengerId);
        TextInputEditText datePassenger = findViewById(R.id.datePassengerId);
        Button savePassenger = findViewById(R.id.savePassengerConfigId);

        savePassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PassengerHomeActivity.this,"Salvando alterações",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PassengerHomeActivity.this,MenuPassengerActivity.class));
            }
        });

    }
}

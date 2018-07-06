package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

import caronaufg.android.com.caronaufg.R;

public class DriverHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_home);
        getSupportActionBar().hide();
        setupSaveDriverConfig();
    }

    private void setupSaveDriverConfig() {
        TextInputEditText beginDriver = findViewById(R.id.beginDriverId);
        TextInputEditText goalDriver = findViewById(R.id.goalDriverId);
        TextInputEditText dateDriver = findViewById(R.id.dateDriverId);
        TextInputEditText horaryDriver = findViewById(R.id.horaryDriverId);
        TextInputEditText numberPlaces = findViewById(R.id.numberPlaceDriverId);
        TextInputEditText valueDriver = findViewById(R.id.valueDriverId);
        Button saveDriverConfig = findViewById(R.id.saveDriverConfigId);
        saveDriverConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DriverHomeActivity.this, "Salvando alterações", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DriverHomeActivity.this, MenuDriverActivity.class));
            }
        });
    }
}

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

    private TextInputEditText beginDriver;
    private TextInputEditText goalDriver;
    private TextInputEditText dateDriver;
    private TextInputEditText horaryDriver;
    private TextInputEditText numberPlaces;
    private TextInputEditText valueDriver;
    private Button saveDriverConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_home);
        getSupportActionBar().hide();

        beginDriver = findViewById(R.id.beginDriverId);
        goalDriver = findViewById(R.id.goalDriverId);
        dateDriver = findViewById(R.id.dateDriverId);
        horaryDriver = findViewById(R.id.horaryDriverId);
        numberPlaces = findViewById(R.id.numberPlaceDriverId);
        valueDriver = findViewById(R.id.valueDriverId);
        saveDriverConfig = findViewById(R.id.saveDriverConfigId);

        saveDriverConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DriverHomeActivity.this,"Salvando alterações",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DriverHomeActivity.this,MenuDriverActivity.class));
            }
        });
    }
}

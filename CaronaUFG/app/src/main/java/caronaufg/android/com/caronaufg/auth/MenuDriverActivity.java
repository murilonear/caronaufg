package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import caronaufg.android.com.caronaufg.R;

public class MenuDriverActivity extends AppCompatActivity {

    private TextView nameMenuDrive;
    private Button changeForPassenger;
    private Button waitPassenger;
    private Button mySchedulesDriver;
    private Button travelHistoryDriver;
    private Button changeProfileMenuDriver;
    private Button leaveMenuDriver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_driver);
        getSupportActionBar().hide();
        nameMenuDrive = findViewById(R.id.nameMenuDriveId);
        nameMenuDrive.setText("Motorista: Teste");

        changeForPassenger = findViewById(R.id.changeForPassengerId);
        waitPassenger = findViewById(R.id.waitPassengerId);
        mySchedulesDriver = findViewById(R.id.mySchedulesDriverId);
        travelHistoryDriver = findViewById(R.id.travelHistoryMenuDriverId);
        changeProfileMenuDriver = findViewById(R.id.changeProfileMenuDriverId);
        leaveMenuDriver = findViewById(R.id.leaveMenuDriverId);

        changeProfileMenuDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuDriverActivity.this,ChangeProfileActivity.class));
            }
        });

        leaveMenuDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuDriverActivity.this,"Efetuando logout",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MenuDriverActivity.this,LoginActivity.class));
            }
        });
        mySchedulesDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuDriverActivity.this,DriverHomeActivity.class));
            }
        });
        travelHistoryDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuDriverActivity.this,TravelHistoryDriverActivity.class));
            }
        });
        changeForPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuDriverActivity.this,ProfileOptionActivity.class));
            }
        });

    }
}

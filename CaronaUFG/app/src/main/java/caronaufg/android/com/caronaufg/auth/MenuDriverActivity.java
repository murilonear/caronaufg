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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_driver);
        getSupportActionBar().hide();
        setupButtonChangeForPassenger();
        setupButtonChangeProfileMenuDriver();
        setupButtonLeaveMenuDriver();
        setupButtonMySchedulesDriver();
        setupButtonTravelHistoryDriver();
    }

    private void setupButtonChangeProfileMenuDriver() {
        Button changeProfileMenuDriver = findViewById(R.id.changeProfileMenuDriverId);
        changeProfileMenuDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuDriverActivity.this, ChangeProfileActivity.class));
            }
        });

    }

    private void setupButtonMySchedulesDriver() {
        Button myShedulesDriver = findViewById(R.id.mySchedulesDriverId);
        myShedulesDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuDriverActivity.this, DriverHomeActivity.class));
            }
        });


    }

    private void setupButtonTravelHistoryDriver() {
        Button travelHistoryDriver = findViewById(R.id.travelHistoryMenuDriverId);
        travelHistoryDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuDriverActivity.this, TravelHistoryDriverActivity.class));
            }
        });

    }

    private void setupButtonLeaveMenuDriver() {
        Button leaveMenuDriver = findViewById(R.id.leaveMenuDriverId);
        leaveMenuDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuDriverActivity.this, "Efetuando logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MenuDriverActivity.this, LoginActivity.class));
            }
        });

    }

    private void setupButtonChangeForPassenger() {
        Button changeForPassenger = findViewById(R.id.changeForPassengerId);
        changeForPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuDriverActivity.this, ProfileOptionActivity.class));
            }
        });

    }
    private void setupNameMenuDriver(){
        TextView nameMenuDriver = findViewById(R.id.nameMenuDriveId);
        // Nome temporário, este nome irá ser alterado dinamicamente com o usuário
        nameMenuDriver.setText("Motorista"+": "+"Teste");

    }
}

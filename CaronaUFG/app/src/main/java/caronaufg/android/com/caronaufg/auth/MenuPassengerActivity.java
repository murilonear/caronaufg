package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import caronaufg.android.com.caronaufg.R;

public class MenuPassengerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_passenger);
        getSupportActionBar().hide();
        setupButtonChangeForDriver();
        setupButtonChangeProfileMenuPassenger();
        setupButtonLeaveMenuPassenger();
        setupButtonRequestPassenger();
        setupButtonTravelHistoryMenuPassenger();
        setupNameMenuPassenger();
    }

    private void setupButtonLeaveMenuPassenger() {
        Button leaveMenuPassenger = findViewById(R.id.leaveMenuPassengerId);
        leaveMenuPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this, LoginActivity.class));
            }
        });

    }

    private void setupButtonTravelHistoryMenuPassenger() {
        Button travelHistoryMenuPassenger = findViewById(R.id.travelHistoryMenuPassengerId);
        travelHistoryMenuPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this, TravelHistoryPassengerActivity.class));
            }
        });

    }

    private void setupButtonRequestPassenger() {
        Button requestPassenger = findViewById(R.id.requestPassengerId);
        requestPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this, PassengerHomeActivity.class));
            }
        });

    }

    private void setupButtonChangeForDriver() {
        Button changeForDriver = findViewById(R.id.changeForDriverId);
        changeForDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this, ProfileOptionActivity.class));
            }
        });

    }

    private void setupButtonChangeProfileMenuPassenger() {
        Button changeProfileMenuPassenger = findViewById(R.id.changeProfileMenuPassengerId);
        changeProfileMenuPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this, ChangeProfileActivity.class));
            }
        });

    }

    private void setupNameMenuPassenger() {
        TextView nameMenuPassenger = findViewById(R.id.nameMenuPassengerId);
        // nome temporário, este nome irá ser alterado dinamicamente com o usuário
        nameMenuPassenger.setText("Passageiro" + ": " + "Teste");

    }
}

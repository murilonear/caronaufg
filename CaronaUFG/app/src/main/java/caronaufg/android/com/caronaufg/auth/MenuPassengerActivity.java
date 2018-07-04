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


    private TextView nameMenuPassenger;
    private Button changeForDriver;
    private Button requestPassenger;
    private Button travelHistoryMenuPassenger;
    private Button changeProfileMenuPassenger;
    private Button leaveMenuPassenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_passenger);
        getSupportActionBar().hide();

        nameMenuPassenger = findViewById(R.id.nameMenuPassengerId);
        changeForDriver = findViewById(R.id.changeForDriverId);
        requestPassenger = findViewById(R.id.requestPassengerId);
        travelHistoryMenuPassenger = findViewById(R.id.travelHistoryMenuPassengerId);
        changeProfileMenuPassenger = findViewById(R.id.changeProfileMenuPassengerId);
        leaveMenuPassenger = findViewById(R.id.leaveMenuPassengerId);

        changeProfileMenuPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this,ChangeProfileActivity.class));
            }
        });
        leaveMenuPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this, LoginActivity.class));
            }
        });
        requestPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this,PassengerHomeActivity.class));
            }
        });
        changeForDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this, ProfileOptionActivity.class));
            }
        });
        travelHistoryMenuPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPassengerActivity.this,TravelHistoryPassengerActivity.class));
            }
        });
    }
}

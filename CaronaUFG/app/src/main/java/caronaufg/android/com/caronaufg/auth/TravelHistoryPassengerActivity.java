package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import caronaufg.android.com.caronaufg.R;

public class TravelHistoryPassengerActivity extends AppCompatActivity {

    private ListView historyPassenger;
    private Button backToMenuHistoryPassenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_history_passenger);
        getSupportActionBar().hide();

        historyPassenger = findViewById(R.id.listViewHistoryPassengerId);
        backToMenuHistoryPassenger = findViewById(R.id.backToMenuHistoryPassengerId);
        backToMenuHistoryPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TravelHistoryPassengerActivity.this,MenuPassengerActivity.class));
            }
        });
    }
}

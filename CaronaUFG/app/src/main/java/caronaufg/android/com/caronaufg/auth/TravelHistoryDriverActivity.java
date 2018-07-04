package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import caronaufg.android.com.caronaufg.R;

public class TravelHistoryDriverActivity extends AppCompatActivity {

    private ListView historyDriver;
    private Button backMenuHistoryDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_history_driver);
        getSupportActionBar().hide();

        historyDriver = findViewById(R.id.listViewHistoryDriverId);
        backMenuHistoryDriver = findViewById(R.id.backMenuHistoryDriverId);
        backMenuHistoryDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TravelHistoryDriverActivity.this,MenuDriverActivity.class));
            }
        });
    }
}

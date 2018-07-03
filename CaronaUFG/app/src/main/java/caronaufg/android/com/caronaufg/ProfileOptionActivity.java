package caronaufg.android.com.caronaufg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileOptionActivity extends AppCompatActivity {


    private TextView userNameProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_option);
        getSupportActionBar().hide();
        userNameProfile = findViewById(R.id.userNameProfileId);
        userNameProfile.setText("Teste");

    }
}

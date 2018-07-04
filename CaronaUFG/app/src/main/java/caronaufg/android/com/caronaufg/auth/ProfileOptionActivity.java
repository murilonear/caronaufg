package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import caronaufg.android.com.caronaufg.R;

public class ProfileOptionActivity extends AppCompatActivity {


    private TextView userNameProfile;
    private Button giveOption;
    private Button needOption;
    private Button leaveOptionProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_option);
        getSupportActionBar().hide();
        userNameProfile = findViewById(R.id.userNameProfileId);
        userNameProfile.setText("Teste");

        giveOption = findViewById(R.id.buttonGiveOptionId);
        needOption = findViewById(R.id.buttonNeedOptionId);
        leaveOptionProfile = findViewById(R.id.leaveOptionProfileId);

        giveOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileOptionActivity.this,MenuDriverActivity.class));
            }
        });

        leaveOptionProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileOptionActivity.this,"Efetuando logout",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileOptionActivity.this,LoginActivity.class));
            }
        });
        needOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileOptionActivity.this,MenuPassengerActivity.class));
            }
        });
    }
}

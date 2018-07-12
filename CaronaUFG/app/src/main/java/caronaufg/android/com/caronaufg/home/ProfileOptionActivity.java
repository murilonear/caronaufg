package caronaufg.android.com.caronaufg.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.auth.LoginActivity;
import caronaufg.android.com.caronaufg.menu.MenuDriverActivity;
import caronaufg.android.com.caronaufg.menu.MenuPassengerActivity;
public class ProfileOptionActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_option);
        getSupportActionBar().hide();
        setupButtonGiveOption();
        setupButtonLeaveOptionProfile();
        setupButtonNeedOption();
        setupNameTextProfileOption();
    }

    private void setupButtonLeaveOptionProfile() {
        Button leaveOptionProfile = findViewById(R.id.leaveOptionProfileId);
        leaveOptionProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Toast.makeText(ProfileOptionActivity.this, "Efetuando logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileOptionActivity.this, LoginActivity.class));
            }
        });

    }

    private void setupButtonGiveOption() {
        Button giveOption = findViewById(R.id.buttonGiveOptionId);
        giveOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileOptionActivity.this, MenuDriverActivity.class));
            }
        });

    }

    private void setupButtonNeedOption() {
        Button needOption = findViewById(R.id.buttonNeedOptionId);
        needOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileOptionActivity.this, MenuPassengerActivity.class));
            }
        });

    }

    private void setupNameTextProfileOption() {
        TextView userNameProfile = findViewById(R.id.userNameProfileId);
        userNameProfile.setText("Teste"); // Nome temporário, este nome será alterado dinamicamente
    }
}


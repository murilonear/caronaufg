package caronaufg.android.com.caronaufg.menu;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.home.ProfileOptionActivity;

public class ChangeProfileActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        getSupportActionBar().hide();
        setupChangeProfile();
        getData();
    }

    private void setupChangeProfile() {
        TextInputEditText changeEmail = findViewById(R.id.changeEmailId);
        TextInputEditText changeCourse = findViewById(R.id.changeCourseId);
        TextInputEditText currentPass = findViewById(R.id.currentPasswordId);
        Button changeSave = findViewById(R.id.buttonChangeSaveId);

        changeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Alterações salvas com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ChangeProfileActivity.this, ProfileOptionActivity.class));
            }
        });
    }

    private void getData() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();

        String userEmail = (firebaseUser != null) ? firebaseUser.getEmail() : "Convidado";
        TextView userEmailProfile = findViewById(R.id.changeEmailId);
        userEmailProfile.setText(userEmail);
    }
}

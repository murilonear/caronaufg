package caronaufg.android.com.caronaufg.menu;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.home.ProfileOptionActivity;

public class ChangeProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        getSupportActionBar().hide();
        setupChangeProfile();
    }

    private void setupChangeProfile() {
        TextInputEditText changeName = findViewById(R.id.changeNameId);
        TextInputEditText changeEmail = findViewById(R.id.changeEmailId);
        TextInputEditText changeCourse = findViewById(R.id.changeCourseId);
        TextInputEditText currentPass = findViewById(R.id.currentPasswordId);
        Button changeSave = findViewById(R.id.buttonChangeSaveId);

        changeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Alterações salvas", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ChangeProfileActivity.this, ProfileOptionActivity.class));
            }
        });
    }
}

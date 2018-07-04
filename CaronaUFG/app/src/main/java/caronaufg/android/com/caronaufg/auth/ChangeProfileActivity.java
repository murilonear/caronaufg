package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import caronaufg.android.com.caronaufg.R;

public class ChangeProfileActivity extends AppCompatActivity {
    private TextInputEditText changeName;
    private TextInputEditText changeEmail;
    private TextInputEditText changeCourse;
    private TextInputEditText currentPass;
    private TextInputEditText newPass;
    private Button changeSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        getSupportActionBar().hide();

        changeName = findViewById(R.id.changeNameId);
        changeEmail = findViewById(R.id.changeEmailId);
        changeCourse = findViewById(R.id.changeCourseId);
        currentPass = findViewById(R.id.currentPasswordId);
        changeSave = findViewById(R.id.buttonChangeSaveId);

        changeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChangeProfileActivity.this,"Alterações salvas",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ChangeProfileActivity.this,ProfileOptionActivity.class));
            }
        });
    }
}

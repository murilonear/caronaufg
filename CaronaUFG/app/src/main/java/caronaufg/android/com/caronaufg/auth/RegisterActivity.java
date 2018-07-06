package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import caronaufg.android.com.caronaufg.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        setupButtonRegister();
    }

    private void setupButtonRegister() {
        TextInputEditText userEmailRegister = findViewById(R.id.userEmailRegisterId);
        TextInputEditText userLoginRegister = findViewById(R.id.userLoginRegisterId);
        TextInputEditText userNameRegister = findViewById(R.id.userNameRegisterId);
        TextInputEditText userPassRegister = findViewById(R.id.userPasswordRegisterId);
        Button buttonRegister = findViewById(R.id.buttonNewRegisterId);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}

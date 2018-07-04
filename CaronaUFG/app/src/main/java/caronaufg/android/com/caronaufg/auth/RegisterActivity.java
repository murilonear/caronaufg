package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import caronaufg.android.com.caronaufg.R;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText userLoginRegister;
    private TextInputEditText userPassRegister;
    private TextInputEditText userEmailRegister;
    private TextInputEditText userNameRegister;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        userEmailRegister = findViewById(R.id.userEmailRegisterId);
        userLoginRegister = findViewById(R.id.userLoginRegisterId);
        userNameRegister = findViewById(R.id.userNameRegisterId);
        userPassRegister = findViewById(R.id.userPasswordRegisterId);
        buttonRegister = findViewById(R.id.buttonNewRegisterId);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"Cadastro realizado com sucesso",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}

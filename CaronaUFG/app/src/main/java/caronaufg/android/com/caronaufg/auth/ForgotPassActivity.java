package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import caronaufg.android.com.caronaufg.R;

public class ForgotPassActivity extends AppCompatActivity {
    private TextInputEditText userEmailForgot;
    private TextInputEditText userLoginForgot;
    private Button forgotSend;
    private Button forgotToRegister;
    private Button forgotToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        getSupportActionBar().hide();

        userEmailForgot = findViewById(R.id.userEmailForgotId);
        userLoginForgot = findViewById(R.id.userLoginForgotId);
        forgotSend = findViewById(R.id.buttonForgotSendId);
        forgotToLogin = findViewById(R.id.buttonForgotToLoginId);
        forgotToRegister = findViewById(R.id.buttonForgotToRegisterId);

        forgotSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgotPassActivity.this,"Enviado para o email de cadastro", Toast.LENGTH_SHORT).show();
            }
        });
        forgotToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassActivity.this, LoginActivity.class));
            }
        });
        forgotToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassActivity.this,RegisterActivity.class));
            }
        });
    }
}

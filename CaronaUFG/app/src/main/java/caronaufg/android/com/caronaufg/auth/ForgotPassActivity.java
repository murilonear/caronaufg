package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import caronaufg.android.com.caronaufg.R;

public class ForgotPassActivity extends AppCompatActivity {
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        getSupportActionBar().hide();
        setupButtonForgotSend();
        setupButtonForgotToLogin();
        setupButtonForgotToRegister();
    }

    private void setupButtonForgotSend() {
        final TextInputEditText userEmailForgot = findViewById(R.id.userEmailForgotId);
        Button forgotSend = findViewById(R.id.buttonForgotSendId);
        forgotSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.sendPasswordResetEmail(userEmailForgot.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            userEmailForgot.setText("");
                            Toast.makeText(ForgotPassActivity.this, "Email enviado com sucesso!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void setupButtonForgotToLogin() {
        Button forgotToLogin = findViewById(R.id.buttonForgotToLoginId);
        forgotToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassActivity.this, LoginActivity.class));
            }
        });
    }

    private void setupButtonForgotToRegister() {
        Button forgotToRegister = findViewById(R.id.buttonForgotToRegisterId);
        forgotToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassActivity.this, RegisterActivity.class));
            }
        });

    }
}

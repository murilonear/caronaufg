package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.home.ProfileOptionActivity;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    MaterialDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        setupButtonRegister();
        setupButtonForgotPassword();
        setupButtonLogin();
    }

    private void userLogin(String email, String password) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.i("signIn", "Sucesso ao fazer login do usuário");
                            startActivity(new Intent(LoginActivity.this, ProfileOptionActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show();
                            Log.i("signIn", "Falha ao fazer login do usuário");
                        }
                    }
                });
    }

    private void setupButtonLogin() {
        final TextInputEditText userEmailLogin = findViewById(R.id.userEmailLoginId);
        final TextInputEditText userPasswordLogin = findViewById(R.id.userPasswordLoginId);
        Button buttonUserLogin = findViewById(R.id.buttonLoginId);
        buttonUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                userLogin(userEmailLogin.getText().toString(),userPasswordLogin.getText().toString());
                hideLoading();
            }
        });

    }

    private void setupButtonForgotPassword() {
        Button buttonForgotPassword = findViewById(R.id.buttonForgotPassLoginId);
        buttonForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgotPassActivity.class));
            }
        });
    }

    private void setupButtonRegister() {
        Button buttonRegister = findViewById(R.id.buttonRegisterLoginId);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

            }
        });
    }


    private void showLoading() {
        dialog = new MaterialDialog.Builder(this)
                .content(R.string.label_wait)
                .progress(true, 0)
                .cancelable(false)
                .show();
    }

    private void hideLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.hide();
            dialog = null;
        }
    }
}

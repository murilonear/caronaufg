package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.web.WebError;
import caronaufg.android.com.caronaufg.web.WebTaskLogin;

public class LoginActivity extends AppCompatActivity {

    MaterialDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        setupLogin();
        setupButtonRegister();
        setupButtonForgotPassword();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
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

    private void setupLogin() {
        Button buttonLogin = findViewById(R.id.buttonLoginId);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryLogin();
            }
        });
    }

    private void tryLogin() {
        EditText userLogin = findViewById(R.id.userLoginId);
        EditText userPasswordLogin = findViewById(R.id.userPasswordLoginId);
     /* String loginDB = userLogin.getText().toString();
        String passDB = userPasswordLogin.getText().toString();
        SQLiteDatabase bancoDados = openOrCreateDatabase("bdLocal",MODE_PRIVATE,null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS usuario(login VARCHAR, password VARCHAR)");
        bancoDados.execSQL("INSERT INTO usuario(login,password) VALUES (loginDB,passDB)");
        Cursor cursor = bancoDados.rawQuery("SELECT login, password FROM usuario",null);
        int indiceColunaLogin = cursor.getColumnIndex("login");
        int indiceColunaPassword = cursor.getColumnIndex("password");
        cursor.moveToFirst();
        Log.i("Resultado - Login:", cursor.getString(indiceColunaLogin));
        Log.i("Resultado - Password", cursor.getString(indiceColunaPassword));
   */
        if (!"".equals(userLogin.getText().toString())) {
            showLoading();
            sendCredentials(userLogin.getText().toString(), userPasswordLogin.getText().toString());
            startActivity(new Intent(getApplicationContext(), ProfileOptionActivity.class)); // Temporário, so para fazer o login
        }
        userLogin.setError("Preencha o campo nome de usuário");
    }

    private void showLoading() {
        dialog = new MaterialDialog.Builder(this)
                .content(R.string.label_wait)
                .progress(true, 0)
                .cancelable(false)
                .show();
    }

    private void sendCredentials(String login, String pass) {
        WebTaskLogin taskLogin = new WebTaskLogin(this, login, pass);
        taskLogin.execute();
    }

    @Subscribe
    public void onEvent(String response) {
        hideLoading();
        Intent openUrlIntent = new Intent(Intent.ACTION_VIEW);
        openUrlIntent.setData(
                Uri.parse("http://www.freescreencleaner.com/"));
        startActivity(openUrlIntent);
    }

    @Subscribe
    public void onEvent(WebError error) {
        hideLoading();
        Snackbar.make(findViewById(R.id.container),
                error.getMessage(),
                Snackbar.LENGTH_LONG).show();
    }

    private void hideLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.hide();
            dialog = null;
        }
    }
}

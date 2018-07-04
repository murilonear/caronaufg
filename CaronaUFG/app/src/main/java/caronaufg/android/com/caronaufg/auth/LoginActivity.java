package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import caronaufg.android.com.caronaufg.R;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText userLogin;
    private TextInputEditText userPass;
    private Button buttonLogin;
    private Button buttonForgetPassLogin;
    private Button buttonRegisterLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        userLogin = findViewById(R.id.userLoginId);
        userPass = findViewById(R.id.userPasswordId);
        buttonLogin = findViewById(R.id.buttonLoginId);
        buttonForgetPassLogin = findViewById(R.id.buttonForgotId);
        buttonRegisterLogin = findViewById(R.id.buttonRegisterId);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ProfileOptionActivity.class));
            }
        });

        buttonRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        buttonForgetPassLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
            }
        });
         /* String teste = userLogin.getText();
        String teste2 = userPass.getText();
        SQLiteDatabase bancoDados = openOrCreateDatabase("app",MODE_PRIVATE,null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS usuarios(login VARCHAR,password VARCHAR)");
        bancoDados.execSQL("INSERT INTO usuario(login,password) VALUE (teste,teste2);

        Cursor cursor = bancoDados.rawQuery("SELECT login, password FROM usuarios", null);
        int indiceColunaLogin = cursor.getColumnIndex("login");
        int indiceColunaPassword = cursor.getColumnIndex("password");
        cursor.moveToFirst();
        while(cursor!=null){
        Log.i("Resultado - login:",cursor.getString(indiceColunaLogin));
        Log.i("Resultado - Password:",cursor.getString(indiceColunaPassword);

        }

        */


    }




}

package caronaufg.android.com.caronaufg.auth;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import caronaufg.android.com.caronaufg.R;
import caronaufg.android.com.caronaufg.model.User;
public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference userReference = databaseReference.child("usuarios").child("Id");
    private DatabaseReference idReference = databaseReference.child("usuarios");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        setupButtonRegister();
    }
    private  void registerUser(String nome, String email, String password){
        User user = new User();
        user.setNome(nome);
        user.setEmail(email);
        userReference.child("002").setValue(user);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   Log.i("createUser","Cadastro realizado com sucesso");
               }else{
                   Log.i("createUser", "Falha ao realizar o cadastro");
               }
            }
        });
    }

    private void setupButtonRegister() {
        final TextInputEditText userEmailRegister = findViewById(R.id.userEmailRegisterId);
        final TextInputEditText userNameRegister = findViewById(R.id.userNameRegisterId);
        final TextInputEditText userPassRegister = findViewById(R.id.userPasswordRegisterId);
        Button buttonRegister = findViewById(R.id.buttonNewRegisterId);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(userNameRegister.getText().toString(),userEmailRegister.getText().toString(),userPassRegister.getText().toString());
                Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}

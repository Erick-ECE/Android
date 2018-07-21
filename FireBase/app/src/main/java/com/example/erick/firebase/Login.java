package com.example.erick.firebase;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.LENGTH_LONG;

public class Login extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    Button in;
    TextInputLayout mail;
    TextInputLayout passw;
    FirebaseAuth auth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail = findViewById(R.id.user);
        passw = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
        in = findViewById(R.id.btn_login);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        completeAuth(user);
    }

    public void login(View view){
        String eemail = mail.getEditText().getText().toString();
        String pswrd = passw.getEditText().getText().toString();

        if (!validate(eemail,pswrd)){
            completeAuth(null);
            return;
        }
        in.setEnabled(false);
        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setMessage("Espere...");
        progressDialog.show();
        authentication(eemail,pswrd);
    }



    public boolean validate(String email, String password){
        boolean esValido = true;
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            esValido = false;
            mail.setError("correo invalido");
        }
        else {
            mail.setError(null);
        }

        if (password.isEmpty() || password.length() < 3 || password.length()>10){
            esValido = false;
            passw.setError("contraseña invalida");
        }else {passw.setError(null);}

        return esValido;
    }

    /**
     * Método para la autenticación con firebase, comprueba y verifica el ingreso correcto de las credenciales y
     * @param email del usuario obtenido apartir del EditText
     * @param password del usuario obtenido apartir del EditText
     */
    private void authentication(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            progressDialog.dismiss();
                                            FirebaseUser user = auth.getCurrentUser();
                                            completeAuth(user);
                                        }
                                    }, 2000);

                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            progressDialog.dismiss();
                                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                                            completeAuth(null);
                                        }
                                    }, 2000);
                        }

                    }
                });

    }

    private void completeAuth(FirebaseUser user) {
        if (user != null) {
            finish();
        } else {
            in.setEnabled(true);
        }
    }



    @Override
    public void onBackPressed() {
        moveTaskToBack(false);

    }
}

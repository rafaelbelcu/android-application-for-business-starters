package com.example.belcurafaelstefanapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView createAccount;
    private EditText editTextEmailadress, editTextPassword;
    private Button signInButton;
    private ProgressBar loading;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAccount = (TextView) findViewById(R.id.createAccount);
        createAccount.setOnClickListener(this);
        editTextEmailadress = (EditText) findViewById(R.id.emailAdress);
        editTextPassword = (EditText) findViewById(R.id.password);
        signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);
        loading = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createAccount:
                startActivity(new Intent(this, UserRegistration.class));
                break;
            case R.id.signInButton:
                loginUser();
                break;
        }
    }

    private void loginUser() {
        String emailAdressText = editTextEmailadress.getText().toString().trim();
        String passwordText = editTextPassword.getText().toString().trim();
        if (emailAdressText.isEmpty()) {
            editTextEmailadress.setError("Please enter your Email adress!");
            editTextEmailadress.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAdressText).matches()){
            editTextEmailadress.setError("Please provide a valid Email adress!");
            editTextEmailadress.requestFocus();
            return;
        }
        if (passwordText.isEmpty()){
            editTextPassword.setError("Please enter your Password!");
            editTextPassword.requestFocus();
            return;
        }
        if (passwordText.length() < 6){
            editTextPassword.setError("The minimum password length must be 6 characters!");
            editTextPassword.requestFocus();
            return;
        }
        loading.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(emailAdressText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(MainActivity.this, Menu.class));
                } else {
                    Toast.makeText(MainActivity.this, "Failed to login! Please check your credentials and try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
package com.example.belcurafaelstefanapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegistration extends AppCompatActivity implements View.OnClickListener {
    private TextView signIn, userRegistration;
    private EditText editTextUsername, editTextEmailadress, editTextPassword;
    private ProgressBar loading;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        signIn = (TextView) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);
        userRegistration = (Button) findViewById(R.id.userRegistrationButton);
        userRegistration.setOnClickListener(this);
        editTextUsername = (EditText) findViewById(R.id.username);
        editTextEmailadress = (EditText) findViewById(R.id.emailadress);
        editTextPassword = (EditText) findViewById(R.id.password);
        loading = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signIn:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.userRegistrationButton:
                userRegistration();
                break;
        }
    }

    private void userRegistration() {
        String username = editTextUsername.getText().toString().trim();
        String emailadress = editTextEmailadress.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (username.isEmpty()) {
            editTextUsername.setError("Please enter your username!");
            editTextUsername.requestFocus();
            return;
        }
        if (emailadress.isEmpty()) {
            editTextEmailadress.setError("Please enter your Email adress!");
            editTextEmailadress.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailadress).matches()) {
            editTextEmailadress.setError("Please provide a valid Email adress!");
            editTextEmailadress.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Please enter your Password!");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("The minimum password length is 6 characters!");
            editTextPassword.requestFocus();
            return;
        }
        loading.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(emailadress, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(username, emailadress);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(UserRegistration.this, "The user has been successfully registered", Toast.LENGTH_LONG).show();
                                        loading.setVisibility(View.VISIBLE);
                                    } else {
                                        Toast.makeText(UserRegistration.this, "Unable to register at the moment. Please Try Again!", Toast.LENGTH_LONG).show();
                                        loading.setVisibility(View.GONE);
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(UserRegistration.this, "Failed to register", Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);
                        }
                    }
                });
    }
}
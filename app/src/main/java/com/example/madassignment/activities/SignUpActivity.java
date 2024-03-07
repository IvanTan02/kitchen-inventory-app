package com.example.madassignment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.madassignment.DBHelper;
import com.example.madassignment.R;

public class SignUpActivity extends AppCompatActivity {

    EditText username, password, rePassword;
    Button btnSignUp;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bottom_nav_blue)));

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        rePassword = (EditText) findViewById(R.id.rePassword);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        db = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String rePass = rePassword.getText().toString();
                if (user.equals("") || pass.equals("") || rePass.equals(""))
                    Toast.makeText(SignUpActivity.this, "Please fill in all required fields with valid information.", Toast.LENGTH_LONG).show();
                else {
                    if (pass.equals(rePass)) {
                        Boolean validateUsername = db.validateUsername(user);
                        if (!validateUsername) {
                            Boolean insert = db.insertUser(user, pass);
                            if (insert) {
                                Toast.makeText(SignUpActivity.this, "SignUp Success. Please log in with the account created.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else
                                Toast.makeText(SignUpActivity.this, "Registration is Failed.", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(SignUpActivity.this, "Username has been taken. Please try another one.", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(SignUpActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

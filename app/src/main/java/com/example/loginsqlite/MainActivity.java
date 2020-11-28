package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables
    EditText username, password, repassword;
    TextView forgot;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization of the variables
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        forgot = (TextView) findViewById(R.id.btnforgot);

        DB = new DBHelper(this);

        //When the person click on the button sign up
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                //si un des champs est vide
                if (user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            //if data has been inserted it will switch to Home Activity
                            if (insert==true){
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();


                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        //When the person click on the button sign in
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //permet d'aller à la page LoginActivity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        //When the person click on the button Forgot password
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //permet d'aller à la page PasswordActivity
                Intent intent = new Intent(getApplicationContext(), PasswordActivity.class);
                startActivity(intent);
            }
        });

    }
}
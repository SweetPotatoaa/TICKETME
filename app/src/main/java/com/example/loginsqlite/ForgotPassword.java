package com.example.loginsqlite;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    EditText username;
    EditText pass, repass;
    Button confirm;
    DatabaseHelper DB;
    CheckBox showpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        username = (EditText) findViewById(R.id.username_reset);
        pass = (EditText) findViewById(R.id.password_reset);
        repass = (EditText) findViewById(R.id.repassword_reset);
        confirm = (Button) findViewById(R.id.btnconfirm);
        DB = new DatabaseHelper(this);
        showpassword = (CheckBox) findViewById(R.id.showpassword);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String password = pass.getText().toString();
                String repassword = repass.getText().toString();

                Boolean checkuser = DB.checkusername(user);
                Boolean checkpasswordupdate = DB.updatepassword(user, password);

                if (user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(ForgotPassword.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (checkuser == true) {
                        if (password.equals(repassword)) {
                            if (checkpasswordupdate == true) {
                                Intent intent = new Intent(getApplicationContext(), HomeMenu.class);
                                intent.putExtra("username", user);
                                startActivity(intent);
                                Toast.makeText(ForgotPassword.this, "Password updated Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ForgotPassword.this, "Password NOT updated", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(ForgotPassword.this, "Password not matching", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(ForgotPassword.this, "User does not exists", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });

        //To show the password
        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonButton, boolean b) {
                if (b){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    repass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    repass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

    }
}
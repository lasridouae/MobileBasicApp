package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    EditText email, password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String useremail = email.getText().toString();
                String pass = password.getText().toString();
                if(useremail.equals("")||pass.equals("")){
                    Toast.makeText(LogInActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

            }else{
                Boolean checkuserpass = DB.checkusernamepassword(useremail, pass);
                if(checkuserpass==true){
                    Toast.makeText(LogInActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LogInActivity.this, datshAdmin.class));

                }else{
                    Toast.makeText(LogInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        }
    });
}





}
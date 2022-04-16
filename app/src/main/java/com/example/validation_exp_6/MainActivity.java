package com.example.validation_exp_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstvalue,secondvalue;
    Button validate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         firstvalue = (EditText) findViewById(R.id.firstvalue);
         secondvalue = (EditText) findViewById(R.id.secondvalue);
         validate = (Button)  findViewById(R.id.validate);

         validate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String un = firstvalue.getText().toString();
                 String pwd = secondvalue.getText().toString();

                 if(un.matches("[a-zA-Z]+") && pwd.length() == 4 && pwd.matches("[0-9]+"))
                 {
                     //Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
                     firstvalue.setText("");
                     secondvalue.setText("");
                     Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                     startActivity(intent);
                 }
                 else if(un.length() == 0 || pwd.length() == 0)
                 {
                     Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_LONG).show();
                     firstvalue.setText("");
                     secondvalue.setText("");
                 }


                 else if(!un.matches("[a-zA-Z]+") )
                 {
                     Toast.makeText(getApplicationContext(),"Invalid Username",Toast.LENGTH_LONG).show();
                     firstvalue.setText("");
                     secondvalue.setText("");
                 }


                 else if(!pwd.matches("[0-9]+") ||  pwd.length() != 4)
                 {
                     Toast.makeText(getApplicationContext(),"Invalid Password",Toast.LENGTH_LONG).show();
                     firstvalue.setText("");
                     secondvalue.setText("");
                 }
            }
         });


    }
}
package org.meicode.challanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ImageView imageView;
    private Button button, register;
    private EditText txtName, txtEmail, txtPassword, txtConfirmPassword;
    private TextView gender, country;
    private RadioGroup radioGroup;
    private RadioButton male, female, other;
    private CheckBox iAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.button);

        button.setOnClickListener(v -> Toast.makeText(MainActivity.this,
                "Clicked on PICK IMAGE", Toast.LENGTH_SHORT).show());


        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);
        iAgree = findViewById(R.id.iAgree);

        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkName();
                checkEmail();
                checkPassword();
                checkConfirmPassword();
                if(checkName() &&checkEmail() &&checkPassword() && checkConfirmPassword()){

                    if (iAgree.isChecked()) {
                        Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Agree to terms & conditions", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean checkConfirmPassword() {
        if(txtConfirmPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Fill Confirm Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString())){
            System.out.println("Pass match");
        }else{
            Toast.makeText(this, "Password's don't match", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean checkPassword() {
        if(txtPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Fill Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean checkEmail() {
        if(txtEmail.getText().toString().isEmpty()) {
            Toast.makeText(this, "Fill Email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtEmail.getText().toString().contains("@")) {
            System.out.println("Email okay");
        }else{
            Toast.makeText(this, "Email format not acceptable", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    private boolean checkName() {

        if(txtName.getText().toString().isEmpty()){
            Toast.makeText(this, "Fill Name", Toast.LENGTH_SHORT).show();
            return false;
        }

        return  true;
    }


}
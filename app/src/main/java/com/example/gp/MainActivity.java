package com.example.gp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private final AppCompatActivity activity = MainActivity.this;
    private static final Pattern EMAIL_ID =
            Pattern.compile("[a-zA-Z0-9\\+\\.\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{6,12}" +
                    "$");

    private EditText mailid, username, password, phoneno, cpassword;
    private Button Register;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
//        initObjects();
        validateEmail();
        validatePassword();
        confirmPassword();
    }

    private void initViews() {
        mailid = findViewById(R.id.editText3);
        username = findViewById(R.id.editText);
        phoneno = findViewById(R.id.editText2);
        password = findViewById(R.id.editText4);
        cpassword = findViewById(R.id.editText5);
        Register=findViewById(R.id.button);
        login=findViewById(R.id.textView7);

    }

    private void initListeners() {
        Register.setOnClickListener(this);
        login.setOnClickListener(this);

    }


    private boolean validateEmail() {
        String emailInput = mailid.getText().toString().trim();
        if (emailInput.isEmpty()) {
            mailid.setError("Field can't be empty");
            return false;
        } else if (!EMAIL_ID.matcher(emailInput).matches()) {
            mailid.setError("Enter a valid email address");
            return false;
        } else {
            mailid.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String inputpassword = password.getText().toString().trim();
        if (inputpassword.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(inputpassword).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }

    private boolean confirmPassword() {
        String conpassword=cpassword.getText().toString().trim();
        String inpassword=password.getText().toString().trim();
        if(!(conpassword.contentEquals(inpassword))){
            cpassword.setError("enter password correctly");
            return false;
        }
        else {
            return true;
        }
        }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button:
//                postDataToSQLite();
                break;

            case R.id.textView7:
                finish();
                break;
        }
    }

}


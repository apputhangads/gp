package com.example.gp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
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

    EditText mailid, username, password, phoneno, cpassword;
    Button Register;
    TextView login;
    String uname, pno, emailInput, inputpassword, conpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new Databasehelper(this);
        mailid = findViewById(R.id.editText3);
        username = findViewById(R.id.editText);
        phoneno = findViewById(R.id.editText2);
        password = findViewById(R.id.editText4);
        cpassword = findViewById(R.id.editText5);
        Register = (Button)findViewById(R.id.button);
        login = findViewById(R.id.textView7);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,login.class);
                startActivity(i);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
//                db=openHelper.getWritableDatabase();
//                uname = username.getText().toString().trim();
//                pno = phoneno.getText().toString().trim();
//                emailInput = mailid.getText().toString().trim();
//                inputpassword = password.getText().toString().trim();
//                conpassword = cpassword.getText().toString().trim();
//                insertdata(uname,pno,emailInput,inputpassword);
//                Toast.makeText(getApplicationContext(),"registered succesfully",Toast.LENGTH_LONG).show();


            }
        });
    }
//    public void insertdata(String uname,String pno,String emailInput,String inputpassword){
//        ContentValues cv=new ContentValues();
//        cv.put(Databasehelper.COL_2,uname);
//        cv.put(Databasehelper.COL_3,pno);
//        cv.put(Databasehelper.COL_4,emailInput);
//        cv.put(Databasehelper.COL_5,inputpassword);
//        long id=db.insert(Databasehelper.TABLE_NAME,null,cv);
//    }

    public void register() {
        initialise();
        if (!validate()) {
            Toast.makeText(this, "sign up has failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i=new Intent(MainActivity.this,login.class);
            startActivity(i);
        }
    }

    public boolean validate(){
        boolean valid=true;
        if(uname.isEmpty()||uname.length()>50){
            username.setError("please enter valid name");
            valid=false;
        }
        if(pno.isEmpty()||pno.length()!=10){
            phoneno.setError("Please enter valid phone number");
            valid=false;
        }
        if(emailInput.isEmpty()|| (!EMAIL_ID.matcher(emailInput).matches())){
            mailid.setError("Please enter valid email address");
            valid=false;
        }
        if(inputpassword.isEmpty()|| (!PASSWORD_PATTERN.matcher(inputpassword).matches())){
            password.setError("Password is too weak");
            valid=false;
        }
        if(conpassword.isEmpty()||!(conpassword.contentEquals(inputpassword))){
            cpassword.setError("Password does not match");
            valid=false;
        }
        return valid;
    }
    public void initialise() {
        uname = username.getText().toString().trim();
        pno = phoneno.getText().toString().trim();
        emailInput = mailid.getText().toString().trim();
        inputpassword = password.getText().toString().trim();
        conpassword = cpassword.getText().toString().trim();
    }


//    private boolean validateEmail() {
//        String emailInput = mailid.getText().toString().trim();
//        if (emailInput.isEmpty()) {
//            mailid.setError("Field can't be empty");
//            return false;
//        } else if (!EMAIL_ID.matcher(emailInput).matches()) {
//            mailid.setError("Enter a valid email address");
//            return false;
//        } else {
//            mailid.setError(null);
//            return true;
//        }
//    }
//
//    private boolean validatePassword() {
//        String inputpassword = password.getText().toString().trim();
//        if (inputpassword.isEmpty()) {
//            password.setError("Field can't be empty");
//            return false;
//        } else if (!PASSWORD_PATTERN.matcher(inputpassword).matches()) {
//            password.setError("Password too weak");
//            return false;
//        } else {
//            password.setError(null);
//            return true;
//        }
//    }
//
//    private boolean confirmPassword() {
//        String conpassword = cpassword.getText().toString().trim();
//        String inpassword = password.getText().toString().trim();
//        if (!(conpassword.contentEquals(inpassword))) {
//            cpassword.setError("enter password correctly");
//            return false;
//        } else {
//            return true;
//        }
//    }
}




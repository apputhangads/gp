package com.example.gp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class login extends AppCompatActivity {
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

    EditText mailid,password;
    Button login1;
    TextView createAccount;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper=new Databasehelper(this);
        db=openHelper.getReadableDatabase();
        mailid =findViewById(R.id.editText10);
        password=findViewById(R.id.editText11);
        login1=findViewById(R.id.button2);
        createAccount=findViewById(R.id.textView);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login.this,MainActivity.class);
                    startActivity(i);
                }
        });
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(login.this,contacts.class);
                startActivity(i);
            }
        });
//        login1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                    String mail=mailid.getText().toString();
////                    String pword=password.getText().toString();
////                    cursor= db.rawQuery( "SELECT * FROM "+Databasehelper.TABLE_NAME+ " WHERE " + Databasehelper.COL_4 + "=? AND " + Databasehelper.COL_5 + "=?",new String[]{mail,pword});
////                    if(cursor!=null){
////                        if(cursor.getCount() > 0){
////                            cursor.moveToNext();
////                            Toast.makeText(getApplicationContext(),"logged in succesfully",Toast.LENGTH_LONG).show();
////            }
//                contactsactivity();
////
////                        else{
////                            Toast.makeText(getApplicationContext(),"login failed",Toast.LENGTH_LONG).show();
////                        }
//                    }
//            }
      }
//


}

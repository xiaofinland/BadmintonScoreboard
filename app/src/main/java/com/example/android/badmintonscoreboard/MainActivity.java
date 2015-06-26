package com.example.android.badmintonscoreboard;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    EditText playerAName;
    EditText playerBName;

    Button btnSingleStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerAName = (EditText) findViewById(R.id.nameA);
        playerBName = (EditText) findViewById(R.id.nameB);

          }

    public void doubleRegister(View view) {
        Intent doubleRegisterForm = new Intent(this, DoubleReg.class);

        startActivity(doubleRegisterForm);
    }
    public void startSingle(View view) {
        Intent startSingleGame = new Intent(this, SingleScore.class);
        startSingleGame.putExtra("playerA",playerAName.getText().toString());
        startSingleGame.putExtra("playerB",playerBName.getText().toString());
        startActivity(startSingleGame);
    }
}




package com.example.android.badmintonscoreboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by xiao on 26/06/2015.
 */
public class DoubleReg extends Activity {

    EditText playerA1Name;
    EditText playerA2Name;
    EditText playerB1Name;
    EditText playerB2Name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_reg);
        playerA1Name = (EditText) findViewById(R.id.nameA1);
        playerA2Name = (EditText) findViewById(R.id.nameA2);
        playerB1Name = (EditText) findViewById(R.id.nameB1);
        playerB2Name = (EditText) findViewById(R.id.nameB2);

    }
    public void singleReg(View view) {
        Intent singleRegisterForm = new Intent(this, MainActivity.class);

        startActivity(singleRegisterForm);
    }

    public void startDouble(View view) {
        Intent startDoubleGame = new Intent(this, DoubleScore.class);
        startDoubleGame.putExtra("playerA1",playerA1Name.getText().toString());
        startDoubleGame.putExtra("playerB1",playerB1Name.getText().toString());
        startDoubleGame.putExtra("playerA2",playerA2Name.getText().toString());
        startDoubleGame.putExtra("playerB2",playerB2Name.getText().toString());
        startActivity(startDoubleGame);
    }
}

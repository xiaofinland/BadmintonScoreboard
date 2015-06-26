package com.example.android.badmintonscoreboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xiao on 26/06/2015.
 */
public class DoubleScore extends Activity {

    int scoreA = 0;
    int scoreB = 0;
    TextView playerA1View;
    TextView playerB1View;
    TextView playerA2View;
    TextView playerB2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_score);
        /**
         * This method displays the fetched team A& B palyers' name value on the screen.
         */

        playerA1View = (TextView) findViewById(R.id.playerA1_name_text_view);
        playerB1View = (TextView) findViewById(R.id.playerB1_name_text_view);
        playerA2View = (TextView) findViewById(R.id.playerA2_name_text_view);
        playerB2View = (TextView) findViewById(R.id.playerB2_name_text_view);

        Intent startDoubleGame = getIntent();
        String playerA1Name = startDoubleGame.getStringExtra("playerA1");
        String playerB1Name = startDoubleGame.getStringExtra("playerB1");
        String playerA2Name = startDoubleGame.getStringExtra("playerA2");
        String playerB2Name = startDoubleGame.getStringExtra("playerB2");

        playerA1View.setText(playerA1Name);
        playerB1View.setText(playerB1Name);
        playerA2View.setText(playerA2Name);
        playerB2View.setText(playerB2Name);
    }
    /**
     * This method is called when the score A button is clicked.
     */
    public void scoreA(View view) {
        scoreA = scoreA + 1;
        displayA(scoreA);
    }
    /**
     * This method is called when the score B button is clicked.
     */
    public void scoreB(View view) {
        scoreB = scoreB + 1;
        displayB(scoreB);
    }


    /**
     * This method displays the given team A score value on the screen.
     */
    private void displayA(int number) {
        TextView playerATextView = (TextView) findViewById(
                R.id.teamA_score_text_view);
        playerATextView.setText("" + number);
    }

    /**
     * This method displays the given team B score value on the screen.
     */
    private void displayB(int number) {
        TextView playerBTextView = (TextView) findViewById(
                R.id.teamB_score_text_view);
        playerBTextView.setText("" + number);
    }
    /**
     * reset score for Team A & B.
     */
    public void reset (View view){
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
    }

}





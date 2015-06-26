package com.example.android.badmintonscoreboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xiao on 24/06/2015.
 */
public class SingleScore extends Activity {

    int scoreA = 0;
    int scoreB = 0;
    TextView playerAView;
    TextView playerBView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_score);
        /**
         * This method diplays the fetched player A name value on the screen.
         */

        playerAView = (TextView) findViewById(R.id.playerA_name_text_view);
        playerBView = (TextView) findViewById(R.id.playerB_name_text_view);

        Intent startSingleGame = getIntent();
        String playerAName = startSingleGame.getStringExtra("playerA");
        String playerBName = startSingleGame.getStringExtra("playerB");

        playerAView.setText(playerAName);
        playerBView.setText(playerBName);
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
     * This method displays the given player A score value on the screen.
     */
    private void displayA(int number) {
        TextView playerATextView = (TextView) findViewById(
                R.id.playerA_score_text_view);
        playerATextView.setText("" + number);
    }

    /**
     * This method displays the given player B score value on the screen.
     */
    private void displayB(int number) {
        TextView playerBTextView = (TextView) findViewById(
                R.id.playerB_score_text_view);
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




package com.example.android.badmintonscoreboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

/**
 * Created by xiao on 26/06/2015.
 */
public class DoubleScore extends Activity {

    int scoreA = 0;
    int scoreB = 0;
    int maxScore = 30;
    int nomScore = 21;
    TextView playerA1View;
    TextView playerA2View;
    TextView playerB1View;
    TextView playerB2View;
    TextView winnerATextView;
    TextView winnerBTextView;
    Button smashA;
    Button netA;
    Button clearA;
    Button oppoA;
    Button smashB;
    Button netB;
    Button clearB;
    Button oppoB;
    int winnerB = 0;
    int winnerA = 0;
    String playerA1Name;
    String playerA2Name;
    String playerB1Name;
    String playerB2Name;
    Button next;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_score);
        /**
         * This method starts clock when the activity starts.
         */
        chronometer = (Chronometer) findViewById(R.id.clock);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        /**
         * This method displays the fetched team A& B palyers' name value on the screen.
         */

        playerA1View = (TextView) findViewById(R.id.playerA1_name_text_view);
        playerB1View = (TextView) findViewById(R.id.playerB1_name_text_view);
        playerA2View = (TextView) findViewById(R.id.playerA2_name_text_view);
        playerB2View = (TextView) findViewById(R.id.playerB2_name_text_view);

        Intent startDoubleGame = getIntent();
        playerA1Name = startDoubleGame.getStringExtra("playerA1");
        playerB1Name = startDoubleGame.getStringExtra("playerB1");
        playerA2Name = startDoubleGame.getStringExtra("playerA2");
        playerB2Name = startDoubleGame.getStringExtra("playerB2");

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
        // show winner name when score is 30
        if (scoreA == maxScore) {
            winnerA = winnerA + 1;
            displaySetA(winnerA);
            if (winnerA == 2) {
                gameWinnerA();
                disButton();
                chronometer.stop();
            } else {
                //stops score when reaches 30 by disable buttons
                disButton();
                //show winner name when score is 21 or higher but less than 30
            }
        } else if (scoreA >= nomScore && scoreA - scoreB >= 2) {
            winnerA = winnerA + 1;
            displaySetA(winnerA);
            if (winnerA == 2) {
                gameWinnerA();
                disButtonGame();
                chronometer.stop();
            } else {
                disButton();
            }

        }
    }

    /**
     * This method is called when the score B button is clicked.
     */
    public void scoreB(View view) {
        scoreB = scoreB + 1;
        displayB(scoreB);
        // show winner name when score is 30
        if (scoreB == maxScore) {
            winnerB = winnerB + 1;
            displaySetB(winnerB);
            if (winnerB == 2) {
                gameWinnerB();
                disButton();
                chronometer.stop();
            } else {
                disButton();
            }
            //stops score when reaches 30 by disable buttons
            disButton();
            //show winner name when score is 21 or higher but less than 30
        } else if (scoreB >= nomScore && scoreB - scoreA >= 2) {
            winnerB = winnerB + 1;
            displaySetB(winnerB);
            if (winnerB == 2) {
                gameWinnerB();
                disButtonGame();
                chronometer.stop();
            } else {
                disButton();
            }
        }
    }

    /**
     * This method displays game winner A name and set score value on the screen.
     */
    private void gameWinnerA() {
        winnerATextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerA1Name = startSingleGame.getStringExtra("playerA1");
        playerA2Name = startSingleGame.getStringExtra("playerA2");
        winnerATextView.setText(winnerA + " : " + winnerB + "   " + playerA1Name + " & "+playerA2Name+ " win this game");
        next = (Button) findViewById(R.id.single_next_button);
        next.setEnabled(false);
    }

    /**
     * This method displays game winner B name and set score value on the screen.
     */
    private void gameWinnerB() {
        winnerBTextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerB1Name = startSingleGame.getStringExtra("playerB1");
        playerB2Name = startSingleGame.getStringExtra("playerB1");
        winnerBTextView.setText(winnerB + " : " + winnerA + "   " + playerB1Name +" & "+playerB2Name+ " win this game");
        next = (Button) findViewById(R.id.single_next_button);
        next.setEnabled(false);
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
     * This method displays the given player A set value on the screen.
     */
    private void displaySetA(int number) {
        TextView setATextView = (TextView) findViewById(
                R.id.playerA_set_text_view);
        setATextView.setText("" + number);
    }

    /**
     * This method displays the given player B set value on the screen.
     */
    private void displaySetB(int number) {
        TextView setBTextView = (TextView) findViewById(
                R.id.playerB_set_text_view);
        setBTextView.setText("" + number);
    }

    /**
     * reset score,winner name, buttons .
     */
    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
        enButton();
    }

    public void nextSet(View view) {


        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
        enButton();
    }

    public void startOver(View view) {
        chronometer.stop();
        Intent startOver = new Intent(this, MainActivity.class);

        startActivity(startOver);
    }

    /**
     * This method disables score buttons. When set is finished, no additional score can be added.
     */
    private void disButton() {
        smashA = (Button) findViewById(R.id.button_smash_A);
        smashA.setEnabled(false);
        smashB = (Button) findViewById(R.id.button_smash_B);
        smashB.setEnabled(false);
        netA = (Button) findViewById(R.id.button_net_A);
        netA.setEnabled(false);
        netB = (Button) findViewById(R.id.button_net_B);
        netB.setEnabled(false);
        clearA = (Button) findViewById(R.id.button_clear_A);
        clearA.setEnabled(false);
        clearB = (Button) findViewById(R.id.button_clear_B);
        clearB.setEnabled(false);
        oppoA = (Button) findViewById(R.id.button_opponent_A);
        oppoA.setEnabled(false);
        oppoB = (Button) findViewById(R.id.button_opponent_B);
        oppoB.setEnabled(false);
    }

    /**
     * This method disables score buttons and next button. When game is finished, no additional score can be added.
     */
    private void disButtonGame() {
        smashA = (Button) findViewById(R.id.button_smash_A);
        smashA.setEnabled(false);
        smashB = (Button) findViewById(R.id.button_smash_B);
        smashB.setEnabled(false);
        netA = (Button) findViewById(R.id.button_net_A);
        netA.setEnabled(false);
        netB = (Button) findViewById(R.id.button_net_B);
        netB.setEnabled(false);
        clearA = (Button) findViewById(R.id.button_clear_A);
        clearA.setEnabled(false);
        clearB = (Button) findViewById(R.id.button_clear_B);
        clearB.setEnabled(false);
        oppoA = (Button) findViewById(R.id.button_opponent_A);
        oppoA.setEnabled(false);
        oppoB = (Button) findViewById(R.id.button_opponent_B);
        oppoB.setEnabled(false);
        next = (Button) findViewById(R.id.single_next_button);
        next.setEnabled(false);
    }

    /**
     * This method enables score buttons back. When new set starts
     */
    private void enButton() {
        smashA = (Button) findViewById(R.id.button_smash_A);
        smashA.setEnabled(true);
        smashB = (Button) findViewById(R.id.button_smash_B);
        smashB.setEnabled(true);
        netA = (Button) findViewById(R.id.button_net_A);
        netA.setEnabled(true);
        netB = (Button) findViewById(R.id.button_net_B);
        netB.setEnabled(true);
        clearA = (Button) findViewById(R.id.button_clear_A);
        clearA.setEnabled(true);
        clearB = (Button) findViewById(R.id.button_clear_B);
        clearB.setEnabled(true);
        oppoA = (Button) findViewById(R.id.button_opponent_A);
        oppoA.setEnabled(true);
        oppoB = (Button) findViewById(R.id.button_opponent_B);
        oppoB.setEnabled(true);
    }
}








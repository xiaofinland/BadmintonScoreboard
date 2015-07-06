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
 * Created by xiao on 24/06/2015.
 */
public class SingleScore extends Activity {

    int scoreA = 0;
    int scoreB = 0;
    int maxScore = 30;
    int nomScore = 21;
    TextView playerAView;
    TextView playerBView;
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
    String playerAName;
    String playerBName;
    Button next;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_score);
    /**
    * This method starts clock when the activity starts.
    */
        chronometer = (Chronometer) findViewById(R.id.clock);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

        /**
         * This method displays the fetched player A name value on the screen.
         */

        playerAView = (TextView) findViewById(R.id.playerA_name_text_view);
        playerBView = (TextView) findViewById(R.id.playerB_name_text_view);

        Intent startSingleGame = getIntent();
        playerAName = startSingleGame.getStringExtra("playerA");
        playerBName = startSingleGame.getStringExtra("playerB");

        playerAView.setText(playerAName);
        playerBView.setText(playerBName);

        //next = (Button) findViewById(R.id.single_next_button);
        //next.setEnabled(false);
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
        playerAName = startSingleGame.getStringExtra("playerA");
        winnerATextView.setText(winnerA + " : " + winnerB + "   " + playerAName + " wins this game");
        next = (Button) findViewById(R.id.single_next_button);
        next.setEnabled(false);
    }

    /**
     * This method displays game winner B name and set score value on the screen.
     */
    private void gameWinnerB() {
        winnerBTextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerBName = startSingleGame.getStringExtra("playerB");
        winnerBTextView.setText(winnerB + " : " + winnerA + "   " + playerBName + " wins this game");
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

        displaySetA(winnerA);
        displaySetB(winnerB);
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




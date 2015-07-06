package com.example.android.badmintonscoreboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



/**
 * Created by xiao on 06/07/2015.
 */
public class Statistics extends Activity {
    TextView smashSetA1View;
    TextView smashSetA2View;
    TextView smashSetA3View;
    TextView playerAView;
    TextView playerBView;
    String playerAName;
    String playerBName;
    int setSmashA1;
    int smashSetA2;
    int smashSetA3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);

        /**
         * This method displays the fetched player A name value on the screen.
         */

        playerAView = (TextView) findViewById(R.id.playerA_name_text_view);
        playerBView = (TextView) findViewById(R.id.playerB_name_text_view);

        Intent pNames = getIntent();
        playerAName = pNames.getStringExtra("playerA");
        playerBName = pNames.getStringExtra("playerB");

        playerAView.setText(playerAName);
        playerBView.setText(playerBName);

        /**
         * This method fetches player A win by smash statistics.
*/
        //smashSetA1View = (TextView) findViewById(R.id.stat_setA1_smash);
        //smashSetA2View = (TextView) findViewById(R.id.stat_setA2_smash);
        //smashSetA3View = (TextView) findViewById(R.id.stat_setA3_smash);

        //Intent statSets = getIntent();
        //setSmashA1 = statSets.getIntExtra("smashSetA1", 0);
        //smashSetA2 = statSets.getIntExtra("smashSetA2", 0);
        //smashSetA3 = statSets.getIntExtra("smashSetA3", 0);
        //smashSetA1View.setText(setSmashA1);

    }
    /**
     * start over from beginning
     */
    public void startOver(View view) {

        Intent startOver = new Intent(this, MainActivity.class);

        startActivity(startOver);
    }
}

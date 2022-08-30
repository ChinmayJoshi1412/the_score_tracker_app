package com.example.thescoretracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InningsBreak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innings_break);
        int t = FirstInnings.runs + 1;
        TextView runs_scored = (TextView) (findViewById(R.id.runs_scored));
        runs_scored.setText("Target: "+t+" runs");
        TextView rrr = (TextView) (findViewById(R.id.run_rate));
        rrr.setText("Run Rate:"+FirstInnings.df.format(t/MatchInfo.overs));
        TextView Innings_break = (TextView) (findViewById(R.id.innings_break_text));
        Innings_break.setText(MatchInfo.team_to_bat_second + " requires "+ t+" runs in "+MatchInfo.overs+" overs to win");
        Button next_innings = (Button) (findViewById(R.id.next_innings));
        next_innings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InningsBreak.this,SecondInnings.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
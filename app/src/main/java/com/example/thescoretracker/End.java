package com.example.thescoretracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        TextView teama = (TextView)(findViewById(R.id.teamA));
        teama.setText(TeamInfo.names[0]);
        TextView teamb = (TextView)(findViewById(R.id.teamB));
        teamb.setText(TeamInfo.names[1]);
        TextView teamascore = (TextView) (findViewById(R.id.teamA_score));
        if(FirstInnings.wickets==10)
        {
            teamascore.setText(Integer.toString(FirstInnings.runs));
        }
        else
        {
            teamascore.setText(FirstInnings.runs+"/"+FirstInnings.wickets);
        }
        TextView teambscore = (TextView) (findViewById(R.id.teamB_score));
        if(SecondInnings.wickets==10)
        {
            teambscore.setText(Integer.toString(SecondInnings.runs));
        }
        else
        {
            teambscore.setText(SecondInnings.runs+"/"+SecondInnings.wickets);
        }
        TextView won = (TextView) (findViewById(R.id.won));
        if(SecondInnings.won==0)
        {
            won.setText("It's a tie!");
        }
        else if(SecondInnings.won==1)
        {
            int val  = FirstInnings.runs - SecondInnings.runs;
            won.setText(TeamInfo.names[0] + " won by " + val + " runs");
        }
        else if(SecondInnings.won==2)
        {
            int val = 10 - SecondInnings.wickets;
            won.setText(TeamInfo.names[1] + " won by "+val + " wickets");
        }

        Button new_match = (Button) (findViewById(R.id.new_match));
        new_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(End.this,MainActivity.class);
                TeamInfo.names[0]="";
                TeamInfo.names[1]="";
                MatchInfo.overs=0;
                MatchInfo.team_to_bat_first="";
                MatchInfo.team_to_bat_second="";
                FirstInnings.runs=0;
                FirstInnings.wickets=0;
                FirstInnings.rr_1=0;
                FirstInnings.over=0;
                FirstInnings.balls=0;
                SecondInnings.wickets=0;
                SecondInnings.runs=0;
                SecondInnings.won=0;
                startActivity(intent);
                finish();
            }
        });

    }
}
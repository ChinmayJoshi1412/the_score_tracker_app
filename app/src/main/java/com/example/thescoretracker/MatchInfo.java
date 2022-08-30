package com.example.thescoretracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MatchInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_info);
        Button b1 = (Button) findViewById(R.id.team1button);
        b1.setText(TeamInfo.names[0]);
        Button b2 = (Button) findViewById(R.id.team2button);
        b2.setText(TeamInfo.names[1]);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team_to_bat_first = TeamInfo.names[0];
                team_to_bat_second = TeamInfo.names[1];
                total_overs();
                Intent intent = new Intent(MatchInfo.this,FirstInnings.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team_to_bat_first = TeamInfo.names[1];
                team_to_bat_second = TeamInfo.names[0];
                total_overs();
                Intent intent = new Intent(MatchInfo.this,FirstInnings.class);
                startActivity(intent);
                finish();
            }
        });

    }
    static int overs=0;
    static String team_to_bat_first="";
    static String team_to_bat_second="";
    public void total_overs()
    {
        EditText t = (EditText) (findViewById(R.id.overs));
        String value = t.getText().toString();
        try {
            overs = Integer.parseInt(value);
        }
        catch (NumberFormatException e)
        {
            overs = 2;
        }
    }
}
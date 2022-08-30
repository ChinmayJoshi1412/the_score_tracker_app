package com.example.thescoretracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TeamInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);
        EditText n1 = (EditText) findViewById(R.id.team1);
        EditText n2 = (EditText) findViewById(R.id.team2);
        Button b = (Button) (findViewById(R.id.next));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names[0] = n1.getText().toString();
                names[1] = n2.getText().toString();
                Intent intent = new Intent(TeamInfo.this,MatchInfo.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public static String[] names = new String[2];
}
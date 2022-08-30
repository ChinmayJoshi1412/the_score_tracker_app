package com.example.thescoretracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class SecondInnings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_innings);
        TextView team2 = (TextView) (findViewById(R.id.team_to_bat_second));
        team2.setText(MatchInfo.team_to_bat_second);
        TextView target = (TextView) (findViewById(R.id.target));
        int t = FirstInnings.runs + 1;
        target.setText("Target: "+ t);
        Button one = (Button) (findViewById(R.id.one));
        Button two = (Button) (findViewById(R.id.two));
        Button three = (Button) (findViewById(R.id.three));
        Button four = (Button) (findViewById(R.id.four));
        Button six = (Button) (findViewById(R.id.six));
        Button dot = (Button) (findViewById(R.id.dot));
        Button wicket = (Button) (findViewById(R.id.wicket));
        Button noball = (Button) (findViewById(R.id.no));
        Button wide = (Button) (findViewById(R.id.wide));
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 1;
                balls = balls + 1;
                updaterunview();
                updateoversview();
                crr();
                rrr();
                check();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 2;
                balls = balls + 1;
                updaterunview();
                updateoversview();
                crr();
                rrr();
                check();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 3;
                balls = balls + 1;
                updaterunview();
                updateoversview();
                crr();
                rrr();
                check();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 4;
                balls = balls + 1;
                updaterunview();
                updateoversview();
                crr();
                rrr();
                check();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 6;
                balls = balls + 1;
                updaterunview();
                updateoversview();
                crr();
                rrr();
                check();
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                balls = balls + 1;
                updateoversview();
                crr();
                rrr();
                check();
            }
        });
        wicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wickets = wickets + 1;
                balls = balls + 1;
                updaterunview();
                updateoversview();
                crr();
                rrr();
                check();
            }
        });
        noball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 1;
                updaterunview();
                crr();
                rrr();
            }
        });
        wide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 1;
                updaterunview();
                crr();
                rrr();
            }
        });
    }
    static int runs = 0;
    int balls = 0;
    int over = 0;
    static int wickets = 0;
    double rr_2 = 0;
    static int won = 0;
    Timer timer;
    static DecimalFormat df = new DecimalFormat("0.00");
    public void updaterunview() {
        TextView runview = (TextView) (findViewById(R.id.runview));
        runview.setText(runs + "/" + wickets);
    }

    public void updateoversview() {
        TextView oversview = (TextView) (findViewById(R.id.oversview));
        if (balls == 6) {
            balls = 0;
            over = over + 1;
            oversview.setText(over + "." + balls);
        } else {
            oversview.setText(over + "." + balls);
        }
    }
    public void check()
    {
        if(runs>FirstInnings.runs)
        {
            won=2;
            Intent intent1 = new Intent(SecondInnings.this,End.class);
            startActivity(intent1);
            finish();
        }
        else if(wickets==10)
        {
            won = 1;
            Intent intent2 = new Intent(SecondInnings.this, End.class);
            startActivity(intent2);
            finish();
        }
        else if(over==MatchInfo.overs)
        {
            if(runs==FirstInnings.runs)
            {
                won=0;
                Intent intent3 = new Intent(SecondInnings.this,End.class);
                startActivity(intent3);
                finish();
            }
            else {
                won = 1;
                Intent intent4 = new Intent(SecondInnings.this, End.class);
                startActivity(intent4);
                finish();
            }

        }
    }
    public void crr()
    {
        TextView current = (TextView) (findViewById(R.id.crr));
        double val=over;
        switch(balls)
        {
            case 1:
                val =  over + 0.166;
                break;
            case 2:
                val =  over + 0.333;
                break;
            case 3:
                val =  over + 0.5;
                break;
            case 4:
                val =  over + 0.666;
                break;
            case 5:
                val =  over + 0.833;
                break;

        }
        rr_2 = runs/val;
        current.setText("CRR:"+ df.format(rr_2));
    }
    public void rrr()
    {
        TextView required = (TextView) (findViewById(R.id.rrr));
        double val = MatchInfo.overs - over;
        switch(balls)
        {
            case 1:
                val =  MatchInfo.overs - over + 0.833;
                break;
            case 2:
                val = MatchInfo.overs - over + 0.666;
                break;
            case 3:
                val =  MatchInfo.overs - over + 0.5;
                break;
            case 4:
                val =  MatchInfo.overs -  over + 0.333;
                break;
            case 5:
                val =  MatchInfo.overs - over + 0.166;
                break;

        }
        double rrr = (FirstInnings.runs + 1 -runs)/val;
        required.setText("RRR:"+df.format(rrr));
    }
}
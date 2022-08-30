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

public class FirstInnings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_innings);
        TextView team1 = (TextView) (findViewById(R.id.team_to_bat_first));
        team1.setText(MatchInfo.team_to_bat_first);
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
                check();
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                balls = balls + 1;
                updateoversview();
                crr();
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
                check();
            }
        });
        noball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 1;
                updaterunview();
                crr();
            }
        });
        wide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runs = runs + 1;
                updaterunview();
                crr();
            }
        });
    }

    static int runs = 0;
    static int balls = 0;
    static int over = 0;
    static int wickets = 0;
    static double rr_1 = 0;
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

    public void check() {
        timer = new Timer();
        if (over == MatchInfo.overs||wickets == 10) {
            Intent intent = new Intent(FirstInnings.this, InningsBreak.class);
            startActivity(intent);
            finish();

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
        rr_1 = runs/val;
        current.setText("CRR:"+ df.format(rr_1));
    }
}


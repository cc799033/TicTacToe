package com.zybooks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1 = O's, 2=X's
    int player = 1;
    int GameState[] = {0,0,0,0,0,0,0,0,0};
    int[][] Winning = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{6,4,2}};

    //Shows whose turn it is
    TextView turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This is called when one of the spots is clicked
    public void tapped(View view){
        ImageView img = (ImageView) view;

        //Get tag to string so that we can use it for arrays
        String tag = img.getTag().toString();

        GameState[Integer.parseInt(tag)]=player;

        // Message to change depending on whose turn it is
        turn = (TextView) findViewById(R.id.turn);


        if(player == 1){
            img.setImageResource(R.drawable.o);
            player=2;
            turn.setText("X's Turn");
        }
        else{
            img.setImageResource(R.drawable.x);
            player=1;
            turn.setText("O's Turn");
        }

        for (int[] Winning : Winning){
            if (GameState[Winning[0]] == GameState[Winning[1]] && GameState[Winning[1]] == GameState[2] && GameState[Winning[0]] != 0){
                String winner = " ";
                if(player == 1) {
                    winner = "X";
                    turn = null;
                }
                else {
                    winner = "O";
                    turn = null;
                }
                Toast.makeText(this, winner + " wins!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
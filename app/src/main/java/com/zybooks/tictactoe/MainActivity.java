package com.zybooks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //1 = O's, 2=X's
    int player = 1;
    int GameState[] = {0,0,0,0,0,0,0,0,0};
    int [][] Winning = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    Boolean GameOn = true;
    //Shows whose turn it is
    TextView turn;
    int plays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //This is called when one of the spots is clicked
    public void tapped(View view){
        ImageView img = (ImageView) view;
        String tag = img.getTag().toString();
        plays++;

        if(GameOn && GameState[Integer.parseInt(tag)] == 0) {
            //Get tag to string so that we can use it for arrays

            GameState[Integer.parseInt(tag)] = player;

            // Message to change depending on whose turn it is
            turn = (TextView) findViewById(R.id.turn);


            if (player == 1) {
                img.setImageResource(R.drawable.o);
                player = 2;
                turn.setText("X's Turn");
            } else {
                img.setImageResource(R.drawable.x);
                player = 1;
                turn.setText("O's Turn");
            }

            for (int[] Winnings : Winning) {
                if(plays == 9) {
                    turn.setText("CAT");
                }
                else if (GameState[Winnings[0]] == GameState[Winnings[1]] && GameState[Winnings[1]] == GameState[Winnings[2]] && GameState[Winnings[0]] != 0) {
                    GameOn = false;
                    String winner = " ";
                    if (player == 1)
                        winner = "X";
                    else
                        winner = "O";
                    turn.setText(winner + " wins!");
                }
            }
        }
    }
}


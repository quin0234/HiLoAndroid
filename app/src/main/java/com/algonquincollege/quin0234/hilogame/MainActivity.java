package com.algonquincollege.quin0234.hilogame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {

    private EditText userGuessEditText;
    Random rand = new Random();
    int n = rand.nextInt(1000) + 1;
    int numberOfGuesses = 0;
    int userGuess = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button userGuessBtn = findViewById(R.id.userGuessBtn);
        Button userResetBtn = findViewById(R.id.userRestBtn);
        userGuessEditText = findViewById(R.id.uGuess);


        userGuessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("HiLoGame", "Inside method: userResetBtn() " + numberOfGuesses);
                if (userGuessEditText.getText().toString().matches("")) {
                    userGuessEditText.setError(("Invalid Guess 1-1000"));
                    userGuessEditText.requestFocus();

                } else {
                    userGuess = Integer.parseInt(userGuessEditText.getText().toString());
                    if (userGuess > n) {
                        Toast.makeText(getApplicationContext(),
                                "Too Hi",
                                Toast.LENGTH_SHORT).show();
                        numberOfGuesses++;
                        guessesFunc ();
                    } else if (userGuess < n) {
                            Toast.makeText(getApplicationContext(),
                                    "Too Lo",
                                    Toast.LENGTH_SHORT).show();
                        numberOfGuesses++;
                        guessesFunc ();
                    } else {
                        numberOfGuesses++;
                        playGame();
                    }

                userGuessEditText.setText("");
            }
            }
        });

        userResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Game Reset",
                        Toast.LENGTH_SHORT).show();
                        numberOfGuesses = 0;
                        n = rand.nextInt(1000) + 1;
                        Log.i("HiLoGame", "Inside method: userResetBtn()" + n);
            }

        });

        userResetBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "The number was " + n,
                        Toast.LENGTH_LONG).show();
                        numberOfGuesses = 0;
                        n = rand.nextInt(1000) + 1;
                        Log.i("HiLoGame", "Inside method: userResetBtn()" + n);
                        return true;
            }

        });
    }


    private void playGame () {
        if (numberOfGuesses <= 5){
            Toast.makeText(getApplicationContext(),
                    "Superior Win...You guess in " + numberOfGuesses + " guesses",
                    Toast.LENGTH_SHORT).show();
                    numberOfGuesses = 0;
                    n = rand.nextInt(1000) + 1;

        }else if(numberOfGuesses >= 6 && numberOfGuesses <= 10){
            Toast.makeText(getApplicationContext(),
                    "Excellent Win...You guess in " + numberOfGuesses + " guesses",
                    Toast.LENGTH_SHORT).show();
                    numberOfGuesses = 0;
                    n = rand.nextInt(1000) + 1;
        }
    }

    private void guessesFunc () {
        if (numberOfGuesses == 10)
        Toast.makeText(getApplicationContext(),
                "Please Reset" + "The number was " + n,
                Toast.LENGTH_SHORT).show();
    }


    public void showMeTheDialog(View v){
        AboutDialogFragment frag = new AboutDialogFragment();
        frag.show(getFragmentManager(), "TAG");

    }

}




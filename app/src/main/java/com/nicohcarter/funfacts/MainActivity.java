package com.nicohcarter.funfacts;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // Declare view variables
    private TextView funFactText;
    private Button funFactButton;
    private RelativeLayout relativeLayout;

    //objects for 2 classes
    private FunFactBook factBook = new FunFactBook();
    private ColorWheel colorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign the different Views from the layout file to the corresponding variables
        funFactText = findViewById(R.id.funFactText);
        funFactButton = findViewById(R.id.funFactButton);
        relativeLayout = findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = factBook.getFact();
                //Update the screen with the new fact and background color
                int color = colorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                funFactText.setText(fact);
                funFactButton.setTextColor(color);
            }
        };
        funFactButton.setOnClickListener(listener);
    }
}
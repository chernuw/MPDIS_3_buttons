package com.example.chernuwnote.projectn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button switchToGreen;
    private Button switchToRed;
    private Button switchToBlue;
    private LinearLayout screenLayout;
    private Toast informationToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init buttons
        switchToBlue = (Button) findViewById(R.id.switchBlue);
        switchToGreen = (Button) findViewById(R.id.switchGreen);
        switchToRed = (Button) findViewById(R.id.switchRed);
        screenLayout = (LinearLayout) findViewById(R.id.screenLayout);

        //setup listeners
        switchToBlue.setOnClickListener(this);
        switchToGreen.setOnClickListener(this);
        switchToRed.setOnClickListener(this);

        informationToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    }

    private void pressButton(Button butt){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder builder1 = builder.setTitle("Message")
                .setMessage("Нажата "+butt.getText().toString())
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onClick(View view){
        switchToBlue.setTextColor(Color.BLACK);
        switchToGreen.setTextColor(Color.BLACK);
        switchToRed.setTextColor(Color.BLACK);

        if (switchToBlue.equals(view)){
            screenLayout.setBackgroundColor(Color.BLUE);
            switchToBlue.setTextColor(Color.BLUE);
            pressButton(switchToBlue);
            showToast("Hello blue");

        } else if (switchToGreen.equals(view)){
            screenLayout.setBackgroundColor(Color.GREEN);
            switchToGreen.setTextColor(Color.GREEN);
            showToast("Hello green");
            pressButton(switchToGreen);
        } else if(switchToRed.equals(view)){
            screenLayout.setBackgroundColor(Color.RED);
            switchToRed.setTextColor(Color.RED);
            showToast("Hello red");
            pressButton(switchToRed);
        }
    }

    private void showToast(String text){
        informationToast.cancel();
        informationToast.setText(text);
        informationToast.show();
    }
}

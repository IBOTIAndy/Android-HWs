package com.example.andytony.androidfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStartGame,
                   mBtnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStartGame = (Button) findViewById(R.id.btn_main_start_game);
        mBtnExit = (Button)findViewById(R.id.btn_exit);

        mBtnStartGame.setOnClickListener(new View.OnClickListener() {                       //移動到遊戲layout
            @Override                                                                       //
            public void onClick(View v) {                                                   //
                Intent intent = new Intent();                                               //
                intent.setClass(MainActivity.this, SudokuGameSystem.class); //
                startActivity(intent);                                                      //
            }
        });

        mBtnExit.setOnClickListener(new View.OnClickListener() {    //關閉應用程式
            @Override                                               //
            public void onClick(View v) {                           //
                finish();                                           //
                System.exit(0);                               //
            }
        });
    }
}

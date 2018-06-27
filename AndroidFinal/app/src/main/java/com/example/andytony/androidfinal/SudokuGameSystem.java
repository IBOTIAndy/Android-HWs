package com.example.andytony.androidfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SudokuGameSystem extends AppCompatActivity {

    private Button mBtnBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_game);

        mBtnBackToMain = (Button) findViewById(R.id.btn_game_back);

        mBtnBackToMain.setOnClickListener(new View.OnClickListener() {                      //返回主選單
            @Override                                                                       //
            public void onClick(View v) {                                          //回到主選單
                Intent intent = new Intent();                                               //
                intent.setClass(SudokuGameSystem.this, MainActivity.class); //
                startActivity(intent);                                                      //
            }
        });
    }




}

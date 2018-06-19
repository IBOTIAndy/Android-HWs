package com.paperscissorsstonegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtComPlay, mTxtResult;
    private Button mBtnScissors, mBtnStone, mBtnPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtComPlay = (TextView)findViewById(R.id.txtComPlay);
        mTxtResult = (TextView)findViewById(R.id.txtResult);
        mBtnScissors = (Button)findViewById(R.id.btnScissors);
        mBtnStone = (Button)findViewById(R.id.btnStone);
        mBtnPaper = (Button)findViewById(R.id.btnPaper);

        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStone.setOnClickListener(btnStoneOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }

    private View.OnClickListener btnScissorsOnClick = new View.OnClickListener() {  //按下剪刀
        public void onClick(View v) {
            GameSystem useScissorsPlay = new GameSystem();
            useScissorsPlay.playPaperScissorsStone(1);
            if(useScissorsPlay.getResult() == 1) {
                mTxtComPlay.setText(R.string.play_paper);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
            else if(useScissorsPlay.getResult() == 2) {
                mTxtComPlay.setText(R.string.play_scissors);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            }
            else{
                mTxtComPlay.setText(R.string.play_stone);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
        }
    };

    private View.OnClickListener btnStoneOnClick = new View.OnClickListener() { //按下石頭
        public void onClick(View v) {
            GameSystem useStonePlay = new GameSystem();
            useStonePlay.playPaperScissorsStone(2);
            if(useStonePlay.getResult() == 1) {
                mTxtComPlay.setText(R.string.play_scissors);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
            else if(useStonePlay.getResult() == 2) {
                mTxtComPlay.setText(R.string.play_stone);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            }
            else{
                mTxtComPlay.setText(R.string.play_paper);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
        }
    };

    private View.OnClickListener btnPaperOnClick = new View.OnClickListener() { //按下布
        public void onClick(View v) {
            GameSystem usePaperPlay = new GameSystem();
            usePaperPlay.playPaperScissorsStone(3);
            if(usePaperPlay.getResult() == 1) {
                mTxtComPlay.setText(R.string.play_stone);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
            else if(usePaperPlay.getResult() == 2) {
                mTxtComPlay.setText(R.string.play_paper);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            }
            else{
                mTxtComPlay.setText(R.string.play_scissors);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
        }
    };
}

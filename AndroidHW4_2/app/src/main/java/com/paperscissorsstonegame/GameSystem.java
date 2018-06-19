package com.paperscissorsstonegame;

public class GameSystem {
    private int playerChoice;   //玩家的選擇
    private int computerChoice; //電腦的選擇
    private int result;         //結果

    private int rule[][] = { {2, 0, 1}, {1, 2, 0}, {0, 1, 2} }; //對上電腦選擇的輸贏，分別為三個選項的結果(輸:0 贏:1 平:2)

    private int getRandom(){ //隨機選擇
        return (int)(Math.random()*3 + 1);  //隨機變數
    }
    public int getResult(){
        return result;
    }
    private void setPlayerChoice (int choice){
        playerChoice = choice;
    }
    private void setComputerChoice (int choice){
        computerChoice = choice;
    }
    private void setResult(){
        result = rule[playerChoice][computerChoice];
    }

    public void PlayGame(int PlayerChoice){
        setPlayerChoice(PlayerChoice);
        setComputerChoice(getRandom());
        setResult();
    }
}

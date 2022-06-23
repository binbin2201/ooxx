package game;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Ooxx {
    public static void main(String[] args) {
        //2d array 棋盤
        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printBoard(board);
        while(true){

            Scanner s = new Scanner(System.in);
            System.out.println("Enter your position between 1 ~ 9 :");
            int Player_pos = s.nextInt();
            Random r = new Random();
            int AI_pos = r.nextInt(9)+1;
            //System.out.println(position);
            PosPlacer(board,Player_pos,"Player");
            System.out.println("_______________________");
            PosPlacer(board,Player_pos,"AI");
        }
    }
    public static void printBoard(char[][] board){
        //冒號就是遍歷abc的集合，取出每一個元素
        for(char [] row : board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void PosPlacer(char[][] board,int Player_pos,String user){
        char character = 'X';
        if(user.equals("AI")){
            character = 'O';
        }else if (user.equals("Player")){
            character = 'X';
        }
        switch(Player_pos){
            case 1:
                board[0][0] = character;
                break;
            case 2:
                board[0][2] = character;
                break;
            case 3:
                board[0][4] = character;
                break;
            case 4:
                board[2][0] = character;
                break;
            case 5:
                board[2][2] = character;
                break;
            case 6:
                board[2][4] = character;
                break;
            case 7:
                board[4][0] = character;
                break;
            case 8:
                board[4][2] = character;
                break;
            case 9:
                board[4][4] = character;
                break;
        }
        printBoard(board);
    }
}


package game;

import java.util.Scanner;

public class Ooxx {
    public static void main(String[] args) {
        //2d array 棋盤
        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printBoard(board);
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your position between 1 ~ 9 :");
        int position = s.nextInt();
        System.out.println(position);
        printBoard(board);


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
    public static void PosPlacer(char[][] board,int position,String user){
        char character = 'X';
        if(user.equals("AI")){
            character = 'O';
        }
        switch(position){
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


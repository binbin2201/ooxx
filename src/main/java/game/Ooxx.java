package game;

import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Ooxx {
    public static ArrayList<Integer> playerPos = new ArrayList<>();
    public static ArrayList<Integer> aiPos = new ArrayList<>();

    public static void main(String[] args) {
        //2d array 棋盤
        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printBoard(board);
        while(true){
            String result = winCond();
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your position between 1 ~ 9 :");
            int Player_pos = s.nextInt();
            while(playerPos.contains(Player_pos)||aiPos.contains(Player_pos)){
                System.out.println("Enter an untaken position:");
                Player_pos=s.nextInt();
            }
            PosPlacer(board,Player_pos,"Player");
            result = winCond();
            if (result.length()>0){
                System.out.println(result);
                break;
            }
            Random r = new Random();
            int AI_pos = r.nextInt(9)+1;
            while(playerPos.contains(AI_pos)||aiPos.contains(AI_pos)){
                AI_pos=r.nextInt(9 )+1;
            }
            //System.out.println(position);
                System.out.println("_______________________");
                PosPlacer(board,AI_pos,"AI");
                result = winCond();
            if (result.length()>0) {
                System.out.println(result);
                break;
            }

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
    public static void PosPlacer(char[][] board,int pos,String user){
        char character = 'X';
        if(user.equals("Player")){
            character = 'X';
            playerPos.add(pos);
        }else if (user.equals("AI")){
            character = 'O';
            aiPos.add(pos);
        }
        switch(pos){
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
    public static String winCond(){
        //List name = Arrays.asList(1,2,3)     list 一個list
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List lowRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);
        List<List> winMethod = new ArrayList<List>();
        winMethod.add(topRow);
        winMethod.add(midRow);
        winMethod.add(lowRow);
        winMethod.add(leftCol);
        winMethod.add(midCol);
        winMethod.add(rightCol);
        winMethod.add(cross1);
        winMethod.add(cross2);
        for(List l : winMethod){
            if (playerPos.containsAll(l)){
                return "You win";
            }else if(aiPos.containsAll(l)){
                return "AI wins";
            }else if(playerPos.size()+aiPos.size()==9){
                return "It's a tie";
            }
        }
        return "";
    }
}


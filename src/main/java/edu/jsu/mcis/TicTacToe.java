package edu.jsu.mcis;
import java.util.Scanner;
import java.util.*;


public class TicTacToe {
    
    private char[][] board;
    private boolean Player1;
    private boolean gameStatus;
    public TicTacToe(){
        board = new char[3][3];
        for(int i = 0; i<3;i++){
            for(int j =0; j<3;j++){
                board[i][j] = '~' ;
            }
        }
        Player1 = true;
        gameStatus = true;
    }
    public void printBoard(){
        System.out.println("-------------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3;  j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
        
    }

    public char getMark(int r, int c){
        return board[r][c];
    }
    
    public void markSpot(int r, int c){
        if(Player1 && board[r][c] == '~' && checkThatInputIsInRange(r, c)== 1){
            board[r][c] = 'X' ;
            if(!checkForAWin()){
              Player1 = false;  
            }
            
        }
        else if(!Player1 && board[r][c] == '~' && checkThatInputIsInRange(r,c) == 1){
            board[r][c] = 'O' ;
            if(!checkForAWin()){
               Player1 = true; 
            }
            
        }
    }
    
    public int checkThatInputIsInRange(int r, int c){
        if(r < 0 || r > 2 || c < 0 || c > 2){
            throw new IndexOutOfBoundsException();
        }
        else return 1;
       
    }
    
    public boolean checkHorizontalWin(){
        
        for(int i = 0; i < 3;i++){
          if((board[i][0] == board[i][1] && board [i][1] == board[i][2]) && board[i][0] != '~' && board[i][1] != '~' && board[i][2] != '~' ) {
              gameStatus = false;
              return true;
              
          } 
        }
        return false;
    }
    
    public boolean checkVerticalWin(){
        for(int i = 0; i < 3; i++){
            if((board[0][i] == board[1][i] && board[1][i] == board[2][i]) && board[0][i] != '~' && board[1][i] != '~' && board[2][i] != '~'){
                gameStatus = false;
                return true;
                
            }
        } 
        return false;
    } 

    public boolean checkDiagnalWin(){
        if((board[0][0] == board[1][1] && board[1][1] == board[2][2])&& board[0][0] != '~' && board[1][1] != '~' && board[2][2] != '~' ){
            gameStatus = false;
            return true;
            
        }
        else if((board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[2][2] != '~' && board[1][1] != '~' && board[2][0] != '~'){
            gameStatus = false;
            return true;
            
        }
        else return false;
    } 
    
    public boolean checkForAWin(){
        if(checkDiagnalWin() || checkHorizontalWin() || checkVerticalWin()){
            return true;
        }
        else return false;
    }
    
    
    public boolean checkForTie(){
        int count = 0;
        for(int i =0; i < 3;i++){
            for(int j =0;j < 3;j++){
                if(board[i][j]=='X' || board[i][j]=='O'){
                    count++;
                }
            }
        }
        if(count == 9 && !checkVerticalWin() && !checkDiagnalWin() && !checkHorizontalWin()){
            gameStatus = false;
            return true;
           
        }
        else{
            return false;
        }
    }
    
    public boolean getGameStatus(){
        if(gameStatus){
            return true;
        }
        else return false;
    }
    
    public boolean getCurrentPlayer(){
        if(Player1){
            return true;
        }
        else{
            return false;
        }
    }

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
        while(game.getGameStatus()){
            try{
                game.printBoard();
                if(game.getCurrentPlayer()){    
                    System.out.println("Player X, mark your spot!");
                    Scanner scan = new Scanner(System.in);
                    int r = scan.nextInt();
                    int c = scan.nextInt();
                    game.markSpot(r, c);
                    if(game.checkForAWin() && game.getCurrentPlayer()){
                        System.out.println("Player X wins!");
                    }
                    else if(game.checkForAWin() && !game.getCurrentPlayer()){
                        System.out.println("Player O wins!");
                    }
                    else if(game.checkForTie()){
                        System.out.println("Game is a tie!");
                    }
                    if(game.checkForAWin() || game.checkForTie()){
                        System.out.println("Play Again? Y/N");
                        Scanner s = new Scanner(System.in);
                        String p = s.next();
                        if(p.equals("Y") || p.equals("y")){
                            game = new TicTacToe();
                        }  
                    }
                
                }
                else{
                     
                    System.out.println("Player O, mark your spot!");
                    Scanner scan = new Scanner(System.in);
                    int r = scan.nextInt();
                    int c = scan.nextInt();
                    game.markSpot(r, c);
                    if(game.checkForAWin() && game.getCurrentPlayer()){
                        System.out.println("Player X wins!");
                    }
                    else if(game.checkForAWin() && !game.getCurrentPlayer()){
                        System.out.println("Player O wins!");
                    }
                    else if(game.checkForTie()){
                        System.out.println("Game is a tie!");
                    }
                    if(game.checkForAWin() || game.checkForTie()){
                        System.out.println("Play Again? Y/N");
                        Scanner s = new Scanner(System.in);
                        String p = s.next();
                        if(p.equals("Y") || p.equals("y")){
                            game = new TicTacToe();
                        }
                    }
                
                }   
            
                
            }catch(IndexOutOfBoundsException | InputMismatchException ex){
               continue;
            }
            
        }
        
	}
}

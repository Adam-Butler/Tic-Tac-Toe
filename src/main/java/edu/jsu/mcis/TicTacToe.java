package edu.jsu.mcis;
import java.util.Scanner;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe extends JFrame implements ActionListener{
    private JButton[][] board;
    private boolean Player1;
    private boolean gameStatus;
    public TicTacToe(){
        setLayout(new GridLayout(3,3));
        board = new JButton[3][3];
        for(int i = 0; i<3;i++){
            for(int j =0; j<3;j++){
                board[i][j] = new JButton("");
                board[i][j].setPreferredSize(new Dimension(100,100));
                board[i][j].addActionListener(this);
                board[i][j].setName("Location"+i+""+j);
                add(board[i][j]);    
            }
        }
        Player1 = true;
        gameStatus = true;
        
    }
   
    
    public String getMark(int r, int c){
        return board[r][c].getText();
    }
    
    public void markSpot(int r, int c){
        if(getCurrentPlayer() && board[r][c].getText().equals("") ){
            board[r][c].setText("X") ;
            if(!checkForAWin()){
              Player1 = false;  
            }
            
        }
        else if(!getCurrentPlayer() && board[r][c].getText().equals("") ){
            board[r][c].setText("O");
            if(!checkForAWin()){
               Player1 = true; 
            }  
        }
    }
    
    
    public boolean checkForAWin(){
        for(int i = 0; i < 3;i++){
            if(board[i][0].getText().equals(board[i][1].getText())  && board [i][1].getText().equals(board[i][2].getText()) 
              && !board[i][0].getText().equals("") && !board[i][1].getText().equals("") && !board[i][2].getText().equals("")) {
              gameStatus = false;
              return true;
              
            } 
            else if(board[0][i].getText().equals(board[1][i].getText()) && board[1][i].getText().equals(board[2][i].getText())  
                && !board[0][i].getText().equals("") && !board[1][i].getText().equals("") && !board[2][i].getText().equals("")){
                gameStatus = false;
                return true;
                
            }             
        }
            
        if(board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && 
             !board[0][0].getText().equals("") && !board[1][1].getText().equals("") && !board[2][2].getText().equals("")){
            gameStatus = false;
            return true;
            
        }
        else if(board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) 
                 && !board[0][2].getText().equals("") && !board[1][1].getText().equals("") && !board[2][0].getText().equals("")){
            gameStatus = false;
            return true;
            
        }
        else return false;
        
    }
    
    
    public boolean checkForTie(){
        int count = 0;
        for(int i =0; i < 3;i++){
            for(int j =0;j < 3;j++){
                if(board[i][j].getText().equals("X") || board[i][j].getText().equals("O")){
                    count++;
                }
            }
        }
        if(count == 9 && !checkForAWin()){
            gameStatus = false;
            return true;
           
        }
        else return false;
            
        
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
    public void actionPerformed(ActionEvent event){
        JButton b = (JButton)event.getSource();
        String loc = b.getName().substring(8);
        int r= Integer.parseInt(loc.substring(0,1));
        int c = Integer.parseInt(loc.substring(1,2));
        markSpot(r,c);
        b.setText(getMark(r,c));
        whoWins();  
    }
    
    public void whoWins(){
        final String s;
        if(checkForAWin() && getCurrentPlayer()){
            s = "X";
        }
        else if(checkForAWin() && !getCurrentPlayer()){
            s = "O";
        }
        else if(checkForTie()){
            s = "TIE";
        }
        else{s = "";}
        if(s.length() > 0){
            new Thread(new Runnable(){
                public void run(){
                    JOptionPane.showMessageDialog(null, "The winner is "+ s, "Game Over",JOptionPane.INFORMATION_MESSAGE);
                }
            }).start();
        }      
    }

	public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.setTitle("Tic Tac Toe");
        game.setVisible(true);
        game.pack();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }		
}

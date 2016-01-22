import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe t;
	public void startNewGame() {
         t = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
        t.markSpot(row, col);
	}
	
	public String getMark(int row, int col) {
        if(t.getBoard()[row][col] == 'X'){
            return "X";
        }
        else if(t.getBoard()[row][col] == 'O'){
            return "O";
        }
        else return "~";
		
	}
    
	public String getWinner() {
        if(t.checkForAWin() && t.getCurrentPlayer()){
            return "X";
        }
        else if(t.checkForAWin() && !t.getCurrentPlayer()){
            return "O";
        }
        else if(t.checkForTie()){
            return "TIE";
        }
		else{
            return "";
        }
	}
}

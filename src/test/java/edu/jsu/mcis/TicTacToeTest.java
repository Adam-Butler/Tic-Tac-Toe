package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
    
    
	@Test
	public void testInitialBoardIsEmpty() {
        TicTacToe tic = new TicTacToe();
        int count = 0;
        for(int i =0;i < 3; i++){
            for(int j = 0;j<3;j++){
               if(tic.getMark(i,j) == '~'){
                   count++;
               } 
               else{
                   
               }
            }
        }
		assertEquals(9, count);
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
        TicTacToe tic = new TicTacToe();
        tic.markSpot(0,2);
		assertEquals(tic.getMark(0, 2), 'X');
       
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
        TicTacToe tic = new TicTacToe();
        tic.markSpot(1, 0);
        tic.markSpot(2,0);
		assertEquals(tic.getMark(2, 0), 'O');
       
	}
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatInputHasToBeInRange(){
        TicTacToe tic = new TicTacToe();
        tic.markSpot(0, 3);   
    }
         
    
	
	@Test
	public void testUnableToMarkOverExistingMark() {
        TicTacToe tic = new TicTacToe();
        tic.markSpot(1,1);
        tic.markSpot(1,1);
        
		assertEquals(tic.getMark(1,1), 'X');
        assertTrue(!tic.getCurrentPlayer());
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
        TicTacToe tic = new TicTacToe();
        tic.markSpot(0,0);
        assertFalse(tic.checkHorizontalWin());
        assertFalse(tic.checkVerticalWin());
        assertFalse(tic.checkDiagnalWin());
        assertTrue(tic.getGameStatus());
		
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
        TicTacToe tic = new TicTacToe();
        tic.markSpot(0,0);
        tic.markSpot(1,1);
        tic.markSpot(0,1);
        tic.markSpot(2,2);
        tic.markSpot(0,2);
		assertTrue(tic.checkHorizontalWin());
        assertTrue(tic.getCurrentPlayer());
	}
    
    
    
    
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
        TicTacToe tic = new TicTacToe();
        tic.markSpot(0,0);
        tic.markSpot(0,1);
        tic.markSpot(0,2);
        tic.markSpot(1,2);
        tic.markSpot(1,0);
        tic.markSpot(1,1);
        tic.markSpot(2,2);
        tic.markSpot(2,0);
        tic.markSpot(2,1);
		assertTrue(tic.checkForTie());
	}
    
    @Test    
    public void testXWinsDiagnally(){
        TicTacToe tic = new TicTacToe();
        tic.markSpot(0,0);
        tic.markSpot(0,1);
        tic.markSpot(1,1);
        tic.markSpot(0,2);
        tic.markSpot(2,2);
        assertTrue(tic.checkDiagnalWin());
        assertTrue(tic.getCurrentPlayer());
    }
    @Test
    public void testOWinsVerticallyAcrossMiddle(){
        TicTacToe tic = new TicTacToe();
        tic.markSpot(0,0);
        tic.markSpot(0,1);
        tic.markSpot(1,0);
        tic.markSpot(1,1);
        tic.markSpot(0,2);
        tic.markSpot(2,1);
        assertTrue(tic.checkVerticalWin());
        assertTrue(!tic.getCurrentPlayer());
        
    }
    
    @Test
    public void testXIsBeginningPlayer(){
        TicTacToe tic = new TicTacToe();
        assertTrue(tic.getCurrentPlayer());
    }
    
    @Test
    public void testGameIsCurrentlyInProgressAfterInitialization(){
        TicTacToe tic = new TicTacToe();
        assertTrue(tic.getGameStatus());
    }
    
    
    
}

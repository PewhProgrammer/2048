package ttfe.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import ttfe.MoveDirection;
import ttfe.SimulatorInterface;
import ttfe.TTFEFactory;

/**
 * This class provides a very simple example of how to write tests for this project.
 * You can implement your own tests within this class or any other class within this package.
 * Tests in other packages will not be run and considered for completion of the project.
 */
public class SimpleTests {

	private SimulatorInterface game;

	@Before
	public void setUp() {
		game = TTFEFactory.createSimulator(4, 4, new Random(0));
	}
	
	@Test
	public void testInitialGamePoints() {
		assertEquals("The initial game did not have zero points", 0 ,
				game.getPoints());
	}
	
	@Test
	public void testInitialBoardHeight() {
		assertTrue("The initial game board did not have correct height",
				4 == game.getBoardHeight());
	}
	
	@Test
	public void testInitialBoardWidth(){
		assertTrue("The initial game board did not have correct width",
				4 == game.getBoardWidth()) ;
	}
	
	@Test
	public void testInitialPiece() {
		assertEquals("The initial Pieces do not match two",2,game.getNumPieces()) ;
	}
	
	@Test
	
	public void testInitialPoints() {
		assertEquals("The initial Pieces do not match zero",0,game.getPoints()) ;
	}

	@Test
	public void testInitialMoves() {
		assertEquals("The initial game moves does not match zero",0,game.getNumMoves()) ;
	}
		
	@Test
	public void testAddPiece() {
		assertEquals("There is no more Space left",true , game.isSpaceLeft());
	}
	
	@Test
	public void testGetBoardWidth() {
		assertTrue("The Board Width is less than 0 " ,game.getBoardWidth() > 0) ;
	}
	
	
	@Test
	public void testGetBoardHeight() {
		assertTrue("The Board Height is less than 0 " ,game.getBoardHeight() > 0) ;
	}
	
	@Test
	public void testGetNumMoves() {
		assertTrue("The return number is less than 0",game.getNumMoves() >= 0);
		int x = game.getNumMoves() ;
		game.performMove(MoveDirection.SOUTH) ;
		assertTrue("getNumMoves has a malfunction",x+1 == game.getNumMoves()) ;
	}
	
	@Test
	public void testGetNumPieces() {
		assertTrue("The return number is less than 0",game.getNumPieces() >= 0);
		
	}
	
	@Test
	public void testGetPoints() {
		assertTrue("The returned points are less than 0 ",game.getPoints() >= 0);
	
	}
	
	@Test
	public void testSetPieceAt() {

	}
	
	@Test
	public void testGetPieceAt() {
		int x = 92 ;
		game.setPieceAt(1, 1, x);
		assertTrue("GetPiece/SetPiece has a malfunction",x == game.getPieceAt(1,1)) ; 
	}
	
	@Test
	public void testAddPiece1() {
		int x = game.getNumPieces() ;
		game.addPiece();
		assertTrue("AddPiece has a malfunction",x+1 == game.getNumPieces()) ;	
	}
	
	@Test
	public void testIsMovePossible() {
		
		assertEquals(" isMovePossible has a malfunction",game.isMovePossible() , game.isSpaceLeft()) ;
	}
	
	
	@Test
	public void testPerformMove1() {
		assertTrue("PerformMove1",true == game.performMove(MoveDirection.NORTH));
	}
	
	@Test
	public void testPerformMove2() {
		assertTrue("PerformMove2",true == game.performMove(MoveDirection.SOUTH)) ;
	}
	
	@Test
	public void testPerformMove3() {
		assertTrue("PerformMove3",true == game.performMove(MoveDirection.WEST)) ;
	}
	
	@Test
	public void testPerformMove4() {
		assertTrue("PerformMove4",true == game.performMove(MoveDirection.EAST));
	}
	
	@Test
	public void testIsSpaceLeft() {
		game.setPieceAt(0, 1, 2);
		game.setPieceAt(0, 2, 2);
		game.setPieceAt(0, 3, 2);
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(1, 1, 2);
		game.setPieceAt(1, 2, 2);
		game.setPieceAt(1, 3, 2);
		game.setPieceAt(1, 0, 2);
		game.setPieceAt(3, 1, 2);
		game.setPieceAt(3, 2, 2);
		game.setPieceAt(3, 3, 2);
		game.setPieceAt(3, 0, 2);
		game.setPieceAt(2, 1, 2);
		game.setPieceAt(2, 2, 2);
		game.setPieceAt(2, 3, 2);
		game.setPieceAt(2, 0, 2);
		assertEquals("isSpaceLeft has a malfunction ",false,game.isSpaceLeft()) ;
	}
	
	@Test
	public void testGetPoints1() {
		game.performMove(MoveDirection.EAST);
		int x = game.getPoints() ;
		assertEquals(" GetPoints1 has a malfunction",x,32);
	}
}
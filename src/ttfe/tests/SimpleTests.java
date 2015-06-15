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

	private SimulatorInterface game,game1,game2;

	@Before
	public void setUp() {
		game = TTFEFactory.createSimulator(4, 4, new Random(0));
		game1 = TTFEFactory.createSimulator(4, 4, new Random(0));
		game2 = TTFEFactory.createSimulator(5, 5 , new Random(0) ) ;
	}
	
	@Test
	public void testInitialGamePoints() {
		assertEquals("The initial game did not have zero points", 0 ,
				game.getPoints());
		assertEquals("The initial game did not have zero points", 0 ,
				game2.getPoints());
	}
	
	@Test
	public void testInitialBoardHeight() {
		assertTrue("The initial game board did not have correct height",
				4 == game2.getBoardHeight());
		assertTrue("The initial game board did not have correct height",
				5 == game2.getBoardHeight());
	}
	
	@Test
	public void testInitialBoardWidth(){
		assertTrue("The initial game board did not have correct width",
				4 == game.getBoardWidth()) ;
		assertTrue("The initial game board did not have correct width",
				5 == game.getBoardWidth()) ;
	}
	
	@Test
	public void testInitialPiece() {
		assertEquals("The initial Pieces do not match two",2,game.getNumPieces()) ;
		assertEquals("The initial Pieces do not match two",2,game2.getNumPieces()) ;
	}
	
	@Test
	
	public void testInitialPoints() {
		assertEquals("The initial Pieces do not match zero",0,game.getPoints()) ;
		assertEquals("The initial Pieces do not match zero",0,game2.getPoints()) ;
	}

	@Test
	public void testInitialMoves() {
		assertEquals("The initial game moves does not match zero",0,game.getNumMoves()) ;
		assertEquals("The initial game moves does not match zero",0,game2.getNumMoves()) ;
	}
	
	@Test
	public void testGetNumMoves() {
		assertTrue("The return number is less than 0",game.getNumMoves() >= 0);
		assertTrue("The return number is less than 0",game2.getNumMoves() >= 0);
	}
	
	@Test
	public void testAddPiece1() {
		int x = game.getNumPieces() ;
		game.addPiece();
		assertTrue("AddPiece has a malfunction",x+1 == game.getNumPieces()) ;	
		int y = game2.getNumPieces() ;
		game2.addPiece();
		assertTrue("AddPiece has a malfunction",y+1 == game2.getNumPieces()) ;
	}
		
	@Test
	public void testAddPiece() {
		assertTrue("The return number is less than 0",game.getNumPieces() >= 0);
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
		game.setPieceAt(2, 0, 0);
		int y = game.getNumPieces();
		game.addPiece();
		assertTrue("getNumPieces has a malfunction"+y + game.getNumPieces() ,y+1 == game.getNumPieces()); 
		int x = game.getPieceAt(2,0) ;
		if ( x == 2 || x ==4) ;
		else assert(false) ; 
	}
	
	@Test
	public void testGetBoardWidth() {
		assertTrue("The Board Width is less than 0 " ,game.getBoardWidth() > 0) ;
		assertTrue("The Board Width is less than 0 " ,game2.getBoardWidth() > 0) ;
	}
	
	
	@Test
	public void testGetBoardHeight() {
		assertTrue("The Board Height is less than 0 " ,game.getBoardHeight() > 0) ;
		assertTrue("The Board Height is less than 0 " ,game2.getBoardHeight() > 0) ;
	}
	
	@Test
	public void testGetNumPieces() {
		assertTrue("The return number is less than 0",game.getNumPieces() >= 0);
		assertTrue("The return number is less than 0",game2.getNumPieces() >= 0);
	}
	
	@Test
	public void testGetPoints() {
		assertTrue("The returned points are less than 0 ",game.getPoints() >= 0);
		assertTrue("The returned points are less than 0 ",game2.getPoints() >= 0);
	}
	
	@Test
	public void testGetPieceAt() {
		int x = 92 ;
		game.setPieceAt(1, 1, x);
		assertTrue("GetPiece/SetPiece has a malfunction",x == game.getPieceAt(1,1)) ; 
		game2.setPieceAt(4, 4, x);
		assertTrue("GetPiece/SetPiece has a malfunction",x == game.getPieceAt(4,4)) ;
	}
	
	@Test
	public void testPerformMove1() {
		//moveNOrth funktioniert
		game1.setPieceAt(0, 1, 0);
		game1.setPieceAt(0, 2, 0);
		game1.setPieceAt(0, 3, 0);
		game1.setPieceAt(0, 0, 0);
		game1.setPieceAt(1, 1, 0);
		game1.setPieceAt(1, 2, 0);
		game1.setPieceAt(1, 3, 0);
		game1.setPieceAt(1, 0, 0);
		game1.setPieceAt(3, 1, 0);
		game1.setPieceAt(3, 2, 0);
		game1.setPieceAt(3, 3, 0);
		game1.setPieceAt(3, 0, 0);
		game1.setPieceAt(2, 1, 0);
		game1.setPieceAt(2, 2, 0);
		game1.setPieceAt(2, 3, 0);
		game1.setPieceAt(2, 0, 0);
		game1.setPieceAt(0, 1, 2);
		assertTrue("IsMovePossible Direction " + game1.isMovePossible() ,true == game1.isMovePossible(MoveDirection.NORTH));
		assertTrue("PerformMove1",true == game1.performMove(MoveDirection.NORTH));
		int x = game1.getPieceAt(0,0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game1.isMovePossible(MoveDirection.NORTH),false == game1.isMovePossible(MoveDirection.NORTH));
		assertTrue("PerformMove1",false == game1.performMove(MoveDirection.NORTH));
		game1.setPieceAt(0,0,0);
		
		game1.setPieceAt(0,2,2) ;
		assertTrue("IsMovePossible Direction " + game1.isMovePossible() ,true == game1.isMovePossible(MoveDirection.SOUTH));
		assertTrue("PerformMove2",true == game1.performMove(MoveDirection.SOUTH)) ;
		 x = game1.getPieceAt(0,3) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game1.isMovePossible(MoveDirection.SOUTH),false == game1.isMovePossible(MoveDirection.SOUTH));
		assertTrue("PerformMove2",false == game1.performMove(MoveDirection.SOUTH));
		game1.setPieceAt(0, 3, 0);
		
		game1.setPieceAt(1,0,2) ;
		assertTrue("IsMovePossible Direction " + game1.isMovePossible() ,true == game1.isMovePossible(MoveDirection.WEST));
		boolean y = game1.performMove(MoveDirection.WEST) ;
		assertTrue("PerformMove3 " + y  ,true == y) ;
		 x = game1.getPieceAt(0,0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game1.isMovePossible(MoveDirection.WEST),false == game1.isMovePossible(MoveDirection.WEST));
		assertTrue("PerformMove3 " +" 2 " + game1.performMove(MoveDirection.WEST),false == game1.performMove(MoveDirection.WEST));
		game1.setPieceAt(0, 0, 0);
		//jo
		game1.setPieceAt(2,0,2) ;
		assertTrue("IsMovePossible Direction " + game1.isMovePossible() ,true == game1.isMovePossible(MoveDirection.EAST));
		assertTrue("PerformMove4",true == game1.performMove(MoveDirection.EAST)) ;
		 x = game1.getPieceAt(3,0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game1.isMovePossible(MoveDirection.EAST),false == game1.isMovePossible(MoveDirection.EAST));
		assertTrue("PerformMove4",false == game1.performMove(MoveDirection.EAST));
		game1.setPieceAt(3, 0, 0);
		
	}
	
	
	@Test
	//game.getPoints() game.getNumeMoves() and game.isSpaceleft() 
	public void testIsSpaceLeft() {
		assertEquals(" GetPoints Initial failed"+ game.getPoints(),game.getPoints() , 0 ) ;
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
		int y = game.getNumMoves() ;
		game.performMove(MoveDirection.EAST);
		int x = game.getPoints() ;
		assertTrue("getNumMoves has a malfunction",y+1 == game.getNumMoves()) ;
		assertEquals(" GetPoints1 has a malfunction" + x ,x,32);
		game.setPieceAt(0, 1, 2);
		game.setPieceAt(0, 2, 2);
		game.setPieceAt(0, 3, 2);
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(1, 1, 2);
		game.setPieceAt(1, 2, 2);
		game.setPieceAt(1, 3, 2);
		game.setPieceAt(1, 0, 2);
		assertEquals("isSpaceLeft has a malfunction ",false,game.isSpaceLeft()) ;
		
	}
	
	@Test
	public void testisMovePossible() {
		assertEquals("isMovePossible has a malfunction " , true , game.isMovePossible() ) ; 
		game.setPieceAt(0, 1, 4);
		game.setPieceAt(0, 2, 8);
		game.setPieceAt(0, 3, 16);
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(1, 1, 32);
		game.setPieceAt(1, 2, 8);
		game.setPieceAt(1, 3, 16);
		game.setPieceAt(1, 0, 4);
		game.setPieceAt(3, 1, 6);
		game.setPieceAt(3, 2, 7);
		game.setPieceAt(3, 3, 16);
		game.setPieceAt(3, 0, 9);
		game.setPieceAt(2, 1, 66);
		game.setPieceAt(2, 2, 21);
		game.setPieceAt(2, 3, 416);
		game.setPieceAt(2, 0, 52);
		assertEquals("isMovePossible has a malfunction"+ game.isMovePossible() , false , game.isMovePossible()) ;
	}
}
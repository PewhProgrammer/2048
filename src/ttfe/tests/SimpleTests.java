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

	private SimulatorInterface game,game2;

	@Before
	public void setUp() {
		game = TTFEFactory.createSimulator(4, 4, new Random(0));
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
				4 == game.getBoardHeight());
		assertTrue("The initial game2 board did not have correct height",
				5 == game2.getBoardHeight());
	}
	
	@Test
	public void testInitialBoardWidth(){
		assertTrue("The initial game board did not have correct width",
				4 == game.getBoardWidth()) ;
		assertTrue("The initial game board did not have correct width",
				5 == game2.getBoardWidth()) ;
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
		assertTrue("The return number is less than 0",game2.getNumPieces() >= 0);
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
	public void testAddPiece5x5(){
		game2.setPieceAt(0, 0, 4);game2.setPieceAt(1, 0, 4);game2.setPieceAt(2, 0, 4);game2.setPieceAt(3, 0, 4);game2.setPieceAt(4, 0, 4);
		game2.setPieceAt(0, 1, 4);game2.setPieceAt(1, 1, 4);game2.setPieceAt(2, 1, 4);game2.setPieceAt(3, 1, 4);game2.setPieceAt(4, 1, 4);
		game2.setPieceAt(0, 2, 4);game2.setPieceAt(1, 2, 4);game2.setPieceAt(2, 2, 4);game2.setPieceAt(3, 2, 4);game2.setPieceAt(4, 2, 4);
		game2.setPieceAt(0, 3, 4);game2.setPieceAt(1, 3, 4);game2.setPieceAt(2, 3, 4);game2.setPieceAt(3, 3, 4);game2.setPieceAt(4, 3, 4);
		game2.setPieceAt(0, 4, 4);game2.setPieceAt(1, 4, 4);game2.setPieceAt(2, 4, 4);game2.setPieceAt(3, 4, 4);game2.setPieceAt(4, 4, 0);
		
		int y = game2.getNumPieces();
		game2.addPiece();
		assertTrue("getNumPieces has a malfunction"+y + game2.getNumPieces() ,y+1 == game2.getNumPieces()); 
		int x = game2.getPieceAt(4,4) ;
		if ( x == 2 || x == 4) ;
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
	public void testGetPieceAt() {
		int x = 92 ;
		game.setPieceAt(1, 1, x);
		assertTrue("GetPiece/SetPiece has a malfunction" +  x + game.getPieceAt(3,3),x == game.getPieceAt(1,1)) ; 
		game2.setPieceAt(4, 4, x);
		assertTrue("GetPiece/SetPiece has a malfunction"+  x + game2.getPieceAt(4,4) ,x == game2.getPieceAt(4,4)) ;
	}
	
	@Test
	public void testPerformMove1() {
		//moveNOrth funktioniert
		game.setPieceAt(0, 1, 0);
		game.setPieceAt(0, 2, 0);
		game.setPieceAt(0, 3, 0);
		game.setPieceAt(0, 0, 0);
		game.setPieceAt(1, 1, 0);
		game.setPieceAt(1, 2, 0);
		game.setPieceAt(1, 3, 0);
		game.setPieceAt(1, 0, 0);
		game.setPieceAt(3, 1, 0);
		game.setPieceAt(3, 2, 0);
		game.setPieceAt(3, 3, 0);
		game.setPieceAt(3, 0, 0);
		game.setPieceAt(2, 1, 0);
		game.setPieceAt(2, 2, 0);
		game.setPieceAt(2, 3, 0);
		game.setPieceAt(2, 0, 0);
		game.setPieceAt(0, 1, 2);
		assertTrue("IsMovePossible Direction " + game.isMovePossible(MoveDirection.NORTH) ,true == game.isMovePossible(MoveDirection.NORTH));
		assertTrue("PerformMove1",true == game.performMove(MoveDirection.NORTH));
		int f = game.getPieceAt(0,1) ;
		assertEquals("PerformMove does not delete his past tile " , f , 0) ; 
		int x = game.getPieceAt(0,0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game.isMovePossible(MoveDirection.NORTH),false == game.isMovePossible(MoveDirection.NORTH));
		assertTrue("PerformMove1",false == game.performMove(MoveDirection.NORTH));
		game.setPieceAt(0,0,0);
		
		game.setPieceAt(0,2,2) ;
		assertTrue("IsMovePossible Direction " + game.isMovePossible() ,true == game.isMovePossible(MoveDirection.SOUTH));
		assertTrue("PerformMove2",true == game.performMove(MoveDirection.SOUTH)) ;
		 x = game.getPieceAt(0,3) ; 
		 f = game.getPieceAt(0,2) ;
		assertEquals("PerformMove does not delete his past tile " , f , 0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game.isMovePossible(MoveDirection.SOUTH),false == game.isMovePossible(MoveDirection.SOUTH));
		assertTrue("PerformMove2",false == game.performMove(MoveDirection.SOUTH));
		game.setPieceAt(0, 3, 0);
		
		game.setPieceAt(1,0,2) ;
		assertTrue("IsMovePossible Direction " + game.isMovePossible(MoveDirection.WEST) ,true == game.isMovePossible(MoveDirection.WEST));
		boolean y = game.performMove(MoveDirection.WEST) ;
		assertTrue("PerformMove3 " + y  ,true == y) ;
		f = game.getPieceAt(1,0) ;
		assertEquals("PerformMove does not delete his past tile " , f , 0) ; 
		 x = game.getPieceAt(0,0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game.isMovePossible(MoveDirection.WEST),false == game.isMovePossible(MoveDirection.WEST));
		assertTrue("PerformMove3 " +" 2 " + game.performMove(MoveDirection.WEST),false == game.performMove(MoveDirection.WEST));
		game.setPieceAt(0, 0, 0);
		//jo
		game.setPieceAt(2,0,2) ;
		
		System.out.println("Das sind die ersten Ergbenisse oben : \n" +
				game.getPieceAt(0, 0) + game.getPieceAt(1, 0) + game.getPieceAt(2, 0) + game.getPieceAt(3, 0) +"\n"
				+ game.getPieceAt(0, 1) + game.getPieceAt(1, 1) + game.getPieceAt(2, 1) + game.getPieceAt(3, 1)+"\n"
				+ game.getPieceAt(0, 2) + game.getPieceAt(1, 2) + game.getPieceAt(2, 2) + game.getPieceAt(3, 2)+"\n"
				+ game.getPieceAt(0, 3) + game.getPieceAt(1, 3) + game.getPieceAt(2, 3) + game.getPieceAt(3, 3) ) ;
		
		
		assertTrue("IsMovePossible Direction " + game.isMovePossible(MoveDirection.EAST) ,true == game.isMovePossible(MoveDirection.EAST));
		assertTrue("PerformMove4",true == game.performMove(MoveDirection.EAST)) ;
		f = game.getPieceAt(0,1) ;
		assertEquals("PerformMove does not delete his past tile " , f , 0) ; 
		 x = game.getPieceAt(3,0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game.isMovePossible(MoveDirection.EAST),false == game.isMovePossible(MoveDirection.EAST));
		assertTrue("PerformMove4",false == game.performMove(MoveDirection.EAST));
		game.setPieceAt(3, 0, 0);
		
	}
	
	@Test
	public void testPerformMove15x5(){
		game2.setPieceAt(0, 0, 0);game2.setPieceAt(1, 0, 0);game2.setPieceAt(2, 0, 0);game2.setPieceAt(3, 0, 0);game2.setPieceAt(4, 0, 0);
		game2.setPieceAt(0, 1, 2);game2.setPieceAt(1, 1, 0);game2.setPieceAt(2, 1, 0);game2.setPieceAt(3, 1, 0);game2.setPieceAt(4, 1, 0);
		game2.setPieceAt(0, 2, 0);game2.setPieceAt(1, 2, 0);game2.setPieceAt(2, 2, 0);game2.setPieceAt(3, 2, 0);game2.setPieceAt(4, 2, 0);
		game2.setPieceAt(0, 3, 0);game2.setPieceAt(1, 3, 0);game2.setPieceAt(2, 3, 0);game2.setPieceAt(3, 3, 0);game2.setPieceAt(4, 3, 0);
		game2.setPieceAt(0, 4, 0);game2.setPieceAt(1, 4, 0);game2.setPieceAt(2, 4, 0);game2.setPieceAt(3, 4, 0);game2.setPieceAt(4, 4, 0);
		
		
		assertTrue("IsMovePossible Direction " + game2.isMovePossible(MoveDirection.NORTH) ,true == game2.isMovePossible(MoveDirection.NORTH));
		assertTrue("PerformMove1",true == game2.performMove(MoveDirection.NORTH));
		int f = game2.getPieceAt(0,1) ;
		assertEquals("PerformMove does not delete his past tile " , f , 0) ; 
		int x = game2.getPieceAt(0,0) ; 
		assertTrue("IsMovePossible Direction " + game2.isMovePossible(MoveDirection.NORTH),false == game2.isMovePossible(MoveDirection.NORTH));
		assertTrue("PerformMove1",false == game2.performMove(MoveDirection.NORTH));
		game2.setPieceAt(0,0,0);
		
		game2.setPieceAt(0,3,2) ;
		
		System.out.println("Das sind die ersten Ergbenisse oben : \n" +
				game2.getPieceAt(0, 0) + game2.getPieceAt(1, 0) + game2.getPieceAt(2, 0) + game2.getPieceAt(3, 0) + game2.getPieceAt(4,0)+"\n" 
				+ game2.getPieceAt(0, 1) + game2.getPieceAt(1, 1) + game2.getPieceAt(2, 1) + game2.getPieceAt(3, 1)+  game2.getPieceAt(4,1)+"\n"
				+ game2.getPieceAt(0, 2) + game2.getPieceAt(1, 2) + game2.getPieceAt(2, 2) + game2.getPieceAt(3, 2)+  game2.getPieceAt(4,2)+ "\n"
				+ game2.getPieceAt(0, 3) + game2.getPieceAt(1, 3) + game2.getPieceAt(2, 3) + game2.getPieceAt(3, 3) +  game2.getPieceAt(4,3)+"\n"
				+ game2.getPieceAt(0, 4) + game2.getPieceAt(1, 4) + game2.getPieceAt(2, 4) + game2.getPieceAt(3, 4) +  game2.getPieceAt(4,4)) ;
		
		assertTrue("IsMovePossible Direction " + game2.isMovePossible() ,true == game2.isMovePossible(MoveDirection.SOUTH));
		assertTrue("PerformMove2",true == game2.performMove(MoveDirection.SOUTH)) ;
		 x = game2.getPieceAt(0,4) ; 
		 f = game2.getPieceAt(0,3) ;
		 System.out.println("Das sind die ersten Ergbenisse oben : \n" +
					game2.getPieceAt(0, 0) + game2.getPieceAt(1, 0) + game2.getPieceAt(2, 0) + game2.getPieceAt(3, 0) + game2.getPieceAt(4,0)+"\n" 
					+ game2.getPieceAt(0, 1) + game2.getPieceAt(1, 1) + game2.getPieceAt(2, 1) + game2.getPieceAt(3, 1)+  game2.getPieceAt(4,1)+"\n"
					+ game2.getPieceAt(0, 2) + game2.getPieceAt(1, 2) + game2.getPieceAt(2, 2) + game2.getPieceAt(3, 2)+  game2.getPieceAt(4,2)+ "\n"
					+ game2.getPieceAt(0, 3) + game2.getPieceAt(1, 3) + game2.getPieceAt(2, 3) + game2.getPieceAt(3, 3) +  game2.getPieceAt(4,3)+"\n"
					+ game2.getPieceAt(0, 4) + game2.getPieceAt(1, 4) + game2.getPieceAt(2, 4) + game2.getPieceAt(3, 4) +  game2.getPieceAt(4,4)) ;
		 
		 System.out.println("lol : "+x+"lol2 :" + f);
		assertEquals("PerformMove does not delete his past tile " , f , 0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game2.isMovePossible(MoveDirection.SOUTH),false == game2.isMovePossible(MoveDirection.SOUTH));
		assertTrue("PerformMove2",false == game2.performMove(MoveDirection.SOUTH));
		game2.setPieceAt(0, 3, 0);
		
		game2.setPieceAt(1,0,2) ;
		
		assertTrue("IsMovePossible Direction " + game2.isMovePossible(MoveDirection.WEST) ,true == game2.isMovePossible(MoveDirection.WEST));
		boolean y = game2.performMove(MoveDirection.WEST) ;
		assertTrue("PerformMove3 " + y  ,true == y) ;
		f = game2.getPieceAt(1,0) ;
		assertEquals("PerformMove does not delete his past tile " , f , 0) ; 
		 x = game2.getPieceAt(0,0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game2.isMovePossible(MoveDirection.WEST),false == game2.isMovePossible(MoveDirection.WEST));
		assertTrue("PerformMove3 " +" 2 " + game2.performMove(MoveDirection.WEST),false == game2.performMove(MoveDirection.WEST));
		game2.setPieceAt(0, 0, 0);
		//jo
		game2.setPieceAt(3,0,2) ;
		
		
		assertTrue("IsMovePossible Direction " + game2.isMovePossible(MoveDirection.EAST) ,true == game2.isMovePossible(MoveDirection.EAST));
		assertTrue("PerformMove4",true == game2.performMove(MoveDirection.EAST)) ;
		f = game2.getPieceAt(3,0) ;
		assertEquals("PerformMove does not delete his past tile " , f , 0) ; 
		 x = game2.getPieceAt(4,0) ; 
		assertEquals("Equals is wrong " + x , x , 2) ;
		assertTrue("IsMovePossible Direction " + game2.isMovePossible(MoveDirection.EAST),false == game2.isMovePossible(MoveDirection.EAST));
		assertTrue("PerformMove4",false == game2.performMove(MoveDirection.EAST));
		game2.setPieceAt(3, 0, 0);
		
	}
	
	
	@Test
	//game.getPoints() game.getNumeMoves() and game.isSpaceleft() 
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
		assertEquals("isSpaceLeft has a malfunction ",true,game.isSpaceLeft()) ;
		game.setPieceAt(2, 0, 2);
		assertEquals("isSpaceLeft has a malfunction ",false,game.isSpaceLeft()) ;
		
	}
	
	@Test
	public void testIsSpaceLeft5x5(){
		game2.setPieceAt(0, 0, 4);game2.setPieceAt(1, 0, 4);game2.setPieceAt(2, 0, 4);game2.setPieceAt(3, 0, 4);game2.setPieceAt(4, 0, 4);
		game2.setPieceAt(0, 1, 4);game2.setPieceAt(1, 1, 4);game2.setPieceAt(2, 1, 4);game2.setPieceAt(3, 1, 4);game2.setPieceAt(4, 1, 4);
		game2.setPieceAt(0, 2, 4);game2.setPieceAt(1, 2, 4);game2.setPieceAt(2, 2, 4);game2.setPieceAt(3, 2, 4);game2.setPieceAt(4, 2, 4);
		game2.setPieceAt(0, 3, 4);game2.setPieceAt(1, 3, 4);game2.setPieceAt(2, 3, 4);game2.setPieceAt(3, 3, 4);game2.setPieceAt(4, 3, 4);
		game2.setPieceAt(0, 4, 4);game2.setPieceAt(1, 4, 4);game2.setPieceAt(2, 4, 4);game2.setPieceAt(3, 4, 4);game2.setPieceAt(4, 4, 0);
		assertEquals("isSpaceLeft has a malfunction ",true,game2.isSpaceLeft()) ;
		game2.setPieceAt(4, 4, 2);
		assertEquals("isSpaceLeft has a malfunction ",false,game2.isSpaceLeft()) ;
	}
	
	@Test
	public void testGetNumMoves1(){
		int y = game.getNumMoves() ;
		game.performMove(MoveDirection.EAST);
		assertTrue("getNumMoves has a malfunction",y+1 == game.getNumMoves()) ;
	}
	
	@Test
	public void testGetNumMoves15x5(){
		int y = game2.getNumMoves() ;
		game2.performMove(MoveDirection.EAST);
		assertTrue("getNumMOves has a malfunction",y+1 == game2.getNumMoves()) ; 
		}
	@Test 
	public void testMaxMoves(){
		int x = game.getNumMoves();
		assertTrue("The maximum number of moves has overflowed " , x <= 131038) ;
	}
	
	@Test
	public void testMaxMoves5x5(){
		int x = game2.getNumMoves();
		assertTrue("The maximum number of moves has overflowed " , x <= 131038) ;
	}
	
	@Test
	public void testGetPoints() {
		assertTrue("The returned points are less than 0 ",game.getPoints() >= 0);
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
		game.performMove(MoveDirection.EAST);
		int x = game.getPoints();
		assertEquals(" GetPoints1 has a malfunction" + x + game.getPoints() ,x,32);
	}
	
	@Test
	public void testGetPoints5x5(){
		assertTrue("The returned points are less than 0 ",game2.getPoints() >= 0);
		game2.setPieceAt(0, 0, 4);game2.setPieceAt(1, 0, 4);game2.setPieceAt(2, 0, 4);game2.setPieceAt(3, 0, 4);game2.setPieceAt(4, 0, 4);
		game2.setPieceAt(0, 1, 4);game2.setPieceAt(1, 1, 4);game2.setPieceAt(2, 1, 4);game2.setPieceAt(3, 1, 4);game2.setPieceAt(4, 1, 4);
		game2.setPieceAt(0, 2, 4);game2.setPieceAt(1, 2, 4);game2.setPieceAt(2, 2, 4);game2.setPieceAt(3, 2, 4);game2.setPieceAt(4, 2, 4);
		game2.setPieceAt(0, 3, 4);game2.setPieceAt(1, 3, 4);game2.setPieceAt(2, 3, 4);game2.setPieceAt(3, 3, 4);game2.setPieceAt(4, 3, 4);
		game2.setPieceAt(0, 4, 4);game2.setPieceAt(1, 4, 4);game2.setPieceAt(2, 4, 4);game2.setPieceAt(3, 4, 4);game2.setPieceAt(4, 4, 4);
		
		game2.performMove(MoveDirection.WEST);
		
		System.out.println("Das sind die ersten Ergbenisse oben : \n" +
				game2.getPieceAt(0, 0) + game2.getPieceAt(1, 0) + game2.getPieceAt(2, 0) + game2.getPieceAt(3, 0) + game2.getPieceAt(4,0)+"\n" 
				+ game2.getPieceAt(0, 1) + game2.getPieceAt(1, 1) + game2.getPieceAt(2, 1) + game2.getPieceAt(3, 1)+  game2.getPieceAt(4,1)+"\n"
				+ game2.getPieceAt(0, 2) + game2.getPieceAt(1, 2) + game2.getPieceAt(2, 2) + game2.getPieceAt(3, 2)+  game2.getPieceAt(4,2)+ "\n"
				+ game2.getPieceAt(0, 3) + game2.getPieceAt(1, 3) + game2.getPieceAt(2, 3) + game2.getPieceAt(3, 3) +  game2.getPieceAt(4,3)+"\n"
				+ game2.getPieceAt(0, 4) + game2.getPieceAt(1, 4) + game2.getPieceAt(2, 4) + game2.getPieceAt(3, 4) +  game2.getPieceAt(4,4)) ;
		
		int x = game2.getPoints();
		assertEquals(" GetPoints1 has a malfunction" + x + game2.getPoints() ,x,80);
	}
	
	@Test
	public void testMaxPoints() {
		int y = game2.getPoints() ;
		int x = game.getPoints() ;
		assertTrue("MaxPoints is overflowed " , 3932156 >= x) ; 
		assertTrue("MaxPoints is overflowed " , 3932156 >= y) ; 
	}
	
	@Test
	public void testIsMovePossible() {
		assertEquals("isMovePossible has a malfunction " , true , game.isMovePossible() ) ; 
		game.setPieceAt(0, 0, 2);game.setPieceAt(0, 1, 4);game.setPieceAt(0, 2, 2);game.setPieceAt(0, 3, 4);
		game.setPieceAt(1, 0, 4);game.setPieceAt(1, 1, 2);game.setPieceAt(1, 2, 4);game.setPieceAt(1, 3, 2);
		game.setPieceAt(2, 0, 2);game.setPieceAt(2, 1, 4);game.setPieceAt(2, 2, 2);game.setPieceAt(2, 3, 4);
		game.setPieceAt(3, 0, 4);game.setPieceAt(3, 1, 2);game.setPieceAt(3, 2, 4);game.setPieceAt(3, 3, 2);
		
		assertEquals("isMovePossible has a malfunction "+ game.isMovePossible() , false , game.isMovePossible()) ;
	}
	
	@Test
	public void testIsMovePossible5x5(){
		assertEquals("isMovePossible has a malfunction " , true , game2.isMovePossible() ) ; 
		game2.setPieceAt(0, 0, 4);game2.setPieceAt(1, 0, 2);game2.setPieceAt(2, 0, 4);game2.setPieceAt(3, 0, 2);game2.setPieceAt(4, 0, 4);
		game2.setPieceAt(0, 1, 2);game2.setPieceAt(1, 1, 4);game2.setPieceAt(2, 1, 2);game2.setPieceAt(3, 1, 4);game2.setPieceAt(4, 1, 2);
		game2.setPieceAt(0, 2, 4);game2.setPieceAt(1, 2, 2);game2.setPieceAt(2, 2, 4);game2.setPieceAt(3, 2, 2);game2.setPieceAt(4, 2, 4);
		game2.setPieceAt(0, 3, 2);game2.setPieceAt(1, 3, 4);game2.setPieceAt(2, 3, 2);game2.setPieceAt(3, 3, 4);game2.setPieceAt(4, 3, 2);
		game2.setPieceAt(0, 4, 4);game2.setPieceAt(1, 4, 2);game2.setPieceAt(2, 4, 4);game2.setPieceAt(3, 4, 2);game2.setPieceAt(4, 4, 4);
		
		assertEquals("isMovePossible has a malfunction "+ game2.isMovePossible() , false , game2.isMovePossible()) ;
	}
	
	@Test
	public void testEmptyisMovePossible() {
	game.setPieceAt(0, 1, 0);
	game.setPieceAt(0, 2, 0);
	game.setPieceAt(0, 3, 0);
	game.setPieceAt(0, 0, 0);
	game.setPieceAt(1, 1, 0);
	game.setPieceAt(1, 2, 0);
	game.setPieceAt(1, 3, 0);
	game.setPieceAt(1, 0, 0);
	game.setPieceAt(3, 1, 0);
	game.setPieceAt(3, 2, 0);
	game.setPieceAt(3, 3, 0);
	game.setPieceAt(3, 0, 0);
	game.setPieceAt(2, 1, 0);
	game.setPieceAt(2, 2, 0);
	game.setPieceAt(2, 3, 0);
	game.setPieceAt(2, 0, 0);
	assertEquals("EmptyisMovePossible has a malfunction 1 " + game.isMovePossible() ,game.isMovePossible() , false ) ;
	
	
	}
	
	@Test
	public void testEmptyIsMovePossible5x5(){
		game2.setPieceAt(0, 0, 0);game2.setPieceAt(1, 0, 0);game2.setPieceAt(2, 0, 0);game2.setPieceAt(3, 0, 0);game2.setPieceAt(4, 0, 0);
		game2.setPieceAt(0, 1, 0);game2.setPieceAt(1, 1, 0);game2.setPieceAt(2, 1, 0);game2.setPieceAt(3, 1, 0);game2.setPieceAt(4, 1, 0);
		game2.setPieceAt(0, 2, 0);game2.setPieceAt(1, 2, 0);game2.setPieceAt(2, 2, 0);game2.setPieceAt(3, 2, 0);game2.setPieceAt(4, 2, 0);
		game2.setPieceAt(0, 3, 0);game2.setPieceAt(1, 3, 0);game2.setPieceAt(2, 3, 0);game2.setPieceAt(3, 3, 0);game2.setPieceAt(4, 3, 0);
		game2.setPieceAt(0, 4, 0);game2.setPieceAt(1, 4, 0);game2.setPieceAt(2, 4, 0);game2.setPieceAt(3, 4, 0);game2.setPieceAt(4, 4, 0);
		assertEquals("EmptyisMovePossible has a malfunction 1 " + game2.isMovePossible() ,game2.isMovePossible() , false ) ;
	}
	
	@Test
	public void testFullIsMovePossible() {
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
		assertTrue("FullisMovePossible has a malfunction" + game.isMovePossible(), game.isMovePossible()) ;
	}
	
	@Test
	public void testFullIsMovePossible5x5() {
		game2.setPieceAt(0, 0, 4);game2.setPieceAt(1, 0, 4);game2.setPieceAt(2, 0, 4);game2.setPieceAt(3, 0, 4);game2.setPieceAt(4, 0, 4);
		game2.setPieceAt(0, 1, 4);game2.setPieceAt(1, 1, 4);game2.setPieceAt(2, 1, 4);game2.setPieceAt(3, 1, 4);game2.setPieceAt(4, 1, 4);
		game2.setPieceAt(0, 2, 4);game2.setPieceAt(1, 2, 4);game2.setPieceAt(2, 2, 4);game2.setPieceAt(3, 2, 4);game2.setPieceAt(4, 2, 4);
		game2.setPieceAt(0, 3, 4);game2.setPieceAt(1, 3, 4);game2.setPieceAt(2, 3, 4);game2.setPieceAt(3, 3, 4);game2.setPieceAt(4, 3, 4);
		game2.setPieceAt(0, 4, 4);game2.setPieceAt(1, 4, 4);game2.setPieceAt(2, 4, 4);game2.setPieceAt(3, 4, 4);game2.setPieceAt(4, 4, 4);
		assertTrue("FullisMovePossible has a malfunction" + game2.isMovePossible(), game2.isMovePossible()) ;
	}

	
	@Test
	public void testcorner1() {
		
		game.setPieceAt(0, 1, 0);
		game.setPieceAt(0, 2, 0);
		game.setPieceAt(0, 3, 0);
		game.setPieceAt(0, 0, 2);
		game.setPieceAt(1, 1, 0);
		game.setPieceAt(1, 2, 0);
		game.setPieceAt(1, 3, 0);
		game.setPieceAt(1, 0, 0);
		game.setPieceAt(3, 1, 0);
		game.setPieceAt(3, 2, 0);
		game.setPieceAt(3, 3, 0);
		game.setPieceAt(3, 0, 0);
		game.setPieceAt(2, 1, 0);
		game.setPieceAt(2, 2, 0);
		game.setPieceAt(2, 3, 0);
		game.setPieceAt(2, 0, 0);
		assertTrue("Initial MovePossible is wrong ", game.isMovePossible()) ;
		assertTrue("SOUTH/EAST MOVEMENT IS WRONG" , (game.isMovePossible(MoveDirection.EAST) && 
				game.isMovePossible(MoveDirection.SOUTH) )) ; 
		assertTrue("NORTH/WEST MOVEMENT IS WRONG " , (false == game.isMovePossible(MoveDirection.WEST)) && (
				false == game.isMovePossible(MoveDirection.NORTH) ) );
		
	}
	
	@Test
	public void testcorner15x5(){
		game2.setPieceAt(0, 0, 2);game2.setPieceAt(1, 0, 0);game2.setPieceAt(2, 0, 0);game2.setPieceAt(3, 0, 0);game2.setPieceAt(4, 0, 0);
		game2.setPieceAt(0, 1, 0);game2.setPieceAt(1, 1, 0);game2.setPieceAt(2, 1, 0);game2.setPieceAt(3, 1, 0);game2.setPieceAt(4, 1, 0);
		game2.setPieceAt(0, 2, 0);game2.setPieceAt(1, 2, 0);game2.setPieceAt(2, 2, 0);game2.setPieceAt(3, 2, 0);game2.setPieceAt(4, 2, 0);
		game2.setPieceAt(0, 3, 0);game2.setPieceAt(1, 3, 0);game2.setPieceAt(2, 3, 0);game2.setPieceAt(3, 3, 0);game2.setPieceAt(4, 3, 0);
		game2.setPieceAt(0, 4, 0);game2.setPieceAt(1, 4, 0);game2.setPieceAt(2, 4, 0);game2.setPieceAt(3, 4, 0);game2.setPieceAt(4, 4, 0);
		
		assertTrue("Initial MovePossible is wrong ", game2.isMovePossible()) ;
		assertTrue("SOUTH/EAST MOVEMENT IS WRONG" , (game2.isMovePossible(MoveDirection.EAST) && 
				game2.isMovePossible(MoveDirection.SOUTH) )) ; 
		assertTrue("NORTH/WEST MOVEMENT IS WRONG " , (false == game2.isMovePossible(MoveDirection.WEST)) && (
				false == game2.isMovePossible(MoveDirection.NORTH) ) );
	}
	
	@Test
	public void testcorner2(){
		game.setPieceAt(0, 0, 0);game.setPieceAt(1, 0, 0);game.setPieceAt(2, 0, 0);game.setPieceAt(3, 0, 0);
		game.setPieceAt(0, 1, 0);game.setPieceAt(1, 1, 0);game.setPieceAt(2, 1, 0);game.setPieceAt(3, 1, 0);
		game.setPieceAt(0, 2, 0);game.setPieceAt(1, 2, 0);game.setPieceAt(2, 2, 0);game.setPieceAt(3, 2, 0);
		game.setPieceAt(0, 3, 0);game.setPieceAt(1, 3, 0);game.setPieceAt(2, 3, 0);game.setPieceAt(3, 3, 2);
		
	
		assertTrue("Initial MovePossible is wrong ", game.isMovePossible()) ;
		
		assertTrue("NORTH/EAST MOVEMENT IS WRONG" , (game.isMovePossible(MoveDirection.WEST) && 
				game.isMovePossible(MoveDirection.NORTH) )) ; 
		assertTrue("EAST/SOUTH MOVEMENT IS WRONG " 
				+ game.isMovePossible(MoveDirection.EAST)+game.isMovePossible(MoveDirection.SOUTH) ,(false == game.isMovePossible(MoveDirection.EAST)) && (
				false == game.isMovePossible(MoveDirection.SOUTH) ) );
	}
	
	@Test
	public void testcorner25x5(){
		game2.setPieceAt(0, 0, 0);game2.setPieceAt(1, 0, 0);game2.setPieceAt(2, 0, 0);game2.setPieceAt(3, 0, 0);game2.setPieceAt(4, 0, 0);
		game2.setPieceAt(0, 1, 0);game2.setPieceAt(1, 1, 0);game2.setPieceAt(2, 1, 0);game2.setPieceAt(3, 1, 0);game2.setPieceAt(4, 1, 0);
		game2.setPieceAt(0, 2, 0);game2.setPieceAt(1, 2, 0);game2.setPieceAt(2, 2, 0);game2.setPieceAt(3, 2, 0);game2.setPieceAt(4, 2, 0);
		game2.setPieceAt(0, 3, 0);game2.setPieceAt(1, 3, 0);game2.setPieceAt(2, 3, 0);game2.setPieceAt(3, 3, 0);game2.setPieceAt(4, 3, 0);
		game2.setPieceAt(0, 4, 0);game2.setPieceAt(1, 4, 0);game2.setPieceAt(2, 4, 0);game2.setPieceAt(3, 4, 0);game2.setPieceAt(4, 4, 2);
		
		assertTrue("Initial MovePossible is wrong ", game2.isMovePossible()) ;
		
		assertTrue("NORTH/EAST MOVEMENT IS WRONG" , (game2.isMovePossible(MoveDirection.WEST) && 
				game2.isMovePossible(MoveDirection.NORTH) )) ; 
		assertTrue("EAST/SOUTH MOVEMENT IS WRONG " 
				+ game2.isMovePossible(MoveDirection.EAST)+game2.isMovePossible(MoveDirection.SOUTH) ,(false == game2.isMovePossible(MoveDirection.EAST)) && (
				false == game2.isMovePossible(MoveDirection.SOUTH) ) );
	}
	@Test
	public void TEST() {
		game.setPieceAt(0, 0, 2);game.setPieceAt(1, 0, 4);game.setPieceAt(2, 0, 4);game.setPieceAt(3, 0, 4);
		game.setPieceAt(0, 1, 2);game.setPieceAt(1, 1, 4);game.setPieceAt(2, 1, 4);game.setPieceAt(3, 1, 4);
		game.setPieceAt(0, 2, 2);game.setPieceAt(1, 2, 4);game.setPieceAt(2, 2, 4);game.setPieceAt(3, 2, 4);
		game.setPieceAt(0, 3, 2);game.setPieceAt(1, 3, 4);game.setPieceAt(2, 3, 4);game.setPieceAt(3, 3, 4);
		
		game.performMove(MoveDirection.EAST) ;
		System.out.println("Das sind die ersten Ergbenisse oben : \n" +
		game.getPieceAt(0, 0) + game.getPieceAt(1, 0) + game.getPieceAt(2, 0) + game.getPieceAt(3, 0) +"\n"
		+ game.getPieceAt(0, 1) + game.getPieceAt(1, 1) + game.getPieceAt(2, 1) + game.getPieceAt(3, 1)+"\n"
		+ game.getPieceAt(0, 2) + game.getPieceAt(1, 2) + game.getPieceAt(2, 2) + game.getPieceAt(3, 2)+"\n"
		+ game.getPieceAt(0, 3) + game.getPieceAt(1, 3) + game.getPieceAt(2, 3) + game.getPieceAt(3, 3) ) ;
	}
}
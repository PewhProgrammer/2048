package ttfe;

import java.util.Random;

public class AI implements PlayerInterface {

	int x = 1 ;
	Random r = new Random();
	Random R = new Random(4711);
	Random F = new Random(4711) ;
	Random K = new Random(4711) ;
	Random L = new Random(4711) ;
	static SimulatorInterface game2 ;
	int WIDTH ;
	int HEIGHT ;
	int max ;
	MoveDirection[][] chain = new MoveDirection[10000][10000] ;
	MoveDirection[] chain2 = new MoveDirection[1000] ;
	
	MoveDirection direction ;
	
	private SimulatorInterface initiate (SimulatorInterface game) {
		game = new Simple(WIDTH , HEIGHT , R) ;
		int i = 0 ; 
		if(game.isSpaceLeft())
			game.addPiece();
		while(chain2[i] != null){
		game.performMove(chain2[i]) ;
		i++ ;
		}
		
		return game ;
	}
	
	private int SingleMove (SimulatorInterface game , MoveDirection way  ){
		//game = new Simple(WIDTH , HEIGHT , R) ;
		if(game.isSpaceLeft())
			game.addPiece();
		game.performMove(way) ;
		
		return game.getNumPieces();
	}
	
	private MoveDirection max(int x , int y , int z , int k){
		if (x > y) 
			if (x > z) 
				if (x > k)
					return MoveDirection.SOUTH;
				else
					return MoveDirection.EAST ;
			else if(z > k)
				return MoveDirection.WEST ;
			else 
				return MoveDirection.EAST;
		else if (y > z)
				if (y > k)
					return MoveDirection.NORTH ;
				else 
					return MoveDirection.EAST;
		else if(z > k)
			return MoveDirection.WEST ;
		else 
			return MoveDirection.EAST;
	}
	
	private MoveDirection min (int x , int y , int z , int k){
		if (x < y) 
			if (x < z) 
				if (x < k)
					return MoveDirection.SOUTH;
				else
					return MoveDirection.EAST ;
			else if(z < k)
				return MoveDirection.WEST ;
			else 
				return MoveDirection.EAST;
		else if (y < z)
				if (y < k)
					return MoveDirection.NORTH ;
				else 
					return MoveDirection.EAST;
		else if(z < k)
			return MoveDirection.WEST ;
		else 
			return MoveDirection.EAST;
	}
	
	@Override
	public MoveDirection getPlayerMove(SimulatorInterface game, UserInterface ui) {
		// TODO Auto-generated method stub
		r.setSeed(r.nextInt());
		int p = r.nextInt(3)  ;
		int i = 0 ;
		int j = 0 ;
		this.WIDTH = game.getBoardWidth() ;
		this.HEIGHT = game.getBoardHeight() ;
		this.max = 0 ; 
		int n = 0 ;
		int hilfn = 0 ;
		n=0;
		
//		while ( game.isMovePossible() ){
//			
//			direction = min( SingleMove(initiate(game2),MoveDirection.SOUTH) ,
//					SingleMove(initiate(game2),MoveDirection.NORTH),
//					SingleMove(initiate(game2),MoveDirection.WEST),
//					SingleMove(initiate(game2),MoveDirection.EAST) ) ;
//			
//			game.performMove(direction) ;
//			chain2[i] = direction ; 
//			i++ ;
//			System.out.println("here : " + game.getNumPieces());
//			
//			int z = r.nextInt(100) ;
			
			
			
//			if (game.isMovePossible(MoveDirection.WEST) 
//			|| game.isMovePossible(MoveDirection.SOUTH)
//			|| game.isMovePossible(MoveDirection.NORTH) ){
//			if (z <= 66 ){
//				game.performMove(MoveDirection.WEST);
//			}
//			else if (z <= 88 ){
//				game.performMove(MoveDirection.SOUTH);
//
//			}
//			else if (z <= 99 ){
//				game.performMove(MoveDirection.NORTH);
//
//			}
//			
//			}
//			else game.performMove(MoveDirection.EAST);
			
//			if (game.isSpaceLeft())
//				game.addPiece();
//			ui.updateScreen( game );
//			n++ ; 
//		}
	
//////////////////////////////////
		
			while (10000 > n) {
			R.setSeed(4711);
			//r.setSeed(r.nextInt());
			game2 = new Simple(HEIGHT,WIDTH,R) ;
			i = 0 ; 
			while ( game2.isMovePossible() ){
			if (game2.isSpaceLeft())
				game2.addPiece();
			
			int z = r.nextInt(100) ;
			
			if (game2.isMovePossible(MoveDirection.WEST) 
			|| game2.isMovePossible(MoveDirection.SOUTH)
			|| game2.isMovePossible(MoveDirection.NORTH) ){
			if (z <= 66 ){
				game2.performMove(MoveDirection.WEST);
				chain[n][i] = MoveDirection.WEST ;
			}
			else if (z <= 88 ){
				game2.performMove(MoveDirection.SOUTH);
				chain[n][i] = MoveDirection.SOUTH ;
			}
			else if (z <= 99 ){
				game2.performMove(MoveDirection.NORTH);
				chain[n][i] = MoveDirection.NORTH ;
			}
			
			}
			else {
				game2.performMove(MoveDirection.EAST);
				chain[n][i] = MoveDirection.EAST ;
				i++ ; 
				game2.performMove(MoveDirection.WEST);
				chain[n][i] = MoveDirection.WEST ;
			}
			
			i++ ;
			
			}
			
			System.out.println("points "+max) ; 
			if ( game2.getPoints() > max ){
				max = game2.getPoints() ;
				hilfn = n ; 
			}
			
			n++ ;
			
			}
			
		
			i = 0 ; 
			game.addPiece();
			while(game.isMovePossible()){
				game.performMove(chain[hilfn][i]);
				if (game.isSpaceLeft())
				game.addPiece();
				i++;
				ui.updateScreen( game );
			}
		
		
			
			ui.updateScreen( game );
		
//		if ( r.nextInt(2) > 0) return MoveDirection.WEST ;
//		else return MoveDirection.SOUTH;
		
		while(true){}
	}
}



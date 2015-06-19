package ttfe;

import java.util.Random;

public class AI implements PlayerInterface {

	int x = 1 ;
	Random r = new Random();
	Random R = new Random(4711);
	static SimulatorInterface[] game2 = new SimulatorInterface[10];
	int WIDTH ;
	int HEIGHT ;
	int max ;
	MoveDirection[][] chain = new MoveDirection[10][10000] ;
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
		
//		while(10 > n){
//			game2[n] = new Simple(HEIGHT,WIDTH,R);
//			n++;
//		}
//		n=0;
//		
//		while (10 > n ) {
//		r.setSeed(r.nextInt());
//		i = 0 ;
//		j = 0 ; 
//		while (HEIGHT > i){
//			j = 0 ;
//			while(WIDTH > j){
//				game2[n].setPieceAt(i, j, game.getPieceAt(i,j) );
//				j++;
//			}
//			i++;
//		}
//		
//		System.out.println(n +".Durchgang") ;
//		i = 0 ;
//		while ( game2[n].isMovePossible()) {
//			p = r.nextInt(3)  ;
//			
//		if (game2[n].isMovePossible(MoveDirection.WEST) ||
//			game2[n].isMovePossible(MoveDirection.SOUTH) ||
//			game2[n].isMovePossible(MoveDirection.EAST)) {
//		if (p == 0 ) {
//			chain[n][i] = MoveDirection.WEST ;
//			game2[n].performMove(MoveDirection.WEST); 
//			if(game2[n].isSpaceLeft())
//			game2[n].addPiece();
//		}
//		else if  (p == 1 ) {
//			chain[n][i] = MoveDirection.SOUTH ;
//			game2[n].performMove(MoveDirection.SOUTH); 
//			if(game2[n].isSpaceLeft())
//			game2[n].addPiece();
//		}
//		else if ( p == 2 ) {
//			chain[n][i] = MoveDirection.EAST ;
//			game2[n].performMove(MoveDirection.EAST); 
//			if(game2[n].isSpaceLeft())
//			game2[n].addPiece();
//		}
//			}
//		else {
//			chain[n][i] = MoveDirection.NORTH;
//			game2[n].performMove(MoveDirection.NORTH); 
//			if(game2[n].isSpaceLeft())
//			game2[n].addPiece();
//		}
//		i++;
//		}
//		System.out.println("cmp("+this.max+" , "+game2[n].getPoints()+" )" );
//		if ( game2[n].getPoints() > this.max ) {
//			//System.out.println("points"+game2[n].getPoints()+"max"+this.max);
//			this.max = game2[n].getPoints() ;
//			hilfn = n ; 
//			i = 0 ;
//		}
//		
//		System.out.println(this.max);
//		n++ ;
//		}
		
		
		n = 0 ;  
		while (1 > n){
			game2[n] = new Simple(HEIGHT,WIDTH,R);
			while(game2[n].isMovePossible(MoveDirection.WEST)){
				game2[n].performMove(MoveDirection.WEST);
				if(game2[n].isSpaceLeft())
					game2[n].addPiece();
				chain[n][0] = MoveDirection.WEST;
			}
			n++ ; 
		}
		
		i = 0 ;
		System.out.println(game.isMovePossible()); 
		while ( game.isMovePossible() ){
			//if (chain[hilfn][i] != null )
			game.performMove(chain[0][0]);
			if (game.isSpaceLeft())
			game.addPiece();
			if(game.isMovePossible(chain[0][0]))
				game.performMove(MoveDirection.SOUTH);
			else
				game.performMove(MoveDirection.SOUTH);
			i++;
		}
		ui.updateScreen(game);
		
		return null; 
	}
}

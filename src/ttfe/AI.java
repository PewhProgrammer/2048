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
	MoveDirection[] chain2 = new MoveDirection[10] ;
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
		
		while(10 > n){
			game2[n] = new Simple(HEIGHT,WIDTH,R);
			n++;
		}
		n=0;
		
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
		
		
//		n = 0 ;  
		
//		while (1 > n){
//			game2[n] = new Simple(HEIGHT,WIDTH,R);
//			while(game2[n].isMovePossible(MoveDirection.WEST)){
//				game2[n].performMove(MoveDirection.WEST);
//				if(game2[n].isSpaceLeft())
//					game2[n].addPiece();
//				chain[n][0] = MoveDirection.WEST;
//			}
//			n++ ; 
//		}
		
		i = 0 ;
		System.out.println(true); 
		while ( 400 > i ){
			int max = 0 ;
			int q = R.nextInt(3);
			int n2 = 0 ;
			while (10 > n2 ) {
				r.setSeed(r.nextInt());
				i = 0 ;
				j = 0 ; 
				while (HEIGHT > i){
					j = 0 ;
					while(WIDTH > j){
						game2[n2].setPieceAt(i, j, game.getPieceAt(i,j) );
						j++;
					}
					i++;
				}
				n2++;
			}
			while(10 > n ) {
				if (q == 0){
					game2[n].performMove(MoveDirection.WEST);
					chain2[n] = MoveDirection.WEST ;
				}
				else if (q == 1){
					game2[n].performMove(MoveDirection.SOUTH);
					chain2[n] = MoveDirection.SOUTH ;
				}
				else if (q == 2){
					game2[n].performMove(MoveDirection.EAST);
					chain2[n] = MoveDirection.EAST ;
				}
				else{
					game2[n].performMove(MoveDirection.NORTH);
					chain2[n] = MoveDirection.NORTH ;
				}
				if ( game2[n].getPoints() > max){
					max = game2[n].getPoints();
					hilfn = n ;
				}
				n++ ; 
			}
			
			game.performMove(chain2[hilfn]) ;
			if (game.isSpaceLeft())
			game.addPiece();
			i++;
			ui.updateScreen(game);
		}
		
//		if ( r.nextInt(2) > 0) return MoveDirection.WEST ;
//		else return MoveDirection.SOUTH;
		return null ; 
		
	}
}

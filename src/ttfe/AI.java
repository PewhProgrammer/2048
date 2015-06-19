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
		
			n = 0 ;
			while (2 > n) {
			game2[n] = new Simple(HEIGHT,WIDTH,R) ;
			R.setSeed(4711);
			n++ ;
			}
			
			
//			i = 0 ;
//			while(game2[0].isMovePossible(MoveDirection.WEST ) || game2[0].isSpaceLeft()){
//				
//				game2[0].performMove(MoveDirection.WEST) ;
//				chain2[i] = MoveDirection.WEST ;
//				if (game2[0].isSpaceLeft())
					game2[0].addPiece(); 
//				i++;
//			
//			}
			
			System.out.println("Das sind die ersten Ergbenisse oben : \n" +
					game2[0].getPieceAt(0, 0) + game2[0].getPieceAt(1, 0) + game2[0].getPieceAt(2, 0) + game2[0].getPieceAt(3, 0) +"\n"
					+ game2[0].getPieceAt(0, 1) + game2[0].getPieceAt(1, 1) + game2[0].getPieceAt(2, 1) + game2[0].getPieceAt(3, 1)+"\n"
					+ game2[0].getPieceAt(0, 2) + game2[0].getPieceAt(1, 2) + game2[0].getPieceAt(2, 2) + game2[0].getPieceAt(3, 2)+"\n"
					+ game2[0].getPieceAt(0, 3) + game2[0].getPieceAt(1, 3) + game2[0].getPieceAt(2, 3) + game2[0].getPieceAt(3, 3) ) ;
			
			
			game2[1].addPiece(); 
//			i++;
//		
//		}
		
		System.out.println("Das sind die ersten Ergbenisse oben : \n" +
				game2[1].getPieceAt(0, 0) + game2[1].getPieceAt(1, 0) + game2[1].getPieceAt(2, 0) + game2[1].getPieceAt(3, 0) +"\n"
				+ game2[1].getPieceAt(0, 1) + game2[1].getPieceAt(1, 1) + game2[1].getPieceAt(2, 1) + game2[1].getPieceAt(3, 1)+"\n"
				+ game2[1].getPieceAt(0, 2) + game2[1].getPieceAt(1, 2) + game2[1].getPieceAt(2, 2) + game2[1].getPieceAt(3, 2)+"\n"
				+ game2[1].getPieceAt(0, 3) + game2[1].getPieceAt(1, 3) + game2[1].getPieceAt(2, 3) + game2[1].getPieceAt(3, 3) ) ;
		
			i = 0 ; 
			game.addPiece();
			while(chain[i] != null){
//				game.performMove(chain2[i]);
//				if (game.isSpaceLeft())
//				game.addPiece();
//				i++;
				ui.updateScreen(game);
			}
		
//		if ( r.nextInt(2) > 0) return MoveDirection.WEST ;
//		else return MoveDirection.SOUTH;
		
		while(true){}
	}
}
	


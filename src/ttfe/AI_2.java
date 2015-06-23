package ttfe;

import java.util.Random;

public class AI_2 implements PlayerInterface {
	
	Random r = new Random();
	Random R = new Random(4711);
	
	static SimulatorInterface game2 ;
	int WIDTH ;
	int HEIGHT ;
	int max ;
	int k ;
	
	MoveDirection[][] chain = new MoveDirection[30000][200] ;
	MoveDirection[] chain2 = new MoveDirection[40000] ;
	
	MoveDirection direction ;
	
	private SimulatorInterface initiate (SimulatorInterface game) {
		R.setSeed(4711);
		game = new Simple(WIDTH , HEIGHT , R) ;
		
		int q = 0 ; 
		if (chain2[q] == null) {}
		else {
			while(k > q ){
				if(game.performMove(chain2[q]) == true )
					game.addPiece();
				q++ ;
			}
		}
		
		return game ;
	}

	private int equalInt(int x , int y , int z , int a){
		if (x == y && x == z & x == a)
			return 1 ;
		else return 0 ;
	}
	private int max3(int x , int y , int z){
		if (x > y)
			if (x > z)
				return 1 ;
			else return 3 ;
		
		else if( y > z)
				return 2 ;
			else return 3 ;
	}
	
	
	private int max2 (int x , int y, int z,int x2 ,int y2 , int z2){
		if ( max3(x,y,z) == 1 ) {
			if ( max3(x,x2,y2) == 1)
				if (x > z2)
					return 1 ;
				else return 6 ;
			else if (max3(x,x2,y2) == 2)
				if ( x2 > z2)
					return 4;
				else return 6 ;
			else if (y2 > z2 )
					return 5 ;
				else return 6 ;
		}
		else if ( max3(x,y,z) == 2 ) {
			if ( max3(y,x2,y2) == 1)
				if (y > z2)
					return 2 ;
				else return 6 ;
			else if (max3(y,x2,y2) == 2)
				if ( x2 > z2)
					return 4;
				else return 6 ;
			else if (y2 > z2 )
					return 5 ;
				else return 6 ;
		}
		else {
			if ( max3(z,x2,y2) == 1)
				if (z > z2)
					return 3 ;
				else return 6 ;
			else if ( max3(z,x2,y2) == 2)
				if ( x2 > z2)
					return 4;
				else return 6 ;
			else if (y2 > z2 )
					return 5 ;
				else return 6 ;
		}
	}	
	
	private int max12(int x , int y, int z,int x2 ,int y2 , int z2,
					int x3 ,int y3 ,int z3 ,int x4 ,int y4 ,int z4){
		
		if (equalInt(equalInt(x,y,z,x2),equalInt(y2,z2,x3,y3),
				equalInt(z3,x4,y4,z4),1) == 1 )
			return 0 ; 
		if (max2(x,y,z,x2,y2,z2) == 1) {
			if ( max2(x,x3,y3,z3,x4,y4) == 1)
				if (x > z4 )
					return x ;
				else 
					return z4;
			else if ( max2(x,x3,y3,z3,x4,y4) == 2)
				if (x3 > z4 )
					return x3 ;
				else 
					return z4;
			else if ( max2(x,x3,y3,z3,x4,y4) == 3)
				if (y3 > z4 )
					return y3 ;
				else 
					return z4;
			else if ( max2(x,x3,y3,z3,x4,y4) == 4)
				if (z3 > z4 )
					return z3 ;
				else 
					return z4;
			else if ( max2(x,x3,y3,z3,x4,y4) == 5)
				if (x4 > z4 )
					return x4 ;
				else 
					return z4;
			else if ( max2(x,x3,y3,z3,x4,y4) == 6)
				if (y4 > z4 )
					return y4 ;
				else 
					return z4;
		}
		else if (max2(x,y,z,x2,y2,z2) == 2) {
			if ( max2(y,x3,y3,z3,x4,y4) == 1)
				if (y > z4 )
					return y ;
				else 
					return z4;
			else if ( max2(y,x3,y3,z3,x4,y4) == 2)
				if (x3 > z4 )
					return x3 ;
				else 
					return z4;
			else if ( max2(y,x3,y3,z3,x4,y4) == 3)
				if (y3 > z4 )
					return y3 ;
				else 
					return z4;
			else if ( max2(y,x3,y3,z3,x4,y4) == 4)
				if (z3 > z4 )
					return z3 ;
				else 
					return z4;
			else if ( max2(y,x3,y3,z3,x4,y4) == 5)
				if (x4 > z4 )
					return x4 ;
				else 
					return z4;
			else if ( max2(y,x3,y3,z3,x4,y4) == 6)
				if (y4 > z4 )
					return y4 ;
				else 
					return z4;
		}
		else if (max2(x,y,z,x2,y2,z2) == 3){
			if ( max2(z,x3,y3,z3,x4,y4) == 1)
				if (z > z4 )
					return z ;
				else 
					return z4;
			else if ( max2(z,x3,y3,z3,x4,y4) == 2)
				if (x3 > x3 )
					return x3 ;
				else 
					return z4;
			else if ( max2(z,x3,y3,z3,x4,y4) == 3)
				if (y3 > z4 )
					return y3;
				else 
					return z4;
			else if ( max2(z,x3,y3,z3,x4,y4) == 4)
				if (z3 > z4 )
					return z3 ;
				else 
					return z4;
			else if ( max2(z,x3,y3,z3,x4,y4) == 5)
				if (x4 > z4 )
					return x4 ;
				else 
					return z4;
			else if ( max2(z,x3,y3,z3,x4,y4) == 6)
				if (y4 > z4 )
					return y4 ;
				else 
					return z4;
		}
		else if (max2(x,y,z,x2,y2,z2) == 4) {
			if ( max2(x2,x3,y3,z3,x4,y4) == 1)
				if (x2 > z4 )
					return x2 ;
				else 
					return z4;
			else if ( max2(x2,x3,y3,z3,x4,y4) == 2)
				if (x3 > z4 )
					return x3 ;
				else 
					return z4;
			else if ( max2(x2,x3,y3,z3,x4,y4) == 3)
				if (y3 > z4 )
					return y3 ;
				else 
					return z4;
			else if ( max2(x2,x3,y3,z3,x4,y4) == 4)
				if (z3 > z4 )
					return z3 ;
				else 
					return z4;
			else if ( max2(x2,x3,y3,z3,x4,y4) == 5)
				if (x4 > z4 )
					return x4 ;
				else 
					return z4;
			else if ( max2(x2,x3,y3,z3,x4,y4) == 6)
				if (y4 > z4 )
					return y4 ;
				else 
					return z4;
		}
		else if (max2(x,y,z,x2,y2,z2) == 5){
			if ( max2(y2,x3,y3,z3,x4,y4) == 1)
				if (y2 > z4 )
					return y2 ;
				else 
					return z4;
			else if ( max2(y2,x3,y3,z3,x4,y4) == 2)
				if (x3 > z4 )
					return x3 ;
				else 
					return z4;
			else if ( max2(y2,x3,y3,z3,x4,y4) == 3)
				if (y3 > z4 )
					return y3 ;
				else 
					return z4;
			else if ( max2(y2,x3,y3,z3,x4,y4) == 4)
				if (z3 > z4 )
					return z3 ;
				else 
					return z4;
			else if ( max2(y2,x3,y3,z3,x4,y4) == 5)
				if (x4 > z4 )
					return x4 ;
				else 
					return z4;
			else if ( max2(y2,x3,y3,z3,x4,y4) == 6)
				if (y4 > z4 )
					return y4 ;
				else 
					return z4;
		}
		else if (max2(x,y,z,x2,y2,z2) == 6){
			if ( max2(z2,x3,y3,z3,x4,y4) == 1)
				if (z2 > z4 )
					return z2 ;
				else 
					return z4;
			else if ( max2(z2,x3,y3,z3,x4,y4) == 2)
				if (x3 > z4 )
					return x3 ;
				else 
					return z4;
			else if ( max2(z2,x3,y3,z3,x4,y4) == 3)
				if (y3 > z4 )
					return y3 ;
				else 
					return z4;
			else if ( max2(z2,x3,y3,z3,x4,y4) == 4)
				if (z3 > z4 )
					return z3 ;
				else 
					return z4;
			else if ( max2(z2,x3,y3,z3,x4,y4) == 5)
				if (x4 > z4 )
					return x4 ;
				else 
					return z4;
			else if ( max2(z2,x3,y3,z3,x4,y4) == 6)
				if (y4 > z4 )
					return y4 ;
				else 
					return z4;
		}
		
	return 0 ; 

	}
	
	private int max3true(int a ,int b , int c){
		if (a > b)
			if (a > c)
				return a ;
			else return c ;
		else if (b > c)
				return b;
		else return c;
	}
	
	private int max6x12(int a , int b , int c , int a2 , int b2 , int c2 ,
						int a3, int b3 , int c3 , int a4 , int b4 , int c4 ,
						int a5 , int b5 , int c5 , int a6 , int b6 , int c6 ,
						int x , int y , int z , int x2 , int y2 ,int z2 ,
						int x3 , int y3 , int z3 , int x4 , int y4 , int z4 ,
						int x5 , int y5 , int z5 , int x6 , int y6 , int z6,
						int x7 , int y7 , int z7 , int x8 , int y8 , int z8,
						int a7 ,int b7,int c7 ,int a8 ,int b8 , int c8,
						int a9 ,int b9 ,int c9 , int a10 , int b10 , int c10,
						int aa , int bb , int cc , int aa1 , int bb1 , int cc1,
						int aa2 ,int bb2 , int cc2 , int aa3 , int bb3 , int cc3,
						int aa4 , int bb4 , int cc4 , int aa5 , int bb5 , int cc5,
						int aa6 ,int bb6 , int cc6 , int aa7 , int bb7 , int cc7,
						int aa8 , int bb8 , int cc8 , int aa9 , int bb9 , int cc9,
						int xx , int yy , int zz , int xx1 , int yy1 , int zz1 ,
						int xx2 , int yy2 , int zz2 , int xx3 , int yy3 , int zz3
						) {
		
		int k = max12(a,a2,a3,a4,b,b2,b3,b4,c,c2,c3,c4);
		int p = max12(a5,b5,c5,a6,b6,c6,x,y,z,x2,y2,z2);
		int q = max12(x3,y3,z3,x4,y4,z4,x5,y5,z5,x6,y6,z6);
		int f = max12(x7 , y7 , z7 ,x8 , y8 , z8,a7,b7,c7,a8,b8,c8);
		int k1 =max12(a9,b9,c9,a10,b10,c10,aa,bb,cc,aa1,bb1,cc1);
		int p2 =max12(aa2,bb2,cc2,aa3,bb3,cc3,aa4,bb4,cc4,aa5,bb5,cc5);
		int k2 = max12(aa6,bb6,cc6,aa7,bb7,cc7,aa8,bb8,cc8,aa9,bb9,cc9);
		int p1 = max12(xx,yy,zz,xx1,yy1,zz1,xx2,yy2,zz2,xx3,yy3,zz3);
		
		if ( equalInt(k,p,q,f) == 1)
			return 0 ; 
		
		int max1 = max3true(k,p,q) ;
		int max2 = max3true(max1,k1,p2) ;
		int max = max3true(max2,k2,p1);
		
		if (max == a) 		return 1 ;
		else if (max == b) 	return 2 ;
		else if (max == c) 	return 3 ;
		else if (max == a2) return 4 ;
		else if (max == b2) return 5 ;
		else if (max == c2) return 6 ;
		else if (max == a3) return 7 ;
		else if (max == b3) return 8 ;
		else if (max == c3) return 9 ;
		else if (max == a4) return 10 ;
		else if (max == b4) return 11 ;
		else if (max == c4) return 12 ;
		else if (max == a5) return 13 ;
		else if (max == b5) return 14 ;
		else if (max == c5) return 15 ;
		else if (max == a6) return 16 ;
		else if (max == b6) return 17 ;
		else if (max == c6) return 18 ;
		
		else if (max == x) 	return 19 ;
		else if (max == y)	return 20 ;
		else if (max == z) 	return 21 ;
		else if (max == x2) return 22 ;
		else if (max == y2) return 23 ;
		else if (max == z2) return 24 ;
		else if (max == x3) return 25 ;
		else if (max == y3) return 26 ;
		else if (max == z3) return 27 ;
		else if (max == x4) return 28 ;
		else if (max == y4) return 29 ;
		else if (max == z4) return 30 ;
		else if (max == x5) return 31 ;
		else if (max == y5) return 32 ;
		else if (max == z5) return 33 ;
		else if (max == x6) return 34 ;
		else if (max == y6) return 35 ;
		else if (max == z6) return 36 ;
		
		else if (max == x7)	return 37 ;
		else if (max == y7) return 38 ;
		else if (max == z7) return 39 ;
		else if (max == x8) return 40 ;
		else if (max == y8) return 41 ;
		else if (max == z8) return 42 ;
		else if (max == a7) return 43 ;
		else if (max == b7) return 44 ;
		else if (max == c7) return 45 ;
		else if (max == a8) return 46 ;
		else if (max == b8) return 47 ;
		else if (max == c8) return 48 ;
		
		else if (max == a9)	 return 49 ;
		else if (max == b9)	 return 50 ;
		else if (max == c9)	 return 51 ;
		else if (max == a10) return 52 ;
		else if (max == b10) return 53 ;
		else if (max == c10) return 54 ;
		else if (max == aa)	 return 55 ;
		else if (max == bb)	 return 56 ;
		else if (max == cc)	 return 57 ;
		else if (max == aa1) return 58 ;
		else if (max == bb1) return 59 ;
		else if (max == cc1) return 60 ;
		else if (max == aa2) return 61 ;
		else if (max == bb2) return 62 ;
		else if (max == cc2) return 63 ;
		else if (max == aa3) return 64 ;
		else if (max == bb3) return 65 ;
		else if (max == cc3) return 66 ;
		else if (max == aa4) return 67 ;
		else if (max == bb4) return 68 ;
		else if (max == cc4) return 69 ;
		else if (max == aa5) return 70 ;
		else if (max == bb5) return 71 ;
		else if (max == cc5) return 72 ;
		
		else if (max == aa6) return 73 ;
		else if (max == bb6) return 74 ;
		else if (max == cc6) return 75 ;
		else if (max == aa7) return 76 ;
		else if (max == bb7) return 77 ;
		else if (max == cc7) return 78 ;
		else if (max == aa8) return 79 ;
		else if (max == bb8) return 80 ;
		else if (max == cc8) return 81 ;
		else if (max == aa9) return 82 ;
		else if (max == bb9) return 83 ;
		else if (max == cc9) return 84 ;
		else if (max == xx)  return 85 ;
		else if (max == yy)  return 86 ;
		else if (max == zz)  return 87 ;
		else if (max == xx1) return 88 ;
		else if (max == yy1) return 89 ;
		else if (max == zz1) return 90 ;
		else if (max == xx2) return 91 ;
		else if (max == yy2) return 92 ;
		else if (max == zz2) return 93 ;
		else if (max == xx3) return 94 ;
		else if (max == yy3) return 95 ;
		else if (max == zz3) return 96 ;
		
		
		
		
		return 0 ; 
		
			
	}
	
	
	private int MultipleMove (SimulatorInterface game ,int f,int k ){
		//game = new Simple(WIDTH , HEIGHT , R) ;
		int n = 0 ;
		//int f = 25 ;
		
		//System.out.println("here : " + max2(1,2,3,4,5,6));

//		System.out.println("Das sind die Initial Ergebnisse : \n" +
//				game.getPieceAt(0, 0) + game.getPieceAt(1, 0) + game.getPieceAt(2, 0) + game.getPieceAt(3, 0) +"\n"
//				+ game.getPieceAt(0, 1) + game.getPieceAt(1, 1) + game.getPieceAt(2, 1) + game.getPieceAt(3, 1)+"\n"
//				+ game.getPieceAt(0, 2) + game.getPieceAt(1, 2) + game.getPieceAt(2, 2) + game.getPieceAt(3, 2)+"\n"
//				+ game.getPieceAt(0, 3) + game.getPieceAt(1, 3) + game.getPieceAt(2, 3) + game.getPieceAt(3, 3) ) ;
		
		while ( f > n ) {
		//r.setSeed(r.nextInt(10000));
		int z = r.nextInt(3) ;
		
		if (game.isMovePossible(MoveDirection.WEST) 
				|| game.isMovePossible(MoveDirection.SOUTH)
				|| game.isMovePossible(MoveDirection.NORTH) ){
				if (z == 1 ){
					if(game.performMove(MoveDirection.WEST) ==true)
						game.addPiece();
					chain[k][n] = MoveDirection.WEST ;
				}
				if (z == 2 ){
					if(game.performMove(MoveDirection.SOUTH) == true)
						game.addPiece();
					chain[k][n] = MoveDirection.SOUTH ;
				}
				if (z == 0 ){
					if(game.performMove(MoveDirection.NORTH)==true)
						game.addPiece();
					chain[k][n] = MoveDirection.NORTH ;

				}
				
				}
				else { 
					if(game.performMove(MoveDirection.EAST)==true)
						game.addPiece();
					chain[k][n] = MoveDirection.EAST ;
					if(game.performMove(MoveDirection.WEST)==true)
						game.addPiece();
					chain[k][n] = MoveDirection.WEST ;
					f = f-1 ;
				}
		n++ ;
		
		}
		
//		System.out.println("Das sind die ersten Ergbenisse oben : \n" +
//				game.getPieceAt(0, 0) + game.getPieceAt(1, 0) + game.getPieceAt(2, 0) + game.getPieceAt(3, 0) +"\n"
//				+ game.getPieceAt(0, 1) + game.getPieceAt(1, 1) + game.getPieceAt(2, 1) + game.getPieceAt(3, 1)+"\n"
//				+ game.getPieceAt(0, 2) + game.getPieceAt(1, 2) + game.getPieceAt(2, 2) + game.getPieceAt(3, 2)+"\n"
//				+ game.getPieceAt(0, 3) + game.getPieceAt(1, 3) + game.getPieceAt(2, 3) + game.getPieceAt(3, 3) ) ;
		
		if (game.isMovePossible() == false)
			return 0 ; 
		return game.getPoints();
	}
	
	
	public MoveDirection getPlayerMove(SimulatorInterface game ,UserInterface ui){
		r.setSeed(r.nextInt());
		int i = 0 ;
		this.WIDTH = game.getBoardWidth() ;
		this.HEIGHT = game.getBoardHeight() ;
		this.max = 0 ; 
		int n = 0 ;
		int j = 0 ; 
		int schleife = 15 ;
		int p = 35 ;
		
		chain[0][0] = MoveDirection.EAST ;
		//chain[0][1] = MoveDirection.WEST ;
		
		
		
		while (game.isMovePossible() ){
			
			int x = max6x12(  
				MultipleMove(initiate(game2),p,1 ) ,
				MultipleMove(initiate(game2),p,2 ) ,
				MultipleMove(initiate(game2),p,3) ,
				MultipleMove(initiate(game2),p,4) ,
				MultipleMove(initiate(game2),p,5) ,
				MultipleMove(initiate(game2),p,6) ,
				MultipleMove(initiate(game2),p,7 ) ,
				MultipleMove(initiate(game2),p,8 ) ,
				MultipleMove(initiate(game2),p,9) ,
				MultipleMove(initiate(game2),p,10) ,
				MultipleMove(initiate(game2),p,11) ,
				MultipleMove(initiate(game2),p,12) ,
				MultipleMove(initiate(game2),p,13),
				MultipleMove(initiate(game2),p,14),
				MultipleMove(initiate(game2),p,15),
				MultipleMove(initiate(game2),p,16),
				MultipleMove(initiate(game2),p,17),
				MultipleMove(initiate(game2),p,18),
				MultipleMove(initiate(game2),p,19),
				MultipleMove(initiate(game2),p,20),
				MultipleMove(initiate(game2),p,21),
				MultipleMove(initiate(game2),p,22),
				MultipleMove(initiate(game2),p,23),
				MultipleMove(initiate(game2),p,24),
				MultipleMove(initiate(game2),p,25),
				MultipleMove(initiate(game2),p,26),
				MultipleMove(initiate(game2),p,27),
				MultipleMove(initiate(game2),p,28),
				MultipleMove(initiate(game2),p,29),
				MultipleMove(initiate(game2),p,30),
				MultipleMove(initiate(game2),p,31),
				MultipleMove(initiate(game2),p,32),
				MultipleMove(initiate(game2),p,33),
				MultipleMove(initiate(game2),p,34),
				MultipleMove(initiate(game2),p,35),
				MultipleMove(initiate(game2),p,36),
				MultipleMove(initiate(game2),p,37),
				MultipleMove(initiate(game2),p,38),
				MultipleMove(initiate(game2),p,39),
				MultipleMove(initiate(game2),p,40),
				MultipleMove(initiate(game2),p,41),
				MultipleMove(initiate(game2),p,42),
				MultipleMove(initiate(game2),p,43),
				MultipleMove(initiate(game2),p,44),
				MultipleMove(initiate(game2),p,45),
				MultipleMove(initiate(game2),p,46),
				MultipleMove(initiate(game2),p,47),
				MultipleMove(initiate(game2),p,48),
				MultipleMove(initiate(game2),p,49),
				MultipleMove(initiate(game2),p,50),
				MultipleMove(initiate(game2),p,51),
				MultipleMove(initiate(game2),p,52),
				MultipleMove(initiate(game2),p,53),
				MultipleMove(initiate(game2),p,54),
				MultipleMove(initiate(game2),p,55),
				MultipleMove(initiate(game2),p,56),
				MultipleMove(initiate(game2),p,57),
				MultipleMove(initiate(game2),p,58),
				MultipleMove(initiate(game2),p,59),
				MultipleMove(initiate(game2),p,60),
				MultipleMove(initiate(game2),p,61),
				MultipleMove(initiate(game2),p,62),
				MultipleMove(initiate(game2),p,63),
				MultipleMove(initiate(game2),p,64),
				MultipleMove(initiate(game2),p,65),
				MultipleMove(initiate(game2),p,66),
				MultipleMove(initiate(game2),p,67),
				MultipleMove(initiate(game2),p,68),
				MultipleMove(initiate(game2),p,69),
				MultipleMove(initiate(game2),p,70),
				MultipleMove(initiate(game2),p,71),
				MultipleMove(initiate(game2),p,72),
				MultipleMove(initiate(game2),p,73),
				MultipleMove(initiate(game2),p,74),
				MultipleMove(initiate(game2),p,75),
				MultipleMove(initiate(game2),p,76),
				MultipleMove(initiate(game2),p,77),
				MultipleMove(initiate(game2),p,78),
				MultipleMove(initiate(game2),p,79),
				MultipleMove(initiate(game2),p,80),
				MultipleMove(initiate(game2),p,81),
				MultipleMove(initiate(game2),p,82),
				MultipleMove(initiate(game2),p,83),
				MultipleMove(initiate(game2),p,84),
				MultipleMove(initiate(game2),p,85),
				MultipleMove(initiate(game2),p,86),
				MultipleMove(initiate(game2),p,87),
				MultipleMove(initiate(game2),p,88),
				MultipleMove(initiate(game2),p,89),
				MultipleMove(initiate(game2),p,90),
				MultipleMove(initiate(game2),p,91),
				MultipleMove(initiate(game2),p,92),
				MultipleMove(initiate(game2),p,93),
				MultipleMove(initiate(game2),p,94),
				MultipleMove(initiate(game2),p,95),
				MultipleMove(initiate(game2),p,96)
				) ; 
		
			if ( x == 0 ) {
				p = p -1 ;
				schleife = 0 ;
				}
			else { 
				schleife = 15 ; 
				p = 35 ; 
			}
			
			n = 0 ; 
			i = 0 ; 
			if(game.isMovePossible(MoveDirection.NORTH) == false &&
					game.isMovePossible(MoveDirection.SOUTH) == false &&
					game.isMovePossible(MoveDirection.WEST) == false) {
				if( game.performMove(MoveDirection.EAST) == true) 
					game.addPiece(); 
				chain2[k] = MoveDirection.EAST ;
				k++ ;
			}
			while (schleife > n){
				if ( game.performMove(chain[x][i]) == true) 
					game.addPiece();
				chain2[k] = chain[x][i] ;
//				System.out.println("Das sind die ersten Ergbenisse oben : \n" +
//						game.getPieceAt(0, 0) + game.getPieceAt(1, 0) + game.getPieceAt(2, 0) + game.getPieceAt(3, 0) +"\n"
//						+ game.getPieceAt(0, 1) + game.getPieceAt(1, 1) + game.getPieceAt(2, 1) + game.getPieceAt(3, 1)+"\n"
//						+ game.getPieceAt(0, 2) + game.getPieceAt(1, 2) + game.getPieceAt(2, 2) + game.getPieceAt(3, 2)+"\n"
//						+ game.getPieceAt(0, 3) + game.getPieceAt(1, 3) + game.getPieceAt(2, 3) + game.getPieceAt(3, 3) ) ;
				i++ ;
				k++ ; 
				n++ ; 
				//ui.updateScreen(game);
			}
		j++;
		}
		ui.updateScreen(game);
		return null ; 
	}
}

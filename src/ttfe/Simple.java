package ttfe;

import java.util.Random;
import ttfe.SimulatorInterface;

public class Simple implements SimulatorInterface {
	int points = 0 ;
	int moves = 0 ; 
	int width = 0 ;
	int height = 0 ;
	Random r ;
	int n = 0 ; 
	// TODO: Implement me.
	int[][] array = new int[width][height] ;
	
	public Simple(int width, int height,Random r) {
		// TODO Auto-generated constructor stub
			this.width = width ;
			this.height = height ; 
			this.r = r ;
	}
	
	
	public void addPiece() {
			array[1][1] = 2 ; 
		}
		public int getBoardHeight() {
			return this.width ;
		}
		public int getBoardWidth() {
			return this.height ;
		}
		public int getNumMoves() {
			return moves ;
	}
		public int getNumPieces(){
			int i = 0 ;
			int j = 0 ;
			int pieces = 0 ;
			while (width > i) {
				j = 0 ;
				while (height > j ){
				if ( array[i][j] != 0 )
					pieces++ ;
				j++;
				}
			
				i++ ;
			}
			
			return pieces ;
		}
		
		public int getPieceAt(int x,int y) {
			return array[x][y]; 
		}
		
		public int getPoints(){
			
			return points ;
		}
		
		public void setPieceAt(int x , int y,int z){
			array[x][y] = z ;
		}
		
		public boolean isMovePossible(){
			return true
		;}
		
		public boolean isMovePossible(MoveDirection direction){
			return true;
		}
		
		public boolean isSpaceLeft(){
			return true;
			}
		
		
		public boolean performMove(MoveDirection direction){return true;}
		
		public void run(PlayerInterface player, UserInterface ui){}
		
	}

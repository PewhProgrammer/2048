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
	int[][] array ;
	
	public Simple(int width, int height,Random r) {
		// TODO Auto-generated constructor stub
			this.width = width ;
			this.height = height ; 
			this.r = r ;
		    array = new int[width][height] ;
	}
	
	
	public void addPiece() {
			this.array[1][1] = 2 ; 
		}
		public int getBoardHeight() {
			return this.width ;
		}
		public int getBoardWidth() {
			return this.height ;
		}
		public int getNumMoves() {
			return this.moves ;
	}
		public int getNumPieces(){
			int i = 0 ;
			int j = 0 ;
			int pieces = 0 ;
			while (this.width > i) {
				j = 0 ;
				while (this.height > j ){
				if ( this.array[i][j] != 0 )
					pieces++ ;
				j++;
				}
			
				i++ ;
			}
			
			return pieces ;
		}
		
		public int getPieceAt(int x,int y) {
			return this.array[1][1]; 
		}
		
		public int getPoints(){
			
			return this.points ;
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

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
			this.array = new int[width][height] ;
			this.r = r ;
			int n = 0 ;
			while (2 > n) {
				if (this.r.nextInt(10) > 1 ){
					this.array[r.nextInt(this.width-1)][r.nextInt(this.height-1)] = 2 ;
				}
				else
					this.array[r.nextInt(this.width-1)][r.nextInt(this.height-1)] = 4 ;
				n++ ;
			}
	}
	
	
	public void addPiece() {
		this.array[r.nextInt(this.width-1)][r.nextInt(this.height-1)] = 2 ;
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
			return this.array[x][y]; 
		}
		
		public int getPoints(){
			return this.points ;
		}
		
		public void setPieceAt(int x , int y,int z){
			array[x][y] = z ;
		}
		
		public boolean isMovePossible(){
			int i = 0 ;
			int j = 0 ;
			int counttile  = 0 ;
			while (this.width > i) {
				j = 0 ;
				while (this.height > j ){
				if ( this.array[i][j] != 0) counttile =1 ;
				if ( this.array[i][j] == 0 )
					if (counttile == 1)return true ;
				j++;
				}
			
				i++ ;
			}
			
			j = 0 ;
			i = 0 ;
			while (this.width > i){
				j = 0 ;
				while (this.height > j){
					if (array[i][j] != 0 ){
					if (i == 0 && j == 0){
						if (array[i][j] == array[i][j+1] || array[i][j] == array[i+1][j] )
							return true ;
					}
					else if (i == 0){
						if (array[i][j] == array[i][j+1] || array[i][j] == array[i+1][j] || 
						array[i][j] == array[i][j-1])
							return true ;
					}
					else if (j == 0) {
						if (array[i][j] == array[i][j+1] || array[i][j] == array[i+1][j] ) 
									return true ;
					}
					else {
						if (array[i][j] == array[i][j+1] || array[i][j] == array[i+1][j]  )
									return true ;
					}
					}
					
					j++ ;	
				}
				i++ ; 
			}
			
			return false ;
		}
		
		public boolean isMovePossible(MoveDirection direction){
			return true;
		}
		
		public boolean isSpaceLeft(){
			return true;
			}
		
		
		public boolean performMove(MoveDirection direction){return true;}
		
		public void run(PlayerInterface player, UserInterface ui){}
		
	}

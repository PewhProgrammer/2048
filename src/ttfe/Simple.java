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
			this.array = new int[this.width][this.height] ;
			this.r = r ;
			int n = 0 ;
			int m = 2 ;
			while (m > n) {
				int p = r.nextInt(this.width) ;
				int q = r.nextInt(this.height) ;
				if (array[p][q] == 0) {
				if (this.r.nextInt(10) > 1 ){
					this.array[r.nextInt(this.width)][r.nextInt(this.height)] = 2 ;
				}
				else
					this.array[r.nextInt(this.width)][r.nextInt(this.height)] = 4 ;
				}
				else m++ ;
				n++ ;
			}
	}
	
	
	public void addPiece() {
		int p = 0 ;
		int q = 0 ;
		while ( true ){
			p = r.nextInt(this.width) ;
			q = r.nextInt(this.height) ;
			if (this.array[p][q] == 0 ){
				if (this.r.nextInt(10) >= 1 ){
					this.array[p][q] = 2 ;
					break;
				}
				else {
					this.array[p][q] = 4 ;
					break; 
				}
			}
		}
	
	}
		public int getBoardHeight() {
			return this.height ;
		}
		public int getBoardWidth() {
			return this.width ;
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
			//System.out.println("hallo"+x+y) ; 
			return this.array[x][y]; 
		}
		
		public int getPoints(){
			return this.points ;
		}
		
		public void setPieceAt(int x , int y,int z){
			this.array[x][y] = z ;
		}
		
		public boolean isMovePossible(){
			int i = 0 ;
			int j = 0 ;
			int counttile  = 0 ;
			int counttilezero = 0;
			while (this.width > i) {
				j = 0 ;
				while (this.height > j ){
					if ( this.array[i][j] != 0) counttile =1 ;
					if ( this.array[i][j] == 0 ) counttilezero = 1 ;
					
					if (counttile == 1 && counttilezero == 1) return true ;
					j++;
				}
			
				i++ ;
			}
			
			j = 0 ;
			i = 0 ;
			while (this.width > i){
				j = 0 ;
				while (this.height > j){
					if (this.array[i][j] != 0 ){
						if ( i == this.height-1 && j == this.width -1); 
						else if (i == this.height-1){
							if (this.array[i][j] == this.array[i][j+1] )
								if (this.array[i][j] != 131072)
								return true ;
						} 
						else if (j == width-1 ){
							if ( this.array[i][j] == this.array[i+1][j] ) 
								if (this.array[i][j] != 131072)
								return true ;
						}
						else {
							if (this.array[i][j] == this.array[i][j+1] || this.array[i][j] == this.array[i+1][j] ){
									if (this.array[i][j] != 131072)
									return true ;
							}
						} 
					}
					j++ ;	
				}
				i++ ; 
			}  
			
			return false ;
		}
		
		public boolean isMovePossible(MoveDirection direction){
			int i = 0 ;
			int j = 0;
			int[][] copyarray = new int[this.width][this.height] ;
			while (this.height > i){
				j = 0 ;
				while(this.width > j ){
					copyarray[i][j] = array[i][j] ; 
					j++;
				}
				i++ ; 
			}
			
			i = 0 ;
			j = 0 ; 
			
			if ( direction == MoveDirection.NORTH){
				j = 1 ;
				while (this.width > i){
					j = 1 ;
					while(this.height > j){
						if (array[i][j] != 0) {
						if (array[i][j-1] == 0 ||
								array[i][j-1] == array[i][j]) return true ;
						}
						j++;
					}
					i++;
				}
			}
			else if ( direction == MoveDirection.SOUTH){
				while (this.width > i){
					j = 0 ;
					while(this.height-1 > j){
						if (array[i][j] != 0) {
						if (array[i][j+1] == 0 || 
								array[i][j+1] == array[i][j]) return true ;
						}
						j++;
					}
					i++;
				}
			}
			else if ( direction == MoveDirection.WEST){
				i = 1 ;
				while (this.width > i){
					j = 0 ;
					while(this.height > j){
						if (array[i][j] != 0) {
						if (array[i-1][j] == 0 ||
								array[i-1][j] == array[i][j]) return true ;
						}
						j++;
					}
					i++;
				}
			}
			else if ( direction == MoveDirection.EAST){
				while (this.width-1 > i){
					j = 0 ;
					while(this.height > j){
						if (array[i][j] != 0) {
						if (array[i+1][j] == 0 ||
								array[i+1][j] == array[i][j]) return true ; 
						}
						j++;
					}
					i++;
				}
			}
				
			return false;
		}
		
		public boolean isSpaceLeft(){
			
			int i = 0 ;
			int j = 0 ;
			while (this.width > i) {
				j = 0 ;
				while (this.height > j ){
					if (this.array[i][j] == 0)
						return true ;
				j++;
				}
			
				i++ ;
			}
			return false ; 
			}
		
		
		public boolean performMove(MoveDirection direction){
			int i = 0 ;
			int j = 0 ;
			//HEIGHT = 4 ;
			//WIDTH = 5 ; 
			int[][] copyarray = new int[this.width][this.height] ;
			while (this.width > i){
				j = 0 ;
				while(this.height > j ){
					copyarray[i][j] = array[i][j] ; 
					j++;
				}
				i++ ; 
			}
			
			i = 0 ;
			j = 0 ;
		
			
			if (direction == MoveDirection.NORTH) {
				while (this.width > i ){
					j = 1 ;
					while (this.height > j) {
						if (array[i][j-1] == array[i][j]) {   //mergeable 2 tiles
							array[i][j-1] += array[i][j] ;		//überschreiben
							this.points = array[i][j-1]+this.points ; 		//score
							array[i][j-1] = array[i][j-1] * (-1) ;
							array[i][j] = 0 ;					//reset auf 0
						}
						else if(array[i][j-1] == 0){
							int hilfj = j ;
							while (hilfj > 0){
								if (array[i][hilfj-1] == 0 ){
								array[i][hilfj-1] = array[i][hilfj] ;
								array[i][hilfj] = 0 ;
								}
								else if (array[i][hilfj-1] == array[i][hilfj]){
									array[i][hilfj-1] += array[i][hilfj] ;		//überschreiben
									this.points = array[i][hilfj-1] +this.points ; 		//score
									array[i][hilfj] = 0 ;					//reset auf 0
									array[i][j-1] = array[i][j-1] * (-1) ;
									break;
								}
									
								else break ;
								hilfj-- ;
							}
						}
						j++ ;
					}
					i++;
				}
			}
			
			else if (direction == MoveDirection.SOUTH) {
				i = 0 ;
				j = 0 ;
				while (this.width > i ){
					j = this.height - 2 ;
					while (j >= 0) {
						if (array[i][j] == 0) ;			// Muss nich zero tiles überprüfen
						else {
						if (array[i][j+1] == array[i][j]) {   //mergeable 2 tiles
							array[i][j+1] += array[i][j] ;		//überschreiben
							this.points = array[i][j+1] +this.points ; 		//score
							array[i][j] = 0 ;					//reset auf 0
							array[i][j+1] = array[i][j+1] * (-1) ;
						}
						else if(array[i][j+1] == 0){
							int hilfj = j ;
							while (this.height-2 >= hilfj){
								if (array[i][hilfj+1] == 0 ){
								array[i][hilfj+1] = array[i][hilfj] ;
								array[i][hilfj] = 0 ;
								}
								else if (array[i][hilfj+1] == array[i][hilfj]){
									array[i][hilfj+1] += array[i][hilfj] ;		//überschreiben
									this.points = array[i][hilfj+1] + this.points ; 		//score
									array[i][hilfj] = 0 ;						//reset auf 0 
									array[i][hilfj+1] = array[i][hilfj+1] * (-1) ;
									break;
								}
									
								else break ;
								hilfj++ ;
							}
						}
						}
						j-- ;
					}
					i++;
				}
			}
			
			else if (direction == MoveDirection.WEST) {
				i = 1 ;
				while (this.width > i ){
					j = 0 ;
					while (this.height > j) {
						if (array[i-1][j] == array[i][j]) {   //mergeable 2 tiles
							array[i-1][j] += array[i][j] ;		//überschreiben
							this.points = array[i-1][j]+this.points ; 		//score
							array[i][j] = 0 ;					//reset auf 0
							array[i-1][j] = array[i-1][j] *(-1) ;
						}
						else if(array[i-1][j] == 0){
							int hilfi = i ;
							while (hilfi > 0){
								if (array[hilfi-1][j] == 0 ){
								array[hilfi-1][j] = array[hilfi][j] ;
								array[hilfi][j] = 0 ;
								}
								else if (array[hilfi-1][j] == array[hilfi][j]){
									array[hilfi-1][j] += array[hilfi][j] ;		//überschreiben
									this.points = array[hilfi-1][j]+this.points ; 		//score
									array[hilfi][j] = 0 ;						//reset auf 0
									array[hilfi-1][j] = array[hilfi-1][j] *(-1) ; 
									break;
								}
									
								else break ;
								hilfi-- ;
							}
						}
						j++ ;
					}
					i++;
				}
			}
			
			else if (direction == MoveDirection.EAST) {
				i = this.width - 2 ;
				while (i >= 0 ){
					j = 0 ;
					while (this.height > j) {
						if (array[i+1][j] == array[i][j]) {   				//mergeable 2 tiles
							array[i+1][j] += array[i][j] ;					//überschreiben
							this.points = array[i+1][j]+this.points ; 		//score
							array[i][j] = 0 ;								//reset auf 0
							array[i+1][j] = array[i+1][j] *(-1) ; 
						}
						else if(array[i+1][j] == 0){
							int hilfi = i ;
							while ((this.width-2) >= hilfi){
								if (array[hilfi+1][j] == 0 ){
								array[hilfi+1][j] = array[hilfi][j] ;
								array[hilfi][j] = 0 ;
								}
								else if (array[hilfi+1][j] == array[hilfi][j]){
									array[hilfi+1][j] += array[hilfi][j] ;		//überschreiben
									this.points = array[hilfi+1][j]+this.points ; 		//score
									array[hilfi][j] = 0 ;						//reset auf 0
									array[hilfi+1][j] = array[hilfi+1][j] *(-1) ; 
									break;
								}
									
								else break ;
								hilfi++ ;
							}
						}
						j++ ;
					}
					i--;
				}
			}
			
			i = 0 ;
			j = 0;
			
			while(this.width > i){
				j = 0 ;
				while(this.height > j ){
					if (this.array[i][j] < 0) this.array[i][j] = this.array[i][j]  *(-1) ; 
					j++ ;
				}
				i++;
			}
			
			i=0;
			j=0;
			while (this.width > i){

				j = 0 ; 
				while (this.height > j){
		 
					if (this.array[i][j] != copyarray[i][j]) {
						this.moves++ ; 
						return true ; 
					}
					j++ ;
				}
				i++ ;
			}
				
			return false;
			}
		
		
		
		public void run(PlayerInterface player, UserInterface ui){
		
			while(this.isMovePossible()) {
				this.performMove( ( player.getPlayerMove(this,ui)) ) ;
				ui.updateScreen(this);
				if(this.isSpaceLeft())
				this.addPiece() ; 
				ui.updateScreen(this);
			
			}
			ui.showGameOverScreen(this) ;
			
		}
	}

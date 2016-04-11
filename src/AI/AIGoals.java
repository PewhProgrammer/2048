package AI;

import ttfe.Simple;

public class AIGoals {
	
	private boolean mFlagCorner = false ;
	public int max1 = 0;
	
	public void update(Simple game){
		int[][] board = game.getArray() ;
		int max = 0 ;
		Position pos = new Position(0,0);
		for(int i = 0; i < game.getBoardHeight();i++){
			for(int j = 0;j < game.getBoardWidth();j++){
				if(board[i][j] > max){
					max = board[i][j] ;
					this.max1 = max ; 
					pos = new Position(i,j);
				}
			}
		}
		
		if(pos.getX() == 0 || pos.getX() == game.getBoardWidth()){
			if(pos.getY() == 0 || pos.getY() == game.getBoardHeight())
				this.mFlagCorner = true ; return ;
		}
		this.mFlagCorner =false ;
	}
	
	public boolean isCornered(){
		return this.mFlagCorner ;
	}
	private class Position{
		private final int i;
		private final int j;
		
		public Position(int i, int j){
			this.i = i ; this.j = j ;
		}
		public int getX(){
			return this.i ;
		}
		public int getY(){
			return this.j ;
		}
		
	}
}

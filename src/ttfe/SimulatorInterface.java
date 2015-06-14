package ttfe;

public interface SimulatorInterface {

		public class Simple implements SimulatorInterface {
			int points = 0 ;
			int moves = 0 ; 
			int width = 0 ;
			int height = 0 ;
			// TODO: Implement me.
			int[][] array = new int[4][4] ;
 			public Simple(int width, int height) {
				// TODO Auto-generated constructor stub
 				this.width = width ;
 				this.height = height ; 
			}
			public void addPiece() {
 				array[1][1] = 2 ; 
 			}
 			public int getBoardHeight() {
 				return width ;
 			}
 			public int getBoardWidth() {
 				return height ;
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
	
	/**
	 * Put a new piece to an empty (and random) position on the board.
	 *
	 * With a probability of 0.9 the new piece will be a 2, otherwise a 4.
	 * In your tests, you do not need to verify the probability distribution.
	 */
	public void addPiece();

	/**
	 * @return Return the height of the board.
	 */
	public int getBoardHeight() ;
	/**
	 * @return Return the width of the board.
	 */
	public int getBoardWidth();
	/**
	 * @return Return the number of moves made so far.
	 */
	public int getNumMoves();

	/**
	 * @return Return the number of pieces currently on the board.
	 */
	public int getNumPieces();

	/**
	 * Return the piece at the given position.
	 *
	 * @param x
	 *            The x coordinate of the field.
	 * @param y
	 *            The y coordinate of the field.
	 *
	 * @return The current value of the piece at the given position.
	 */
	public int getPieceAt(int x, int y);

	/**
	 * @return Return the number of points scored so far.
	 */
	public int getPoints();

	/**
	 * Test if a move in any direction is possible.
	 *
	 * @return Return true, if there is at least one possible move left that
	 *         will move at least one piece (or merge two).
	 */
	
	public boolean isMovePossible();

	/**
	 * Test if a move in the given direction is possible.
	 *
	 * @return Return true, if we can move at least one piece (or merge two) in
	 *         the given direction.
	 */
	public boolean isMovePossible(MoveDirection direction);

	/**
	 * @return Return true, if there is at least one tile left where we could
	 *         place a new piece.
	 */
	public boolean isSpaceLeft();

	/**
	 * Perform a move in the given direction.
	 *
	 * @param direction
	 *            The direction of the move that should be performed.
	 *
	 * @return True, if and only if a move was performed.
	 */
	public boolean performMove(MoveDirection direction);

	/**
	 * Game entry point that will execute the game logic.
	 *
	 * @param player
	 *            The player that will choose the directions of the moves.
	 * @param ui
	 *            The interface that will display the current state of the game.
	 */
	public void run(PlayerInterface player, UserInterface ui);

	/**
	 * Place (or remove) the given piece at the given position.
	 *
	 * @param x
	 *            The x coordinate of the field.
	 * @param y
	 *            The y coordinate of the field.
	 * @param piece
	 *            The piece to place or 0 if the piece should be removed.
	 */
	public void setPieceAt(int x, int y, int piece);
}

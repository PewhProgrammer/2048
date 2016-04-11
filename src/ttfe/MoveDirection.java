package ttfe;

/**
 * An enum type that represents the four different directions
 * the blocks can be moved.
 *
 */
public enum MoveDirection {
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);
	
	private final int value;
	
	MoveDirection(final int newValue){
		value = newValue ;
	}
	
	public int getValue(){return value ;}
}

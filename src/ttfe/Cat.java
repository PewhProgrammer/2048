package ttfe;

import ttfe.PlayerInterface;

public class Cat implements PlayerInterface {
	
	String direction ;
	

	@Override
	public MoveDirection getPlayerMove(SimulatorInterface game, UserInterface ui) {
		// TODO Auto-generated method stub
		
		String question = "Direction ? " ;
		String[] possibleAnswers = new String[4]; 
		
		possibleAnswers[0] = "r";
		possibleAnswers[1] = "l";
		possibleAnswers[2] = "u";
		possibleAnswers[3] = "d";
		
		direction = "hallo" ; 
		while(direction.length() != 1 &&
			  direction.charAt(0) != 'r' &&
			  direction.charAt(0) != 'l' &&
			  direction.charAt(0) != 'u' &&
			  direction.charAt(0) != 'd')
		direction = ui.getUserInput(question, possibleAnswers) ;
		
		
		//return ui.getUserMove();
		
		
		if (direction.charAt(0) == 'r' ) return MoveDirection.EAST ;
		else if (direction.charAt(0) == 'l') return MoveDirection.WEST ;
		else if (direction.charAt(0) == 'u') return MoveDirection.NORTH ;
		else if (direction.charAt(0) == 'd') return MoveDirection.SOUTH ;
		
		return null;
	}

}

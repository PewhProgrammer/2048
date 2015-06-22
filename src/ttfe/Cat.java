package ttfe;

import ttfe.PlayerInterface;

public class Cat implements PlayerInterface {
	
	String direction ;
	

	@Override
	public MoveDirection getPlayerMove(SimulatorInterface game, UserInterface ui) {
		// TODO Auto-generated method stub
		return ui.getUserMove() ;
	}

}

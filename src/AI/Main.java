package AI;

import ttfe.MoveDirection;
import ttfe.PlayerInterface;
import ttfe.SimulatorInterface;
import ttfe.UserInterface;

public class Main implements PlayerInterface{
	
	private FutureTree ai ;
	private AIGoals goals ;
	public Main(){
		this.ai = new FutureTree(4,0.6) ;
		this.goals = new AIGoals();
	}

	@Override
	public MoveDirection getPlayerMove(SimulatorInterface game, UserInterface ui) {
		return ai.determineNextAction(game,ui,goals);
	}
	
}

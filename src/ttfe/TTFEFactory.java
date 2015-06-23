package ttfe;

import java.util.Random;

import ttfe.PlayerInterface;
import ttfe.SimulatorInterface;
import ttfe.UserInterface;
import ttfe.Simple;


public class TTFEFactory {
	
	/**
	 * Create a 2048 simulator.
	 * 
	 * @param width
	 *            The width of the simulated board, must be greater or equal than 2.
	 * @param height
	 *            The height of the simulated board, must be greater or equal than 2.
	 * @param r
	 *            The random object used to create random numbers.
	 * 
	 * @return A 2048 simulator.
	 */
	
	//troll
	public static SimulatorInterface createSimulator(int width, int height,
			Random r) {
		SimulatorInterface game = new Simple(width,height,r) ;
		return game ; 
	}

	/**
	 * Create a user interface for a 2048 simulator.
	 * 
	 * @param game
	 *            The 2048 simulator.
	 * @param gui
	 *            Flag to indicate the graphical user interface should be used.
	 * 
	 * @return A user interface for a 2048 simulator that is console based if
	 *         gui is false and otherwise GUI based.
	 */
	public static UserInterface createUserInterface(SimulatorInterface game,
			boolean gui) {
		// TODO: Implement me.
		
		UserInterface ui ;
		if (gui == false) {
			ui = new Dog(game,gui) ;
		}
		else 
			ui = new GUI(game) ;
		
		
		return ui;
	}

	/**
	 * Create a 2048 player.
	 * 
	 * @param human
	 *            Flag to indicate a human player will play the game.
	 * 
	 * @return A 2048 player that will play automatically if human is false and
	 *         otherwise use the user interface to communicate with the human
	 *         player to select moves.
	 */
	public static PlayerInterface createPlayer(boolean human) {
		// TODO: Implement me.
		PlayerInterface player ;
		if (human == true) 
			player = new Cat() ;
		else
			player = new AI_2() ;
		
		return player ;
	}

}

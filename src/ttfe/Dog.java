package ttfe;

import ttfe.PlayerInterface;
import ttfe.MoveDirection; 

import java.util.Scanner;
import java.io.* ;

public class Dog implements UserInterface{

	
	private Scanner in;
	String usermove ;

	public Dog(SimulatorInterface game , boolean gui){
		if ( gui == false ) ;
		
	}
	@Override
	public String getUserInput(String question, String[] possibleAnswers) {
		// TODO Auto-generated method stub
		possibleAnswers = new String[4] ;
		possibleAnswers[1] = "r" ;
		possibleAnswers[2] = "l";
		possibleAnswers[3] = "u";
		possibleAnswers[4] = "d";
		int i = 0 ; 
		
		
		in = new Scanner(System.in);
		String input = in.nextLine() ;
		while (4 > i) {
		if (input == possibleAnswers[i]){
			usermove = possibleAnswers[i] ;
			}
			i++ ;
		}
		return input;
	}

	@Override
	public MoveDirection getUserMove() {
		// TODO Auto-generated method stub
		if (usermove == "right") return MoveDirection.EAST;
		if (usermove == "left") return MoveDirection.WEST;
		if (usermove == "up")	return MoveDirection.NORTH;
		if (usermove == "down")	return MoveDirection.SOUTH;
		return null ; 
	}

	@Override
	public void showGameOverScreen(SimulatorInterface game) {
		// TODO Auto-generated method stub
		if (game.isMovePossible() == false ) System.out.println("Game Over") ;
	}

	@Override
	public void showMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg) ; 
		
	}

	@Override
	public void updateScreen(SimulatorInterface game) {
		// TODO Auto-generated method stub
		//game.run() ; 
	}


}

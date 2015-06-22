package ttfe;

import ttfe.MoveDirection; 

import java.util.Scanner;

public class Dog implements UserInterface{

	
	private Scanner Answer = new Scanner(System.in);
	String usermove ;
	MoveDirection UserMoveChoice ;

	public Dog(SimulatorInterface game , boolean gui){
		
	}
	
	
	@Override
	public String getUserInput(String question, String[] possibleAnswers) {
		// TODO Auto-generated method stub	
		int i = 0 ;
			
			while (true) {
				String input = "Test";
				System.out.print(question) ; 
				//Answer = new Scanner(System.in);
				//if (Answer.hasNext() )
				input = Answer.nextLine();
				
				if (input.length() == 1){
					i = 0;
					while (possibleAnswers[i] != null) {
						if ( possibleAnswers[i].charAt(0) == input.charAt(0) )
							return input ; 
						i++ ;
					}
				}
			}
	}



	@Override
	public MoveDirection getUserMove() {
		// TODO Auto-generated method stub
		//KeyListener Key = new SynchronizedKeyListener(this) ;
		String question = "Direction ? " ;
		String[] possibleAnswers = new String[4]; 
		
		possibleAnswers[0] = "r";
		possibleAnswers[1] = "l";
		possibleAnswers[2] = "u";
		possibleAnswers[3] = "d";
		String direction = "Hallo";
		
		direction = this.getUserInput (question,possibleAnswers) ;
		
		if (direction.charAt(0) == 'r' ) return MoveDirection.EAST ;
		else if (direction.charAt(0) == 'l') return MoveDirection.WEST ;
		else if (direction.charAt(0) == 'u') return MoveDirection.NORTH ;
		else if (direction.charAt(0) == 'd') return MoveDirection.SOUTH ;
		
		return null ; 
	}
	

	@Override
	public void showGameOverScreen(SimulatorInterface game) {
		// TODO Auto-generated method stub
		//System.out.println("=================================================") ;
		//System.out.println("=-                                             -=") ;
		System.out.println("=-                 GAME OVER                   -=") ;
		System.out.println("=-       Moves: "+game.getNumMoves()+"            Points: "+game.getPoints()+"         -=") ;
		//System.out.println("=-                                             -=") ;
		//System.out.println("=================================================") ;
	}

	@Override
	public void showMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg) ; 
		
	}

	@Override
	public void updateScreen(SimulatorInterface game) {
		// TODO Auto-generated method stub
		int WIDTH = game.getBoardWidth() ;
		int HEIGHT = game.getBoardHeight() ;
		
		System.out.print("              Moves: "+game.getNumMoves()+"   Points: "+game.getPoints() ) ;
		System.out.print("\n") ;
		int i = 0 ;
		int j = 0 ;
		while (HEIGHT > i){
			j = 0 ;
			while(WIDTH > j){
				System.out.print("|-------------");
				j++ ;
			}
			System.out.print("|\n") ;
			j = 0 ;
			while(WIDTH > j){
				if (game.getPieceAt(j, i) == 0 ) 
					System.out.print("|             ");
				else if (game.getPieceAt(j,i) > 1000)
					System.out.print("|    "+game.getPieceAt(j, i)+"     ");
				else if(game.getPieceAt(j, i) > 100 )
					System.out.print("|    "+game.getPieceAt(j, i)+"      ");
				else if (game.getPieceAt(j,i) > 10 )
					System.out.print("|     "+game.getPieceAt(j, i)+"      ");
				else
					System.out.print("|     "+game.getPieceAt(j, i)+"       ");
				j++ ;
			}
			System.out.print("|\n") ;
			i++ ;
		}
		j = 0 ;
		while(WIDTH > j){
			System.out.print("|-------------");
			j++ ;
		}
		
		System.out.print("|\n") ;
		
	}


}

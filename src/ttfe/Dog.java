package ttfe;

import ttfe.MoveDirection; 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ttfe.GUI;

import java.util.Scanner;

public class Dog implements UserInterface{

	
	private Scanner Answer;
	String usermove ;
	MoveDirection UserMoveChoice ;

	public Dog(SimulatorInterface game , boolean gui){
		
	}
	
	private final class SynchronizedKeyListener implements KeyListener {
		private final Dog G;

		public SynchronizedKeyListener(Dog G) {
			this.G = G;
		}

		@Override
		public void keyTyped(KeyEvent e) {
			/* Do nothing */
		}

		@Override
		public void keyReleased(KeyEvent e) {
			/* Do nothing */
		}

		@Override
		public void keyPressed(KeyEvent e) {
			synchronized (G) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					UserMoveChoice = MoveDirection.WEST;
					break;
				case KeyEvent.VK_RIGHT:
					UserMoveChoice = MoveDirection.EAST;
					break;
				case KeyEvent.VK_UP:
					UserMoveChoice = MoveDirection.NORTH;
					break;
				case KeyEvent.VK_DOWN:
					UserMoveChoice = MoveDirection.SOUTH;
					break;
				default:
					return;
				}
				G.notify();
			}
		}
	}
	@Override
	public String getUserInput(String question, String[] possibleAnswers) {
		// TODO Auto-generated method stub		
		
			System.out.print(question) ; 
			Answer = new Scanner(System.in);
			String input = Answer.next() ;
			
			return input ; 
			}

		
//	}

	@Override
	public MoveDirection getUserMove() {
		// TODO Auto-generated method stub
		//KeyListener Key = new SynchronizedKeyListener(this) ;
		while(true) {
		String question = "Direction ? " ;
		String[] possibleAnswers = new String[4]; 
		
		possibleAnswers[0] = "r";
		possibleAnswers[1] = "l";
		possibleAnswers[2] = "u";
		possibleAnswers[3] = "d";
		String direction = "Hallo";
		
		while(direction.length() != 1 ) 
		direction = this.getUserInput (question,possibleAnswers) ;
		
		if (direction.charAt(0) == 'r' ) return MoveDirection.EAST ;
		else if (direction.charAt(0) == 'l') return MoveDirection.WEST ;
		else if (direction.charAt(0) == 'u') return MoveDirection.NORTH ;
		else if (direction.charAt(0) == 'd') return MoveDirection.SOUTH ;
		}
	}
	

	@Override
	public void showGameOverScreen(SimulatorInterface game) {
		// TODO Auto-generated method stub
		System.out.println("=================================================") ;
		System.out.println("=-                                             -=") ;
		System.out.println("=-                 GAME OVER                   -=") ;
		System.out.println("=-       Moves: "+game.getNumMoves()+"            Points: "+game.getPoints()+"         -=") ;
		System.out.println("=-                                             -=") ;
		System.out.println("=================================================") ;
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

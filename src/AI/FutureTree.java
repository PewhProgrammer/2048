package AI;

import ttfe.MoveDirection;
import ttfe.Simple;
import ttfe.SimulatorInterface;
import ttfe.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class FutureTree {

	private final int MAX_DEPTH ;
	private final double DEPTH_DAMPENING;
	private int simulations = 0 ;
	private final ArrayList<MoveDirection> directions = new ArrayList<MoveDirection>();
	private List<MoveDirection> mMovedDirections ;
	
	public FutureTree(int maxDepth,double dampFac){
		this.DEPTH_DAMPENING=dampFac ;
		this.MAX_DEPTH =maxDepth ;
		
		this.mMovedDirections = new ArrayList<>() ;
		
		directions.add(MoveDirection.NORTH);
		directions.add(MoveDirection.WEST);
		directions.add(MoveDirection.SOUTH);
		directions.add(MoveDirection.EAST);
		
	}
	public MoveDirection determineNextAction(SimulatorInterface game ,UserInterface gui
			,AIGoals goals){
		simulations = 0;
		
		
		DepthSearchResult result = determineScore((Simple)game,0,goals);
		if(mMovedDirections.size() == 0){
			simulations++ ;
		}
		
		//System.out.println("Action determined with: "+simulations+ " simulations "
		//		+ " Action: " + result.mDirection.toString() + " Score : " + 
		//		result.mScore) ;
		this.mMovedDirections.add(result.mDirection); // how to get SEED
		System.out.println("Max: " + goals.max1);
		return result.mDirection ;
	}
	
	public DepthSearchResult determineScore(Simple game,int depth,AIGoals goals){
		
		if(depth >= this.MAX_DEPTH){
			return new DepthSearchResult(0,null);
		}
		
		if(!game.isMovePossible()){
			return new DepthSearchResult(-game.getPoints(),null);
		}
		
		
		DepthSearchResult bestBranchResult =  new DepthSearchResult(-1,null);
		
		for(int i = 0 ; i <= 3 ; i++){
			simulations++ ;
			Simple simulation = ((Simple)game).clone() ;
			
			for(MoveDirection dir : this.mMovedDirections){
				simulation.performMove(dir);
				if(simulation.isSpaceLeft())
					simulation.addPiece() ; 
			}
			
			MoveDirection dir = (MoveDirection)this.directions.get(i);
			
			if(!simulation.performMove(dir))
					continue;
			if(simulation.isSpaceLeft())
				simulation.addPiece() ; 
			
			goals.update(game);
			depth++ ;
			double Score = simulation.getPoints() ;
			if(goals.isCornered())
				Score = Score * 2;
		
			Score += determineScore(simulation,depth,goals).mScore * DEPTH_DAMPENING ;
		
			if(Score > bestBranchResult.mScore){
				bestBranchResult = new DepthSearchResult(Score,dir);
				
			}
		
		}
	
		return bestBranchResult ;
		
		
	}
	
	private class DepthSearchResult{
		public final double mScore;
		public final MoveDirection mDirection;
		
		private DepthSearchResult(double score , MoveDirection dir)
		{	
			this.mScore = score ; this.mDirection = dir ;
		}
	}
}

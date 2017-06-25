package Chess74;

public class Pawn extends Piece {

	public Pawn(String name, int color) {
		super(name,color);
	}

	public boolean legalmove(String move, Piece[][] gameBoard, int currentTeam) 
	{
		String alpha = "abcdefgh";
		
		int startRank = alpha.indexOf(move.charAt(0));
		int startFile = 8-Character.getNumericValue(move.charAt(1));
		int endRank = alpha.indexOf(move.charAt(3));
		int endFile = 8-Character.getNumericValue(move.charAt(4));
		
		if(gameBoard[endRank][endFile].color==currentTeam){
			return false;
		}else if(){//en passant line goes here, tricky
			
		}else if(startRank!=endRank){
			return false;
		}else if(){
			
		}
		return false;
	}

}
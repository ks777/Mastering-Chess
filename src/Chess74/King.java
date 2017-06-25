package chess;

public class King extends Piece {

	public King(String name, int color) {
		super(name,color);
		// TODO Auto-generated constructor stub
	}

	public boolean legalmove(String move, Piece[][] gameBoard, int currentTeam) {
		// TODO Auto-generated method stub
		String alpha = "abcdefgh";
		
		int startRank = alpha.indexOf(move.charAt(0));
		int startFile = 8-Character.getNumericValue(move.charAt(1));
		int endRank = alpha.indexOf(move.charAt(3));
		int endFile = 8-Character.getNumericValue(move.charAt(4));
		
		if(gameBoard[endRank][endFile].color==currentTeam){
			return false;
		}else if(Math.abs(endRank-startRank)>1||Math.abs(endFile-startFile)>1){
			return false;
		}
		return true;
	}

}

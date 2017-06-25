package chess;

public class Knight extends Piece {


	public Knight(String name, int color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}

	public boolean legalmove(String move, Piece[][] gameBoard, int currentTeam) {
		String alpha = "abcdefgh";
		
		int startRank = alpha.indexOf(move.charAt(0));
		int startFile = 8-Character.getNumericValue(move.charAt(1));
		int endRank = alpha.indexOf(move.charAt(3));
		int endFile = 8-Character.getNumericValue(move.charAt(4));
		
		if(gameBoard[startRank][startFile]==null){
			return false;  //false if there is no piece at the selected start point
		}else if(gameBoard[endRank][endFile]!=null && gameBoard[endRank][endFile].color==gameBoard[startRank][startFile].color){
			return false;  //false if there is a piece of the same color at the spot to move to
		}else if(startRank==endRank||startFile==endFile){
			return false;
		}else if(Math.abs(startRank-endRank)+Math.abs(startFile-endFile)!=3){
			return false;
		}
		
		return true;
	}

}
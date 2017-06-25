package chess;

public class Queen extends Piece {

	public Queen(String name,int color) {
		super(name,color);
		// TODO Auto-generated constructor stub
	}

	public boolean legalmove(String move, Piece[][] gameBoard, int currentTeam) {
		
		String alpha = "abcdefgh";
		
		int startRank = alpha.indexOf(move.charAt(0));
		int startFile = 8-Character.getNumericValue(move.charAt(1));
		int endRank = alpha.indexOf(move.charAt(3));
		int endFile = 8-Character.getNumericValue(move.charAt(4));
		
		if(gameBoard[endRank][endFile].color==currentTeam){
			return false;
		}
		if(startRank==endRank||startFile==endFile){  //if the queen moves in a straight line, the rules are the same as a rook
			Rook b = new Rook("",gameBoard[startRank][startFile].color);
			boolean Rookrule = b.legalmove(move, gameBoard, currentTeam);
			return Rookrule;
		}else{										//On the other hand if she doesn't she has to move like a bishop
			Bishop b = new Bishop("",gameBoard[startRank][startFile].color);
			boolean bishopRule = b.legalmove(move, gameBoard, currentTeam);
			return bishopRule;
		}
	}

}
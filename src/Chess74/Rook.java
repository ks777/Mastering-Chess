package Chess74;

public class Rook extends Piece {

	

	public Rook(String name,int color) {
		super(name,color);
		// TODO Auto-generated constructor stub
	}

	public boolean legalmove(String move, Piece[][] gameBoard,
									int currentTeam) {
		// TODO Auto-generated method stub
		//quick check on same rank/same file
		String alpha = "abcdefgh";
		
		int startRank = alpha.indexOf(move.charAt(0));
		int startFile = 8-Character.getNumericValue(move.charAt(1));
		int endRank = alpha.indexOf(move.charAt(3));
		int endFile = 8-Character.getNumericValue(move.charAt(4));
		
		if(gameBoard[endRank][endFile].color==currentTeam){
			return false;
		}
		
		if(startRank==endRank){
			//For loop checks for a piece in the way of the move,
			//if statement for whether it's moving up or down.
			if(startFile>endFile){
				for(int x=startFile;x>endFile;x--){
					if(gameBoard[startRank][x]!=null){
						return false;
					}
				}
			}else{
				for(int x=startFile;x<endFile;x++){
					if(gameBoard[startRank][x]!=null){
						return false;
					}
				}
			}
			return true;
		}else if(startFile==endFile){
			if(startRank>endRank){
				for(int x=startRank;x>endRank;x--){
					if(gameBoard[x][startFile]!=null){
						return false;
					}
				}
			}else{
				for(int x=startRank;x<endRank;x++){
					if(gameBoard[x][startFile]!=null){
						return false;
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}

}
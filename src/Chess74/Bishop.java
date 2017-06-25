package Chess74;

public class Bishop extends Piece {

	public Bishop(String name, int color) {
		super(name, color);
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
		}
		if(Math.abs(endRank-startRank)!=Math.abs(endFile-startFile)){
			return false;
		}
		if(startRank>endRank&&startFile>endFile){
			for(int x=startRank,y=startFile;x<endRank;x--,y--){
				if(gameBoard[x][y]!=null){
					return false;
				}
			}
		}else if(startRank>endRank&&startFile<endFile){
			for(int x=startRank,y=startFile;x<endRank;x--,y++){
				if(gameBoard[x][y]!=null){
					return false;
				}
			}
		}else if(startRank<endRank&&startFile>endFile){
			for(int x=startRank,y=startFile;x<endRank;x++,y--){
				if(gameBoard[x][y]!=null){
					return false;
				}
			}
		}else{
			for(int x=startRank,y=startFile;x<endRank;x++,y++){
				if(gameBoard[x][y]!=null){
					return false;
				}
			}
		}
		
		
		return true;
	}

}
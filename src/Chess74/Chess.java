package chess;

import java.io.*;

public class Chess {
	
	static boolean checkmate,stalemate,resign,check,legal;
	static int draw;
	static String currentTeam;

	private static void openingSetup(Piece[][] gameBoard, 
			String[][] displayBoard) {
		
		//long array, but easiest to make the pieces this way
		//Pieces[0] is black pieces, pieces[1] is white
		
		Piece[][] pieces = {{new Rook("bR",0),new Knight("bN",0),new Bishop("bB",0),new Queen("bQ",0),new King("bK",0),new Bishop("bB",0),new Knight("bN",0),new Rook("bR",0)},
							 {new Rook("wR",1),new Knight("wN",1),new Bishop("wB",1),new Queen("wQ",1),new King("wK",1),new Bishop("wB",1),new Knight("wN",1),new Rook("wR",1)}};
		
		for(int x=0; x<8;x++){
			gameBoard[0][x]=pieces[0][x];
			gameBoard[1][x]=new Pawn("bP",0);
			gameBoard[6][x]=new Pawn("wP",1);
			gameBoard[7][x]=pieces[1][x];
		}
		
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				if(gameBoard[x][y]!=null){
					displayBoard[x][y]=gameBoard[x][y].toString();
					
				}else if((x+y)%2==1){
					displayBoard[x][y]="## ";
				}else{
					displayBoard[x][y]="   ";
				}
			}
		}
		
		String[] chars = {" a "," b "," c "," d "," e "," f "," g "," h "};
		for(int x=0;x<8;x++){
			Integer a = new Integer(8-x);
			displayBoard[x][8]=a.toString();
			displayBoard[8][x]=chars[x];
		}
		displayBoard[8][8]="";
		
	}
	
	static void move(String move, Piece[][] gameBoard){
		
		//check for resigns, returns immediately
		if(move.compareTo("resign")==0){
			System.out.println("resign");
			resign=true;
			return;
		}
		
		//checks whether one player has asked for a draw.  If they have, draw gets incremented.
		//likewise, if one player asked for a draw (draw==1) and the other didn't take it, draw gets decremented again back to 0
		if(move.substring(move.length()-5).compareTo("draw?")==0){
			draw++;
		}else if(draw==1&& !move.equals("draw")){
			draw--;
		}
		
	}
	
	static void check(Piece[][] gameBoard){
		
	}

	
	public static void main(String[] args) throws IOException {
		resign = false;
		checkmate = false;
		stalemate = false;
		check = false;
		draw = 0;
		String[] Teams = {"Black","White"};
		int currentTeam=1;
		legal=false;
		int rank,file;
		String ranks="abcdefgh";
		String input=null;
		
		Piece[][] gameBoard = new Piece[8][8];
		
		String[][] displayBoard = new String[9][9];
		
		//opening board setup
		openingSetup(gameBoard, displayBoard);
		
		//opening board display
		for(int x=0;x<displayBoard.length;x++){
			for(int y=0;y<displayBoard[0].length;y++){
				System.out.print(displayBoard[x][y]);
			}
			System.out.println("");
		}
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(System.in));
		
		//loop terminates on any of the 4 ending conditions
		while(checkmate==false||stalemate==false||resign==false||draw<2){
			 
			//legal begins as false, as long as input is illegal it will remain
			while(legal==false){
				input = in.readLine();
				
				//checks if both players have drawn, if so gets out of the loop
				if(draw==1 && input.equals("draw")){
					draw++;
					break;
				}
				
				//rank and file are pulled out of the input string
				rank=ranks.indexOf(input.charAt(0));
				file=Character.getNumericValue(input.charAt(1));
				
				//calls the piece's legal method
				legal=gameBoard[rank][file].legalmove(input,gameBoard, gameBoard[rank][file].color);
				
				if(legal==false){
					System.out.println("Illegal move, try again");
				}
			}
			//draw==2 means both players agreed to the draw
			if(draw==2){
				break;
			}
			
			//resets legal to false
			legal=false;
			//getting this far means the move is legal, so move() changes the game and displayboards
			//and check determines whether check(mate)/stalemate conditions are met
			move(input,gameBoard);
			check(gameBoard);
			
			if(checkmate==true){
				System.out.print(Teams[currentTeam]+"wins");
			}
			
			if(currentTeam==1){
				currentTeam=0;
			}else{
				currentTeam=1;
			}
		}
		
		if(stalemate==true){
			System.out.println("Stalemate");
		}else if(checkmate==true){
			System.out.println("Checkmate");
		}
		
		
		

	}

}
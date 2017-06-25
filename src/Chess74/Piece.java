package Chess74;
/* Abstract piece, which will contain the methods that navigate a piece on the board correctly. */

public abstract class Piece 
{
	private String name;
	protected int color;
	
	public Piece(String name, int color) /* only position required, yet attempting to place significance in user input color. */
	{
		this.name=name;
		this.color=color;
	}
	
	public String toString()
	{
		return name +" ";
	}
	
	
	public abstract boolean legalmove(String move, Piece[][] gameBoard, int currentTeam);
}

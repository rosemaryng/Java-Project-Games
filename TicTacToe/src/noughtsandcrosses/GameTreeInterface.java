package noughtsandcrosses;

public interface GameTreeInterface {
	
	//post: Returns the board at the root of the game tree. 
	public Board getRootItem();

	//post: Expands the game tree fully by adding all possible boards in the game.
	//      It uses a recursive auxiliary method.
	public void expand();
	
	//pre:  The game tree is fully expanded.
	//post: Assigns a score to each board in the game tree. 
	//      It uses a recursive auxiliary method.
	public void assignScores();
	
	//pre:  Each board in the game tree has a score.
	//post: Computes an array of positions (1..9) optimal available moves. 
	//      These are the last mark positions in the children boards that have the highest score. 
	public int[] BestMoves();

	//post: Returns the number of boards stored in a game tree.
	//	    It uses a recursive auxiliary method.
	public int size();
		
}
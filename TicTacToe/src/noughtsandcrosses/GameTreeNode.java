package noughtsandcrosses;

public class GameTreeNode{
	private GameTreeItem item;                    // includes the board object and the score
	private GenericList<GameTreeNode> children;   //list of gameTreeNodes of possible next moves.
		
	public GameTreeNode(Board newBoard) {
		this.item = new GameTreeItem(newBoard);
		this.children = new GenericList<GameTreeNode>();
	}
	
	
	//post: Returns the board stored in a GameTreeNode
	public Board getBoard() {
		return item.board;
	}
	
	
	//post: Returns the children stored in a GameTreeNode, as a list of GameTreeNodes
	public GenericList<GameTreeNode> getChildren(){
		return children;
	}
	
	
	//post: Returns the score of the board
	public int getScore() {
		return item.score;
	}
	
	
	//post: Sets the score of the board to be equal to the given score 
	public void setScore(int score) {
		item.score = score;
	}
	
	
	//post: Removes all the children
	public void removeChildren(){
		children = null;
	}
	
	
	//post: Returns the number of children
	public int numberOfChildren(){
		return children.size();
	}
	
	
	//post: Returns the child at a given position in the list of children, as a GameTreeNode 
	public GameTreeNode getChild(int i){
		return children.get(i);
	}

//Inner class for storing a board and the score	
private class GameTreeItem{ 	
	
	private Board board;
	private int score;
	
	public GameTreeItem(Board newBoard) {
		this.board = newBoard;
		score = 0;
	}
}//end of inner class GameTreeItem	
	
}

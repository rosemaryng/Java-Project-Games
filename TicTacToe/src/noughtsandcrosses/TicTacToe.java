package noughtsandcrosses;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe{

	public static void main(String[] args) {
		
		char userMark; 			//this can be either 'X' or 'O'
		char computerMark;		//this can be either 'X' or 'O'

		Scanner user = new Scanner(System.in);

		// This is the welcome message part at the beginning of the game
		
		System.out.println("Welcome to Tic-Tac-Toe Game!");
		System.out.println("****************************");
		System.out.println("Do you want to play as ("+String.valueOf(Board.CROSS)+") and go first? [yes]: ");

		//Setting the userMark and the computerMark:
		//on yes answer the userMark is made equal to 'X', otherwise the userMark is made equal to '0'
		if (user.nextLine().trim().equals("yes")) userMark = Board.CROSS;
		else userMark = Board.NOUGHT;
		
		if (userMark == Board.CROSS) computerMark = Board.NOUGHT;
		else computerMark = Board.CROSS;

		Board board = new Board();

		// main game
		while (!board.isFinished()) {
			
			System.out.println("The current board is: ");
			Board.display(board);
			
			//takes in input the user's move
			if (board.getTurn() == userMark) {
				System.out.print("Please enter an empty position in [1..9] for your next placement of ("
								+ String.valueOf(userMark) + "):");
				try {
					//int pos = user.nextInt();
					String line = user.nextLine();
					int pos = Integer.parseInt(line);				
					board.setMark(pos, userMark);
				} catch (Exception ex) {
					System.out.println("Exception : " + ex.getMessage());
				}
			
			//the computer chooses and makes the next move
			} else {
				System.out.println("The computer is starting to play");
				int pos = computerOptimalMove(board);
				board.setMark(pos, computerMark);
				System.out.println("The computer has made a move!");
			}
		}

		// printing the final messages		
		Board.display(board);
		System.out.print("Game finished: ");
		char winner = board.getWinnerMark();
		if (winner == Board.EMPTY) {
			System.out.println("Draw!");
		} else if (winner == userMark) {
			System.out.println("You Won!");
		} else {
			System.out.println("You Lost!");
		}

	}

	/*
	/* An auxiliary method for the computer to compute an optimal move.
	/* It constructs a game tree, assigns scores to each board in the game tree, 
	/* it collects an array of positions (1..9) of optimal available moves,
	/* and selects randomly one position out of this array.
	*/
	private static int computerOptimalMove(Board board){
		
		Random optimalMoveSelector = new Random(1234567);
		
		// constructs the game tree
		GameTree gameTree = new GameTree(board);
		gameTree.expand();
		System.out.println("The expanded game tree has " + gameTree.size() + " possible moves");
		gameTree.assignScores();
		int[] moves = gameTree.BestMoves();
		return moves[optimalMoveSelector.nextInt(moves.length)];
	}
}

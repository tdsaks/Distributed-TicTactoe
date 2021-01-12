import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class GameBoard implements Serializable{
	private static final long serialVersionUID = 1L;
	private int[] board = {0,0,0,0,0,0,0,0,0};
	
	public GameBoard() {}
	
	public int[] getBoard() {
		return this.board;
	}
	
	public void printBoard() {
		System.out.println();
		System.out.println("TIC TAC TOE");
		System.out.println("***********");

		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("***********");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("***********");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
	}
	
	public boolean boardFull() {
		for(int i = 0; i < board.length; i++) {
			if(board[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void update(int pos, int x) {
		board[pos] = x;
	}
	
	public void printSlots() {
		List<Integer> slots = new ArrayList<Integer>();
		for(int i = 0; i < board.length; i++) {
			if(board[i] == 0) {
				slots.add(i);
			}
		}
		System.out.println(slots);
	}
	
	public boolean checkWin() {
		return checkRows() || checkCols() || checkDiags();
	}
	
	public boolean checkRows() {
		if(
				((board[0] + board[1] + board[2]==15)
				&& (board[0]!=0 && board[1]!=0 && board[2]!=0)) ||
				((board[3] + board[4] + board[5]==15)
				&& (board[3]!=0 && board[4]!=0 && board[5]!=0)) ||
				((board[6] + board[7] + board[8]==15)
				&& (board[6]!=0 && board[7]!=0 && board[8]!=0)) 
		) {
			return true;
		}
		return false;
	}
	
	public boolean checkCols() {
		if(
				((board[0] + board[3] + board[6]==15)
				&& (board[0]!=0 && board[3]!=0 && board[6]!=0)) ||
				((board[1] + board[4] + board[7]==15)
				&& (board[1]!=0 && board[4]!=0 && board[7]!=0)) ||
				((board[2] + board[5] + board[8]==15)
				&& (board[2]!=0 && board[5]!=0 && board[8]!=0)) 
		) {
			return true;
		}
		return false;
	}
	
	public boolean checkDiags() {
		if(
				((board[0] + board[4] + board[8]==15)
				&& (board[0]!=0 && board[4]!=0 && board[8]!=0)) ||
				((board[2] + board[4] + board[6]==15)
				&& (board[2]!=0 && board[4]!=0 && board[6]!=0))
		) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Integer> validSpots(){ //
		ArrayList<Integer> choice = new ArrayList<>();
		for (int i = 0; i<board.length; i++) {
			if(board[i]==0) {
				choice.add(i);
			}
		}
		return choice;
	}
}

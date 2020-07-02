public class TicTacToe {

	enum Player {playerX, playerO, empty};
	
	public static Player[][] board = new Player[4][4];
	
	public static int x1; 
	public static int y1;
	public static int x2; 
	public static int y2;
	public static Scanner ans = new Scanner(System.in);
	public static Random rand = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initial Board
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				board[i][j] = Player.empty;
			}
		}
		printBoard();
		
		//User Input
		
		
		
		
		//Game 
		while(isAvailable()) {
			
			playerMove(Player.playerO);
			
			//checks to see if the game is over
			if(terminalTest(Player.playerO)) {
				System.out.println("Player 1 wins!");
				break;
			}
			
			if(!isAvailable()) {
				System.out.println("Tied!");
				break;
			}
			
			randomMove(Player.playerX);
			
			//Checks to see if the game is over
			if(terminalTest(Player.playerX)) {
				System.out.println("Player 2 wins!");
				break;
			}
			
		}
		System.out.println("Game Over!");
	}
	
	
	
	public static void playerMove(Player player) {
		//For player 1
		System.out.println("For Player 1 :");
		System.out.println("Input for row number:");
		x1 = ans.nextInt();
		System.out.println("Input for column number: ");
		y1 = ans.nextInt(); 
		
		//Checks to see if the move is valid
		if((!legalMove(x1-1, y1-1)) ) {
		
			while(!(legalMove(x1-1, y1-1))) {
				System.out.println("Not a legal move! Try again.");
				System.out.println("Input for row number: ");
				x1 = ans.nextInt();
				System.out.println("Input for column number: ");
				y1 = ans.nextInt();

			}
		}
		
		if(player == Player.playerX) {
			userMove(Player.playerX, x1-1, y1-1);
		}
		else {
			 userMove(Player.playerO, x1-1, y1-1);
		}
		printBoard();
		
	}
	
	public static void randomMove(Player player) {
		
		System.out.println("Random move by Computer: ");
		int row = rand.nextInt(3);
		int column  = rand.nextInt(3);
		
		while(board[row][column] != Player.empty) {
			row = rand.nextInt(3);
			column = rand.nextInt(3);
		}
		
		board[row][column] = player;
		printBoard();
	}
	
	
	
	//Printing out the board
	public static void printBoard() {
	
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				
			
				if(board[i][j] == Player.playerX) {
					System.out.print("[X]");
				}
				else if(board[i][j]==Player.playerO) {
					System.out.print("[O]");
				}
				else if (board[i][j] == Player.empty){
					System.out.print("[ ]");
				}
				
			}
			System.out.println();
		}	
	}
	
	//putting user move onto the board
	public static void userMove(Player player, int x, int y) {
		board[x][y] = player;
	}
	
	
	//To check if the move is valid
	public static boolean legalMove(int x, int y) {
		
		if(x>3 || y>3) {
			return false;
		}
		
		if(board[x][y] == Player.empty ) {
			return true;
		} else {
			return false;
		}
	}
	
	//To check if the game is over
	public static boolean terminalTest(Player player) {
		
		//traverses through the board to check all the pieces
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				//To check if the rows are filled
				if(board[i][0]==player && board[i][1]==player && board[i][2]==player) {
					return true;
				}
				
				//to check if the columns are filled
				else if(board[0][j]==player && board[1][j]==player && board[2][j]==player) {
					return true;
				}
				
				//To check first diagonal
				else if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
					return true;
				}
				
				//to check second diagonal
				else if(board[0][2]==player && board[1][1]==player && board[2][0]==player) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public static boolean isAvailable() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == Player.empty) {
					return true;
				}
			}
		}
		return false;
	}
	
}

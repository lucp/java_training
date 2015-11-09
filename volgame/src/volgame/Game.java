package volgame;

import java.util.LinkedList;
import java.util.List;

public class Game {

	int size;
	
	boolean bombBoard[][];
	int pointBoard[][];
	
	int hbombs[];
	int vbombs[];
	
	int hpoints[];
	int vpoints[];
	
	double bombChances[][];
	double pointChances[][];
	
	int possibilities;
	
	public Game(int size) {
		this.possibilities = 0;
		this.bombChances =  new double[size][size];
		this.pointChances = new double[size][size];
		this.size = size;
		this.bombBoard = new boolean[size][size];
		this.pointBoard = new int[size][size];
		this.hbombs = new int[size];
		this.vbombs = new int[size];
		this.hpoints = new int[size];
		this.vpoints = new int[size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.bombBoard[i][j] = false;
				this.bombChances[i][j] = 0;
				this.pointBoard[i][j] = 0;
				this.pointChances[i][j] = 0;
			}
			this.hbombs[i] = 0;
			this.vbombs[i] = 0;
			this.hpoints[i] = 0;
			this.vpoints[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game(5);
		
		game.setBombs(new int[]{1,2,2,1,0, 1,2,2,1,0});
		game.setPoints(new int[]{4,5,3,6,7, 5,6,4,4,6});
		
		game.printBombBoard();
		System.out.println("-----------------");
		
		game.tryToPutBombOrPoint(0, 0, 1);
		
		System.out.println("Possibilities: " + game.possibilities);
		System.out.println("-----------------");
		
		game.divideBombChances(game.possibilities);
		game.printBombChances();
		game.dividePointChances(game.possibilities);
		game.printPointChances();
	}
	
	public void tryToPutBombOrPoint(int x, int y, int p) {
//		printBombBoard();
//		printPointBoard();
//		System.out.println("-----------------");
//		System.out.println("-----------------");
		if (isBombBoardFilled() && isPointBoardFilled()) {
			this.possibilities++;
			addBombChances(this.bombBoard);
			addPointChances(this.pointBoard);
			printBombBoard();
			printPointBoard();
			System.out.println("-----------------");
		}
		else {
			if (ableToSetBomb(x, y)) {
				this.bombBoard[x][y] = true;
				if (x == size - 1 && y == size - 1) {
					if (isBombBoardFilled()) {
						this.possibilities++;
						addBombChances(this.bombBoard);
						addPointChances(this.pointBoard);
					}
				}
				else {
					if (y == size - 1) {
						if (x + 1 < size) tryToPutBombOrPoint(x + 1, 0, 1);
					}
					else tryToPutBombOrPoint(x, y + 1, 1);
				}
				this.bombBoard[x][y] = false;
			}
			for (;p <= 3; p++) {
				if (ableToSetPoint(x, y, p)) {
					int prevPoint = this.pointBoard[x][y];
					this.pointBoard[x][y] = p;
					if (x == size - 1 && y == size - 1) {
						if (isBombBoardFilled() && isPointBoardFilled()) {
							this.possibilities++;
							addBombChances(this.bombBoard);
							addPointChances(this.pointBoard);
						}
					}
					else {
						if (y == size - 1) {
							if (x + 1 < size) tryToPutBombOrPoint(x + 1, 0, 1);
						}
						else tryToPutBombOrPoint(x, y + 1, 1);
					}
					this.pointBoard[x][y] = prevPoint;
				}
			}
		}
	}
	
	public void addBombChances(boolean[][] bombBoard) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (bombBoard[i][j] == true) this.bombChances[i][j] += 1;
			}
		}
	}
	
	public void addPointChances(int[][] pointBoard) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.pointChances[i][j] += this.pointBoard[i][j];
			}
		}
	}
	
	public void divideBombChances(double number) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.bombChances[i][j] /= this.possibilities;
			}
		}
	}
	
	public void dividePointChances(double number) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.pointChances[i][j] /= this.possibilities;
			}
		}
	}
	
	public int hBombsNumber(int x) {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.bombBoard[x][i] == true) sum++;
		}
		return sum;
	}
	
	public int hPointsNumber(int x) {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			sum += this.pointBoard[x][i];
		}
		return sum;
	}
	
	public int vBombsNumber(int y) {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.bombBoard[i][y] == true) sum++;
		}
		return sum;
	}
	
	public int vPointsNumber(int y) {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			sum += this.pointBoard[i][y];
		}
		return sum;
	}
	
	public int allBombsNumber() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (this.bombBoard[i][j] == true) sum++;
			}
		}
		return sum;
	}
	
	public boolean ableToSetBomb(int x, int y) {
		if (x >= size || y >=size) return false;
		if (vBombsNumber(y) >= this.vbombs[y]) return false;
		if (hBombsNumber(x) >= this.hbombs[x]) return false;
		return true;
	}
	
	public boolean ableToSetPoint(int x, int y, int p) {
		if (x >= size || y >=size) return false;
		if (vPointsNumber(y) + p > this.vpoints[y]) return false;
		if (hPointsNumber(x) + p > this.hpoints[x]) return false;
		return true;
	}
	
	public boolean isBombBoardFilled() {
		for (int j = 0; j < size; j++) {
			if (vBombsNumber(j) != this.vbombs[j]) return false;
		}
		for (int i = 0; i < size; i++) {
			if (hBombsNumber(i) != this.hbombs[i]) return false;
		}
		return true;
	}
	
	public boolean isPointBoardFilled() {
		for (int j = 0; j < size; j++) {
			if (vPointsNumber(j) != this.vpoints[j]) return false;
		}
		for (int i = 0; i < size; i++) {
			if (hPointsNumber(i) != this.hpoints[i]) return false;
		}
		return true;
	}
	
	public void setBombs(int[] bombList) {
		for (int i = 0; i < size; i++) {
			this.vbombs[i] = bombList[i];
		}
		for (int i = size; i < 2 * size; i++) {
			this.hbombs[i - size] = bombList[i];
		}
	}
	
	public void setPoints(int[] pointList) {
		for (int i = 0; i < size; i++) {
			this.vpoints[i] = pointList[i];
		}
		for (int i = size; i < 2 * size; i++) {
			this.hpoints[i - size] = pointList[i];
		}
	}
	
	public void printBombBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (this.bombBoard[i][j] == false) System.out.print("O ");
				else System.out.print("X ");
			}
			System.out.println("|" + this.hbombs[i]);
		}
		for (int j = 0; j < size; j++) {
			System.out.print("--");
		}
		System.out.println();
		for (int j = 0; j < size; j++) {
			System.out.print(this.vbombs[j] + " ");
		}
		System.out.println();
	}
	
	public void printBombChances() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.printf("%.2f ",this.bombChances[i][j]);
			}
			System.out.println("|" + this.hbombs[i]);
		}
		for (int j = 0; j < size; j++) {
			System.out.print("--");
		}
		System.out.println();
		for (int j = 0; j < size; j++) {
			System.out.print(this.vbombs[j] + " ");
		}
		System.out.println();
	}
	
	public void printPointBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(this.pointBoard[i][j] + " ");
			}
			System.out.println("|" + this.hpoints[i]);
		}
		for (int j = 0; j < size; j++) {
			System.out.print("--");
		}
		System.out.println();
		for (int j = 0; j < size; j++) {
			System.out.print(this.vpoints[j] + " ");
		}
		System.out.println();
	}
	
	public void printPointChances() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.printf("%.2f ",this.pointChances[i][j]);
			}
			System.out.println("|" + this.hbombs[i]);
		}
		for (int j = 0; j < size; j++) {
			System.out.print("--");
		}
		System.out.println();
		for (int j = 0; j < size; j++) {
			System.out.print(this.vbombs[j] + " ");
		}
		System.out.println();
	}

}

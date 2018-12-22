package Bean;

public class MangHaiChieu {
	private int row;
	private int col;
	String[][] array ;
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public String[][] getArray() {
		return array;
	}
	public void setArray(String[][] array) {
		this.array = array;
	}
	public MangHaiChieu(int row, int col, String[][] array) {
		super();
		this.row = row;
		this.col = col;
		this.array = array;
	}
	public MangHaiChieu() {
		super();
	}
}

package DAO;

import Bean.MangHaiChieu;

public class xuLyString {
	public static MangHaiChieu keyToArray(String key){
		String s = key.toUpperCase();
		String[] arrS = s.split(",");
		s = s.replace(",", "");
		char[] arrChar = s.toCharArray();
		int col = arrS[0].length();
		int row = arrS.length;
		String[][] arrayKey = new String[row][col];
		int dem = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arrayKey[i][j] = "" + arrChar[dem];
				dem++;
			}
		}
		//
		String[][] arrRS= new String[row+1][col+1];
		for (int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				arrRS[i][j] = arrayKey[i][j];
			}
			arrRS[row][i] = arrayKey[0][i];
			arrRS[i][col] = arrayKey[i][0];
		}
		
		MangHaiChieu mhc = new MangHaiChieu(row, col, arrRS);
		return mhc;
	}
}

package DAO;

import Bean.MangHaiChieu;
import Bean.viTriKyTu;

public class PlayfairCipher {
	public static viTriKyTu findIndex(MangHaiChieu mhc, String str) {
		viTriKyTu index = new viTriKyTu();
		String[][] arr = mhc.getArray();
		int row = mhc.getRow();
		int col = mhc.getCol();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((str.toUpperCase()).equals(arr[i][j])) {
					index.setRow(i);
					index.setCol(j);
				}
			}
		}
		return index;
	}

	public static String encryptedPlayfair(String source, String key) {
		MangHaiChieu mhc = xuLyString.keyToArray(key);
		String cipherText = "";
		String playFairMatrix[][] = mhc.getArray();
		source = source.replace(" ", "");
		System.out.println(source);
		do {
			String s1 = "" + source.charAt(0);
			String s2 = "" ;
			try {
				s2 = "" + source.charAt(1);
				source = source.substring(2);
			} catch (Exception e) {
				s2 = "";
				source = "";
			}
			
			viTriKyTu index1, index2;
			if (s1.equals(s2)) {
				source = s2 + source;
				s2 = "X";
			} else {
				
				if (!s2.isEmpty()) {
				} else {
					s2 = "Q";
				}
			}
			index2 = findIndex(mhc, s2);
			index1 = findIndex(mhc, s1);
			if (index1.getRow() == index2.getRow()) {
				int row = index1.getRow();
				cipherText += playFairMatrix[row][index1.getCol() + 1];
				cipherText += playFairMatrix[row][index2.getCol() + 1] + " ";
			} else {
				if (index1.getCol() == index2.getCol()) {
					int col = index1.getCol();
					cipherText += playFairMatrix[index1.getRow() + 1][col];
					cipherText += playFairMatrix[index2.getRow() + 1][col] + " ";
				} else {
					cipherText += playFairMatrix[index1.getRow()][index2.getCol()];
					cipherText += playFairMatrix[index2.getRow()][index1.getCol()] + " ";
				}

			}

		} while (source.length() > 0);
		return cipherText;
	}
}

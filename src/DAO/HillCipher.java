package DAO;

import Bean.MangHaiChieu;

public class HillCipher {
	public static int[][] MatrixP(String text, int n) {
		int row = 0;
		
		text = text.toUpperCase();
		if(text.length() % n > 0) {
			row = text.length() / n + 1;
			int canthem = n - text.length() % n;
			for (int i = 0; i < canthem; i++) {
				text += "Q";
			}
		}else {
			row = text.length() / n;
		}
		int dem = 0;
		text = text.replace(" ", "");
		int[] arrP = getMaKT(text);
		int[][] array = new int[row][n];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j]=arrP[dem];
				dem++;
			}
		}
		return array;
	}
	public static int[] getMaKT(String kt) {
		kt = kt.toUpperCase();
		int[] rs = new int[kt.length()];
		
		for (int i = 0; i < kt.length(); i++) {
			rs[i] = kt.codePointAt(i) - 65;
		}
		
		return rs;
	}
	public static int[][] keyToArray(String key){
		String s = key.toUpperCase();
		key = key.toUpperCase();
		s = s.replace(" ", "");
		String[] arrS = s.split(",");
		key = key.replace(",", "");
		
		key = key.substring(0, key.length()-1);
		String[] arrCh = key.split("%");
		int row = arrS.length;
		String[][] arrayKey = new String[row][row];
		int dem = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				arrayKey[i][j] = arrCh[dem];
				dem++;
			}
		}
		int[][] rs = new int[row][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				rs[i][j] = Integer.parseInt(arrayKey[i][j]);
			}
		}
		return rs;
	}
	public static String encryptedHill (String plantext, String key) {
		String cipherText = "";
		plantext = plantext.replace(" ", "");
		System.out.println(plantext);
		int[][] arrK = keyToArray(key);
		int[][] arrP = MatrixP(plantext,arrK.length);
		int[][] arrC = new int[arrP.length][arrK.length];
		
		for (int i = 0; i < arrP.length; i++) {
            for (int j = 0; j < arrK.length; j++) {
            	arrC[i][j] = 0;
                for (int k = 0; k < arrP[0].length; k++) {
                	arrC[i][j] = arrC[i][j] + arrP[i][k] * arrK[k][j];
                }
            }
        }
		
		for (int i = 0; i < arrC.length; i++) {
			for (int j = 0; j < arrC[0].length; j++) {
				int mod = arrC[i][j] % 26;
				char c = (char) (mod + 65);
				cipherText += "" + c;
			}
		}
		return cipherText;
	}
	
	public static void main(String[] args) {
		

	}

}

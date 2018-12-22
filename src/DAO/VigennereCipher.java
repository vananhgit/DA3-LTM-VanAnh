package DAO;

public class VigennereCipher {
	public static int[] getMaKT(String kt) {
		kt = kt.toUpperCase();
		int[] rs = new int[kt.length()];
		
		for (int i = 0; i < kt.length(); i++) {
			rs[i] = kt.codePointAt(i) - 65;
		}
		
		return rs;
	}
	
	public static String getStringFromCode(int[] arr) {
		String rs = "";
		for (int code : arr) {
			char c = (char) (code + 65);
			rs += "" + c;
		}
		return rs;
	}

	public static String encryptedVigennere(String planttext, String key) {
		planttext = planttext.replace(" ", "");
		planttext = planttext.toUpperCase();
		key = key.replace(" ", "");
		key = key.toUpperCase();
		String K = "", Khoa = key;
		if (planttext.length() > key.length()) {
			int thuong = planttext.length() / key.length();
			int sodu = planttext.length() % key.length();
			for (int i = 0; i < thuong; i++) {
				K += key;
			}
			String s = key.substring(0, sodu);
			K += s;
		} else {
			K = Khoa.substring(0, planttext.length());
		}
		
		// Tới đây thì có p = planttext; key = K;
		int[] arrP = getMaKT(planttext);
		int[] arrK = getMaKT(K);
		int[] arrC = new int[arrP.length];
		
		for (int i = 0; i < arrC.length; i++) {
			arrC[i] = calc(arrP[i], arrK[i]);
		}
		String cipherText = getStringFromCode(arrC);
		
		return cipherText;

	}

	private static int calc(int p, int k) {
		int result = 0;
		result = (p + k) % 26;
		return result;
	}
}

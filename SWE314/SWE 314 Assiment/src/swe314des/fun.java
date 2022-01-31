package swe314des;

public class fun {
	public String Left_shift(String s, int round) {
		String input = "";
		char fst = s.charAt(0);
		int[] shiftTims = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };
		String timp = "";
		for (int i = 0; i < shiftTims[round]; i++) {
			for (int j = 1; j < s.length(); j++) {
				if (i == 0)
					input += s.charAt(j);
				else if (i == 1)
					timp += input.charAt(j);

			}
			input += fst;
			fst = input.charAt(0);
			if (i == 1)
				timp += fst;
		}
		if (shiftTims[round] == 1)
			return input;
		else
			return timp;
	}

	public String PC1(String key /* 64 bit */) {

		int[] PC1 = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60,
				52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5,
				28, 20, 12, 4 };

		String resolt = "";

		for (int i = 0; i < PC1.length; i++) {

			resolt += key.charAt(PC1[i] - 1);

		}

		return resolt;/* 48 bit */
	}

	public String PC2(String key /* 56 bit */) {

		int[] PC2 = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52,
				31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };
		String resolt = "";

		for (int i = 0; i < PC2.length; i++) {

			resolt += key.charAt(PC2[i] - 1);

		}

		return resolt;/* 48 bit */
	}

	public String F(String R, String K) {
		/*
		 * int[] EP_box = { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13,
		 * 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24,
		 * 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 }; String resolt = "";
		 * 
		 * for (int i = 0; i < EP_box.length; i++) {
		 * 
		 * resolt += R.charAt(EP_box[i] - 1);
		 * 
		 * }
		 */

		// after xor

		String R48 = Expansion(R);
		String AFXOR = "";
		IO.write("ep.txt", R48 + "\n");
		for (int i = 0; i < K.length(); i++) {
			if (R48.charAt(i) == K.charAt(i)) {
				AFXOR += "0";
			} else
				AFXOR += "1";
		}
		// String timp = "";
		IO.write("xored.txt", AFXOR + "\n");
		String s0 = "", s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "";

		int counter = 0;
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 6; j++) {

				switch (i) {
				case 0:
					s0 += AFXOR.charAt(counter);
					break;
				case 1:
					s1 += AFXOR.charAt(counter);
					break;
				case 2:
					s2 += AFXOR.charAt(counter);
					break;
				case 3:
					s3 += AFXOR.charAt(counter);
					break;
				case 4:
					s4 += AFXOR.charAt(counter);
					break;
				case 5:
					s5 += AFXOR.charAt(counter);
					break;
				case 6:
					s6 += AFXOR.charAt(counter);
					break;
				case 7:
					s7 += AFXOR.charAt(counter);
					break;
				}
				counter++;

			}
		}

		for (int i = 0; i < 8; i++) {

			switch (i) {
			case 0:
				s0 = sBox(s0, 0);
				IO.write("s0.txt", s0 + "\n");
				break;
			case 1:
				s1 = sBox(s1, 1);
				IO.write("s1.txt", s1 + "\n");
				break;
			case 2:
				s2 = sBox(s2, 2);
				IO.write("s2.txt", s2 + "\n");
				break;
			case 3:
				s3 = sBox(s3, 3);
				IO.write("s3.txt", s3 + "\n");
				break;
			case 4:
				s4 = sBox(s4, 4);
				IO.write("s4.txt", s4 + "\n");
				break;
			case 5:
				s5 = sBox(s5, 5);
				IO.write("s5.txt", s5 + "\n");
				break;
			case 6:
				s6 = sBox(s6, 6);
				IO.write("s6.txt", s6 + "\n");
				break;
			case 7:
				s7 = sBox(s7, 7);
				IO.write("s7.txt", s7 + "\n");
				break;
			}

		}

		return Dbox((String)s0 + s1+ s2 + s3 + s4 + s5 + s6 + s7 );
	}

	public String sBox(String input, int N) {
		// [0-7][0-3][0-15]
		int[][][] sboxarr = {
				{ { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
						{ 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
						{ 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
						{ 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } },

				{ { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
						{ 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
						{ 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
						{ 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } },
				{ { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
						{ 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
						{ 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
						{ 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } },
				{ { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
						{ 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
						{ 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
						{ 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } },
				{ { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
						{ 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
						{ 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
						{ 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } },
				{ { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
						{ 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
						{ 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
						{ 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } },
				{ { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
						{ 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
						{ 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
						{ 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } },
				{ { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
						{ 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
						{ 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
						{ 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } } };

		String row = "";
		row += input.charAt(0);
		row += input.charAt(5);
		String cul = "";
		cul += input.charAt(1);
		cul += input.charAt(2);
		cul += input.charAt(3);
		cul += input.charAt(4);

		int rowN = BtoD(row);
		int culN = BtoD(cul);

		int output = sboxarr[N][rowN][culN];

		return DtoB(output);
	}

	public String Expansion(String M) {
		int[] EP_box = { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18,
				19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 };
		String resolt = "";

		for (int i = 0; i < EP_box.length; i++) {

			resolt += M.charAt(EP_box[i] - 1);

		}

		return resolt;
	}

	public String IP(String M/* 64 */) {

		int[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64,
				56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37,
				29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

		String resolt = "";
		for (int i = 0; i < IP.length; i++) {

			resolt += M.charAt(IP[i] - 1);

		}

		return resolt;// 64
	}

	public int BtoD(String B) {

		int decimal = Integer.parseInt(B, 2);

		// System.out.println(decimal);

		return decimal;
	}

	public String DtoB(int num) {
		String end = "";
		int binary[] = new int[4];
		int index = 0;
		while (num > 0) {
			binary[index++] = num % 2;
			num = num / 2;
		}
		if (index==0)
			end+="0000";
		else if (index == 1)
			end+="000";
		else if (index == 2)
			end+="00";
		else if (index == 3)
			end+="0";

		for (int i = index - 1; i >= 0; i--) {
			end += binary[i];
		}

		return end;
	}
	
	
	public String Dbox(String s /*32 bit -> sboxs*/) {
		
		
		String rez ="";
		 int[] P = { 16, 7, 20, 21, 29, 12, 28,
                 17, 1, 15, 23, 26, 5, 18,
                 31, 10, 2, 8, 24, 14, 32,
                 27, 3, 9, 19, 13, 30, 6,
                 22, 11, 4, 25 };
		
		 for(int i=0 ; i<P.length;i++) {
			 rez+=s.charAt(P[i]-1);
		 }
		 
		
		 IO.write("f.txt", rez + "\n");
		return rez;
	}  
	
	
	
	public String xor(String L , String F) {
		
		String AFXOR = "";

		for (int i = 0; i < L.length(); i++) {
			if (L.charAt(i) == F.charAt(i)) {
				AFXOR += "0";
			} else
				AFXOR += "1";
		}
		
		return AFXOR;
	}
	
	
	public String finalP(String FM /*final message*/) {
		
		String end="";
		int final_perm[] = { 40, 8, 48, 16, 56, 24, 64, 32,
                39, 7, 47, 15, 55, 23, 63, 31,
                38, 6, 46, 14, 54, 22, 62, 30,
                37, 5, 45, 13, 53, 21, 61, 29,
                36, 4, 44, 12, 52, 20, 60, 28,
                35, 3, 43, 11, 51, 19, 59, 27,
                34, 2, 42, 10, 50, 18, 58, 26,
                33, 1, 41, 9, 49, 17, 57, 25 };
		
		
		for (int i=0 ; i<final_perm.length;i++) {
			end+=FM.charAt(final_perm[i]-1);
		}
		
		
		
		return end;
	}
	
	
	
	
	
	
	
	
}
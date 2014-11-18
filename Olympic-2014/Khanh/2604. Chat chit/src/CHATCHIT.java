import java.util.Scanner;

class CHATCHIT {

	public static void main(String[] args) {
		String[] RWc = new String[8];// RW compare
		String[] RWr = new String[8];// RW replace
		RWc[0] = "k";
		RWr[0] = "khong";
		RWc[1] = "ko";
		RWr[1] = "khong";
		RWc[2] = "ng";
		RWr[2] = "nguoi";
		RWc[3] = "n";
		RWr[3] = "nhieu";
		RWc[4] = "dc";
		RWr[4] = "duoc";
		RWc[5] = "hok";
		RWr[5] = "khong";
		RWc[6] = "ntn";
		RWr[6] = "nhu the nao";
		RWc[7] = "kq";
		RWr[7] = "ket qua";

		String[] Rc = new String[5];
		String[] Rr = new String[5];
		Rc[0] = "j";
		Rr[0] = "gi";
		Rc[1] = "w";
		Rr[1] = "qu";
		Rc[2] = "f";
		Rr[2] = "ph";
		Rc[3] = "dz";
		Rr[3] = "d";
		Rc[4] = "z";
		Rr[4] = "d";
		

		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String delims = "[ ]";
		String[] token = s.split(delims);
		for (int i = 0; i < token.length; i++) {
			for (int iRW = 0; iRW < 8; ++iRW)
				if (token[i].equals(RWc[iRW]))
					token[i] = RWr[iRW];
			for (int iR = 0; iR < 5; ++iR)
				if (token[i].contains(Rc[iR]))
					token[i] = token[i].replace(Rc[iR], Rr[iR]);
		}
		StringBuilder r = new StringBuilder();
		for (int i = 0; i < token.length - 1; i++)
			r.append(token[i] + " ");
		r.append(token[token.length - 1]);
		System.out.println(r);
		in.close();
	}
}
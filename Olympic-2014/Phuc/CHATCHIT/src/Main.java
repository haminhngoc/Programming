import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class Main {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		while (hasNext()) {
			String s = nextString();
			int index = 0;
			String temp = "";
			int length = s.length();
			if(str.length()>0){
				str.append(" ");
			}
			for (int i = 0; i < length; ++i) {
				if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
					temp += s.charAt(i);
				} else {
					if (temp.compareTo("k") == 0) {
						temp = "khong";
					} else if (temp.compareTo("ko") == 0) {
						temp = "khong";
					} else if (temp.compareTo("ng") == 0) {
						temp = "nguoi";
					} else if (temp.compareTo("n") == 0) {
						temp = "nhieu";
					} else if (temp.compareTo("dc") == 0) {
						temp = "duoc";
					} else if (temp.compareTo("hok") == 0) {
						temp = "khong";
					} else if (temp.compareTo("ntn") == 0) {
						temp = "nhu the nao";
					} else if (temp.compareTo("kq") == 0) {
						temp = "ket qua";
					}
					for (int j = 0; j < temp.length(); ++j) {
						if (temp.charAt(j) == 'j') {
							str.append("gi");
						} else if (temp.charAt(j) == 'w') {
							str.append("qu");
						} else if (temp.charAt(j) == 'f') {
							str.append("ph");
						} else if (temp.charAt(j) == 'd'
								&& j + 1 < temp.length()
								&& temp.charAt(j + 1) == 'z') {
							continue;
						} else if (temp.charAt(j) == 'd'
								|| temp.charAt(j) == 'z') {
							str.append("d");
						} else {
							str.append(temp.charAt(j));
						}
					}
					temp = "";
					str.append(s.charAt(i));
				}
				
			}
			if (temp.compareTo("k") == 0) {
				temp = "khong";
			} else if (temp.compareTo("ko") == 0) {
				temp = "khong";
			} else if (temp.compareTo("ng") == 0) {
				temp = "nguoi";
			} else if (temp.compareTo("n") == 0) {
				temp = "nhieu";
			} else if (temp.compareTo("dc") == 0) {
				temp = "duoc";
			} else if (temp.compareTo("hok") == 0) {
				temp = "khong";
			} else if (temp.compareTo("ntn") == 0) {
				temp = "nhu the nao";
			} else if (temp.compareTo("kq") == 0) {
				temp = "ket qua";
			}
			for (int j = 0; j < temp.length(); ++j) {
				if (temp.charAt(j) == 'j') {
					str.append("gi");
				} else if (temp.charAt(j) == 'w') {
					str.append("qu");
				} else if (temp.charAt(j) == 'f') {
					str.append("ph");
				} else if (temp.charAt(j) == 'd'
						&& j + 1 < temp.length()
						&& temp.charAt(j + 1) == 'z') {
					continue;
				} else if (temp.charAt(j) == 'd'
						|| temp.charAt(j) == 'z') {
					str.append("d");
				} else {
					str.append(temp.charAt(j));
				}
			}
			
		}

		System.out.println(str);
	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[1024];
	public static int lenbuf = 0;
	public static int ptrbuf = 0;

	public static boolean hasNext() {
		if (lenbuf == 0) {
			try {
				lenbuf = in.read(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new InputMismatchException();
			}
			if (lenbuf <= 0) {
				return false;
			}
		}
		for (; ptrbuf < lenbuf; ++ptrbuf) {
			if (!isSpace(bytes[ptrbuf])) {
				return true;
			}
		}
		return false;
	}

	public static int readByte() {

		if (lenbuf == -1) {
			throw new InputMismatchException();
		}
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new InputMismatchException();
			}
			if (lenbuf <= 0) {
				return -1;
			}

		}

		return bytes[ptrbuf++];
	}

	public static boolean isSpace(int b) {
		return !(b >= 33 && b <= 126);
	}

	public static int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	public static char nextChar() {
		return (char) read();
	}

	public static String nextString() {
		StringBuilder str = new StringBuilder();

		int b = read();
		while (!isSpace(b)) {
			str.appendCodePoint(b);
			b = readByte();
		}

		return str.toString();
	}

	public static int nextInt() {
		return Integer.parseInt(nextString());
	}

	public static long nextLong() {
		return Long.parseLong(nextString());
	}
}

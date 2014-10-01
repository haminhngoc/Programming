package MyCode;

import MyCode.InputReader;

import java.io.PrintWriter;

public class TanCungSo0_2942 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int[] letters = new int[26];
        char[] s = in.next().toCharArray();
        for (int i = 0; i < s.length; i++) {
            letters[s[i] - 'a']++;
        }
        int numerator = 0;
        int denominator = 0;
        numerator = countZero(s.length);
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                denominator += countZero(letters[i]);
            }
        }
        out.println(numerator - denominator);
    }

    static int countZero(int n) {
        int out = 0;
        for (int k = 0; Math.pow(5, k + 1) < n; k++) {
            out += (int) (n / Math.pow(5, k+1));
        }
        return out;
    }
}

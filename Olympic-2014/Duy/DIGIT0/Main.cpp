#include<iostream>
#include<algorithm>
#include<math.h>
#include<vector>

using namespace std;

int countZero(int n) {
        int out = 0;
        for (int k = 0; pow(5, k + 1) <= n; k++) {
            out += (int) (n / pow(5, k+1));
        }
        return out;
    }
int main()
{
		int letters[26];
		for(int i = 0 ; i < 26; ++i)
		{
			letters[i] = 0;
		}
        string s;
        cin>>s;
       
        for (int i = 0; i < s.size(); ++i) {
            letters[s[i] - 'a']++;
        }
        int numerator = 0;
        int denominator = 0;
        numerator = countZero(s.size());
         
        for (int i = 0; i < 26; ++i) {
            if (letters[i] != 0) {
                denominator += countZero(letters[i]);
            }
        }
        cout<<(numerator - denominator);
        return 0;
}


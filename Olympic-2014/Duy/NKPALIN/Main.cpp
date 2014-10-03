//(only get 50 points)

#include<iostream>
#include<math.h>
#include<algorithm>
#include<vector>
#include<string>

using namespace std;

int main()
{
		string a;
		string b;
		cin>>a;		
        int length = a.length();
        b =a;
        reverse(b.rbegin(),b.rend());
        int dp[length + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
				dp[i][j] =0;
			}
		}
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = length - 1;
        int j = length - 1;
        string res ="";
        while (i >= 0 && j >= 0) {
            if (a[i] == b[j]) {
                res+=a[i];
    			i--;
                j--;
            } else {
                if (dp[i][j + 1] >= dp[i + 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
       cout<<res;
}

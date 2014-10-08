#include<iostream>
#include<algorithm>
#include<math.h>
#include<vector>
using namespace std;

int main()
{
		int n;
		cin>>n;
        long a[30000];
        long dp[30000];
        for (int i = 0; i < n; i++) {
            cin>>a[i];
            dp[i] = 0;
        }
        
        long res = 0;
        for (int i = 0; i < n; i++) {
            dp[i]++;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            res = max(res, dp[i]);
        }
        cout<<res;
}


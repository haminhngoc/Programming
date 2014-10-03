#include<iostream>
#include<algorithm>
#include<math.h>
#include<vector>
using namespace std;

class book{
	public:
	int p;
	int k;
	bool operator<(const book& b) const;
};
bool book::operator<(const book& b) const
{
  	if(p < b.p)
    	return true;
	return false;      
 
}
int main()
{
	int n;
	cin>>n;
	vector<book> a;
	for(int i = 0 ; i < n ;++i)
	{
		book tmp ;
		cin>> tmp.p;
		cin>> tmp.k;
		a.push_back(tmp);
	}
	sort(a.begin(),a.end());
	 int dp[10001];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = a[i].k - a[i].p;
            for (int j = 0; j < i; j++) {
                if (a[j].k <= a[i].p) {
                    dp[i] = max(dp[i], dp[j] + (a[i].k - a[i].p));
                }
            }
            res = max(res,dp[i]);
        }
        cout<<res;
}


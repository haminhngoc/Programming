#include<iostream>
#include<stdio.h>
#include<math.h>
#include<algorithm>
#include<string>
#include<vector>

using namespace std;
class chocolate{
	public:
		unsigned long long int cost;
		unsigned long long int nCow;
		bool operator <(const chocolate& c) const;
};
bool chocolate::operator<(const chocolate& c) const
{
	if(cost < c.cost)
	{
		return true;
	}
	return false;
}
int main(){
	unsigned long long int n,b;
	chocolate p[100000];
	scanf("%llu%llu",&n,&b);
	for(int i = 0 ; i < n ;++i)
	{	
		scanf("%llu%llu",&p[i].cost,&	p[i].nCow);
	}
	sort(p,p+n);
	unsigned long long int res = 0;
		for (int i = 0; i < n; i++) {
			unsigned long long int canBuy = min(p[i].nCow, b / p[i].cost);
			if (canBuy == 0) {
				break;
			}
			res += canBuy;
			b -= canBuy * p[i].cost;
		}
		cout<<res;
}


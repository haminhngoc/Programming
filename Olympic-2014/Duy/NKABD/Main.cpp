#include<iostream>
#include<algorithm>
#include<math.h>
#include<vector>
using namespace std;

int main()
{
	  	int from ;
        int to ;
        cin>>from;
        cin>>to;
        int mark[100001];
        for(int i = 0 ; i <= to;++i)
        {
        	mark[i] = 1;
		}
        for (int i = 2; i <= to / 2; i++) {
            int tmp = i+i;
            while (tmp <= to) {         
                mark[tmp] += i;
                tmp += i;
            }
        }
        int cnt = 0;
        for (int cur = from; cur <= to; cur++) {
            if (mark[cur] > cur) {
                cnt++;
            }
        }
       cout<<cnt;
}


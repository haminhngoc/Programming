#include <bits/stdc++.h>
using namespace std;

const int MAX = (int)1e5+10;
long a[MAX];
long n;
long res;

int main() {
    scanf("%li",&n);
    res = 0;
    for(int i = 0; i < n; ++i){
        scanf("%li",&a[i]);
        res += a[i];
    }
    sort(a,a+n);
    for(int i = 0; i*2 < n; ++i){
        res += a[n-1-i] - a[i];
    }
    printf("%li",res);
	return 0;
}


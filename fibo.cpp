#include <stdio.h>

int freq = 0 ;

int fibo(int n){
	freq++;
	if (n <= 1)
		return n;
	else
		return fibo(n-1) + fibo(n-2);
}

int main()
{
	int n;
	int i = 0;
	
	while (i < 10){
		i++;
		scanf("%d", &n);
		fibo(n);
		printf("count: %d \n", freq);
		freq=0;
	}
	
	return 0;
}




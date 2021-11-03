#include <stdio.h>

	int freq = 0;

int fibo(int n){
	
	int i, fiboOld, fiboOldOld, fiboN;
	
	fiboOldOld = 0;
	fiboOld = 1;
	
	i=2;
	
	while (i < n){
		freq++;
		fiboN = fiboOld + fiboOldOld;
		fiboOldOld = fiboOld;
		fiboOld = fiboN;
		
		i++;
	}
	return fiboN;
}

int main()
{
	int n;
	int j = 0;

	
	while (j < 10){
		j++;
		scanf("%d", &n);
		fibo(n);
		printf("count: %d \n", freq);
		freq = 0;
	}
	
	return 0;

}




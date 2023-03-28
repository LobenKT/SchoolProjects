#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int ctr = 0;
double pi_approx_2(int N){

	double inCount = 0;
	double x;
	double y;
	int i;
	
	for(i=1;i <= N; i++){
		x = rand()%2;
		y = rand()%2;
		
		if(x*x+y*y<=1){
		ctr++;
		inCount++;
		}
	}
	return (4*inCount/N);
}

int main(){
	int i=0;
	int N;
	double pi;
	while (i<10){
	
	scanf("%d", &N);
	pi = pi_approx_2(N);
	printf("FREQUENCY: %d\n",ctr);
	printf("PI = %.2f\n", pi);
	ctr=0;
}
	return 0;
}

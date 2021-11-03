#include <stdio.h>
#include <math.h>
int ctr = 0;
double pi_approx_1(int r){
	double pi;
	int inCount = 0;
	int outCount = 0;
	int x,y;
	
	for (x = 0;x<=r;x++){
	//	ctr++;
		for (y = 0;y <=r;y++)
			if(x*x+y*y<=r*r){
				ctr++;
				inCount=inCount+1;
			}
			else{
				ctr++;
				outCount=outCount+1;
			}
	}
	pi = 4 * inCount/(inCount+outCount);
	return pi;
}

int main(){
	int i=0;
	int r;
	double pi;
	while (i<10){
	
	scanf("%d", &r);
	pi = pi_approx_1(r);
	printf("FREQUENCY: %d\n",ctr);
	printf("PI = %f\n", pi);
	ctr=0;
}
	return 0;
}


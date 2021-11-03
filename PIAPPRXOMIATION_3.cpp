#include <stdio.h>
#include <math.h>
int freq = 0;
int main(){

	float inCount = 0;
	float r = 19;
	float rSquare = r * r;
	float xSquare;
	int x, y;
	
	
	for (x = 1; x <= r; x++){
	
		xSquare = x*x;
		freq++;
		
		for(y=1;y<=r;y++){
			
			freq++;
			
			if (xSquare + y*y <= rSquare){
				inCount++;
				}
		}
	}
	
	float result = 4*(inCount / rSquare);
	printf("FREQUENCY COUNT; %d \n", freq);
	printf("%f\n",result);

	
	return 0;
}

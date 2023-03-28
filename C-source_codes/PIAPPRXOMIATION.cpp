#include <stdio.h>
#include <math.h>

int main(){
	float inCount = 0;
	float r = 1000;
	float rSquare = r * r;
	float xSquare;
	int x, y;
	
	
	for (x = 1; x <= r; x++){
		xSquare = x*x;
		for(y=1;y<=r;y++){
			if (xSquare + y*y <= rSquare)
				inCount++;
		}
	}
	float result = 4*(inCount / rSquare);
	
	printf("%f",result);
	return 0;
}

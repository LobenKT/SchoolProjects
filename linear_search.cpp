#include <stdio.h>

int freq = 0;

int LINEAR_SEARCH(int List[], int n, int s){
	int i;

	for (i = 0; i < n; i++){
		freq++;
		if (List[i] == s)
		return i;
	}
	return 0;	
}


int main()
{
	int i=0;
	int List[] = {1,2,3,4,5,6,7,8};
	int n = sizeof(List);
	int s;
	
		i++;
		scanf("%d", &s);
		LINEAR_SEARCH(List,n,s);
		printf("count: %d \n", freq);

	
	
	
	
	return 0;

}

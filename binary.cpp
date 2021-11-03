#include <stdio.h>
int freq = 0;

int binary_search(int List[], int s,int start,int end){
	while (start <= end){

		int mid = (start + end)/2;
		
		if (List[mid] == s){
			freq++;
			return mid;
		}
		
		if (List[mid] < s){
			freq++;
			start = mid + 1;
		}
		
		else{
			freq++;
			end = mid - 1;   
		}
	}
	
	if (s == List[start]){
	
		freq++;
		return start;}
	else if (s == List[end]){

		freq++;
		return end;
}
		
	return 0;
}


int main()
{
	int i=0;
	int List[] = {1,2,3,4};
	int n = sizeof(List);
	int s;
	

		i++;
		scanf("%d", &s);
		 binary_search(List, s,0,n-1);
		printf("count: %d \n", freq);

	return 0;

}

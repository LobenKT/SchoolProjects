/*
  CSADPRG GROUP #3
  MEMBERS: ALOG, ATIENZA, BONDOC, ERMITANO, TIPAN
*/
#include <stdio.h>
#include <string.h>

typedef char String[256];


struct node {
   int data;
   int key;
   struct node *next;
};

struct node *head = NULL;
struct node *current = NULL;

//1 String create() : returns an empty string
char* create(){
  return "";
}

//2 Set add (String s, char c): add a character c to the 
// end of the String s, and returns the pointer 
// to the first element of String s
char * add(String s, char c){

  // utilizes strnct to add element c
  strncat(s, &c, 1);  

  return &*s;
}

//3 String insert (String s, char c, int pos):   
// returns a new String with the character c inserted 
// at position pos(position starts from 0).
char * insert(String s, char c, int pos){

  String temp;
  strcpy(temp, s); //copies string to temporary array
  
  temp[pos+1] = temp[pos]; //moves former element forward once, clears position
  temp[pos] = c; //copies element c to position
  
  strcpy(s, temp);
  return s;
}

//4 String delete (String s, int pos):   
// returns a new String with the character c deleted from position pos.
char * delete (String s, int pos){
  s[pos] = '\0'; //replaces element with null byte

  return s;
}

//5 String substitute (String s, String find, String replace):   
// this should search for the substring find in the string s 
// and replace it with the string replace. 
// It should return a new string with the substituted value. 
// If the string is not found, throw an error message that 
// substitution couldnft be performed. You need to look only 
// for the first occurrence of the substring find and it should be case sensitive.
char * substitute (String s, String find, String replace){
	// s - Hello World!
	// find - World
	// replace - CCPROG
  	int accuracy_streak = 0;
  	int start_index_of_find = 0;
  	int i = 0, j = 0;
  	// create string that will contain the new string
  	String s3;
  	strcpy(s3, s);
  	printf("\n%s\n",s3);
  	// loop through s until it reaches the end of the string
  	while(find[j]!='\0' && s[i]!='\0'){
  		// compare if the characters are the same
  		// CASE-SENSITIVE
  		if(s[i]==find[j]){
  			// get the first index where the similarities occur
  			if(j == 0){
  				start_index_of_find = i;
			}
  			accuracy_streak+=1;
  			i++;
  			j++;
		}
		// not the same
		else{
			// increment i to compare next value in FIND
			i++;
		}
	}
	// reset counter variable i
	i = 0;
	// copy the characters ONLY if the accuracy is equal to the length of FIND
	if(accuracy_streak == strlen(find)){
		// loop through s and replace the elements in s that form the string of FIND
		// copy the elements until the end of REPLACE
		while(replace[i]!=' ' && replace[i]!='\0'){
			s[start_index_of_find] = replace[i];
			// increment index
			start_index_of_find++;
			i++;
		}
		// add ! at the end of the string
		strcat(s,"!");
		// return the new string
		return s;
	}
	// otherwise
	else{
		// output error message
		printf(">>> ERROR: Cannot perform substitution! <<< \n");
		// return the old string
		return s;
	}
	// return
	return s;
}

//6 int compare (String s1, String s2):   
// this should return 1 if the strings are the same, 
// otherwise it should return 0
int compare (String s1, String s2){
  if(strcmp(s1, s2) == 0)
		return 1;
		
	return 0;
}

//7 int getLength(String s): this should return the length of the string
int getLength (String s){
  return strlen(s);
}

//8 void print (String s): displays on screen the whole string
void print (String s){
  printf("%s\n", s);
}
void printString() {
   struct node *ptr = head;
   printf("\n[ ");
	
   //start from the beginning
   while(ptr != NULL) {
      printf("(%d,%d) ",ptr->key,ptr->data);
      ptr = ptr->next;
   }
	
   printf(" ]");
}


// the main function of the program to test out the functions
int main(void) {
	// declare the necessary variables
  	String s1, s2;
	// initialize the string variables
  	strcpy(s1,create());
  	strcpy(s2,create());
	// add elements to s1
  	add (s1, 'H');
  	add (s1, 'e');
  	add (s1, 'l');
  	add (s1, 'l');
  	add (s1, 'o');
	// add elements to s2
  	add (s2, 'H');
  	add (s2, 'e');
  	add (s2, 'l');
  	add (s2, 'l');
  	add (s2, 'o');
  	add (s2, ' ');
  	add (s2, 'W');
  	add (s2, 'o');
  	add (s2, 'r');
  	add (s2, 'l');
  	add (s2, 'd');
	// print the results from the functions
  	print (s1);   // this statement will display (Hello)
  	add (s2, '!');
  	print (s2); // this statement will display (Hello World!)
  	print (insert(s2, 's', 11)); // this statement will return (Hello Worlds!)
  	print (delete(s2, 11)); // this statement will return (Hello World)
  	print (substitute(s2, "World", "CCPROG")); // this statement will return (Hello CCPROG!)
  	// TESTING
  	//print (substitute(s2, "Hello", "CCPROG"));
    printf ("%d\n", compare(s1, s2)); // this statement will return (0)
    printf ("%d\n", getLength(s1));// this statement will return (5)
    printf ("%d\n", compare(s1, s1));

  return 0;
}

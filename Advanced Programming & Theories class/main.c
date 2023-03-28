/*
  CSADPRG GROUP #3
  MEMBERS: ALOG, ATIENZA, BONDOC, ERMITANO, TIPAN
  CSADPRG MINI MP 2
*/
#include <stdio.h>
#include <stdlib.h>


// TYPDEF DECLARATIONS FOR LINKED LIST STRUCTURE 
typedef struct Node {
  char data;
  struct Node *next;
} Node;

typedef struct String {
  Node *head;
} String;

//FUNCTION PROROTYPE 
int getLength(String *str);

// FUNCTION TO GENERATE A NODE ON THE LINKED LIST
Node *createNode(char a) {
  
  Node *newNode = (Node *)malloc(sizeof(Node));
  //Allocate memory and check if its successful
  if (newNode == NULL) {
    printf("null\n");
    return NULL;
  }

  
  newNode->data = a; //Populating the node with values
  newNode->next = NULL; 

  
  return newNode;
}

//1 String create() : returns an empty string
String *create() {
  
  String *str = (String *)malloc(sizeof(String));
  //Allocate memory and check if its successful
  if (str == NULL) {
    printf("Memory not allocated\n");
  }

  
  str->head = NULL; //Set the head to NULL

  
  return str; //return the String
}



//2 Set add (String s, char c): add a character c to the 
// end of the String s, and returns the pointer 
// to the first element of String s
char *add(String *str, char c) {
  if (str->head == NULL) {
    str->head = createNode(c);
  } 
  else {
    Node *current = NULL;
    current = str->head;
    while (current->next != NULL) {
      current = current->next;
    }
    current->next = createNode(c);
  }

  // Return the pointer to the first element of the string
  return &str->head->data;
}



//3 String insert (String s, char c, int pos):   
// returns a new String with the character c inserted 
// at position pos(position starts from 0).
String insert (String *str, char c, int pos) {
  // Create a new node
  Node *current = str->head;

  // Store the length of the string
  int len = getLength(str);

  // Check if the string is empty
  if (str->head == NULL) {
    printf("The string is empty\n");
    return *str;
  }

  // Check if the position is valid
  if (pos < 0 || pos > len) {
    printf("Invalid position\n");
    return *str;
  }
  
  int i;

  // Traverse the linked list to the position
  // Subtract 1 from the position because the position starts from 0
  for (i = 0; i < pos - 1; i++) {
    current = current->next;
  }
  
  // Insert the new node
  Node *newNode = createNode(c);
  newNode->next = current->next;
  current->next = newNode;

  // Return the new string
  return *str;
}


//4 String delete (String s, int pos) deletes a string element at position pos 
String delete (String *str, int pos) {
  
  Node *current = str->head;
  
  int len = getLength(str); //get the length of String

  // if-condition to check if String is empty
  if (str->head == NULL) {
    printf("The string is empty\n");
    return *str;
  }

  // if-condition to check if position is valid
  if (pos < 0 || pos > len) {
    printf("Invalid position\n");
    return *str;
  }
	
  int i;
  // Traverse the linked list to the position
  // Subtract 1 from the position because the position starts from 0
  for (i = 0; i < pos - 1; i++) {
    current = current->next;
  }

  // Delete the node
  Node *temp = current->next;
  current->next = temp->next;
  free(temp);

  // Return the new string
  return *str;
}

/*
NOTES:
*str - Hello World!
*find - World
*replace - CCPROG
*/

//5 String substitute (String s, String find, String replace):   
// this should search for the substring find in the string s 
// and replace it with the string replace. 
// It should return a new string with the substituted value. 
// If the string is not found, throw an error message that 
// substitution couldnft be performed. You need to look only 
// for the first occurrence of the substring find and it should be case sensitive.
String substitute(String *str, String *find, String *replace) {
  // Get the head of the string by dereferencing the string
  Node *current = str->head;
  Node *to_find = find->head;
  Node *to_replace = replace->head;

  // Check if the string is empty
  if (str->head == NULL) {
    printf("The string is empty\n");
    return *str;
  }

  // Check if the find string is empty
  if (find->head == NULL) {
    printf("The string to be replaced is empty\n");
    return *str;
  }

  // Check if the replace string is empty
  if (replace->head == NULL) {
    printf("The string to be replaced is empty\n");
    return *str;
  }

	int index = 0, first_index = 0, last_index = 0, count = 0;
	// get the index of the first character of *find
	for(; current != NULL; current = current->next) {
		// end the loop only if the string to_find is NULL
		if(to_find == NULL){
			break;
		}
    	// if the characters are the same for current and *find
    	if(current->data == to_find->data){
    		count+=1;
    		// increment to_find string
    		to_find = to_find->next;
		}
    	// increment index
    	index++;
  	}
  	// set last index
  	first_index = last_index - count - 1;
  	first_index *= -1;
	last_index = index;
	
  
	// FOR-LOOP to delete nodes
	for(index = first_index; index < last_index; index++){
		delete(str, first_index);
	}
	// FOR-LOOP to add nodes to the string
	for(; to_replace != NULL; to_replace = to_replace->next){
		insert(str, to_replace->data, first_index);
		first_index++;
	}
  
  return *str;  
}

// this should return 1 if the strings are the same, otherwise it should return 0
int compare(String *s1, String *s2) {
  // Get the head of the string by dereferencing the string
  Node *currentA = s1->head;
  Node *currentB = s2->head;

  // Store the length of the string
  int len1 = getLength(s1);
  int len2 = getLength(s2);

  // Check if the string is empty
  if (s1->head == NULL) {
    printf("The string is empty\n");
    return 0;
  }

  // Check if the string is empty
  if (s2->head == NULL) {
    printf("The string is empty\n");
    return 0;
  }

  if (len1 != len2) {
    return 0;
  }
	
	int i;
  // Traverse the linked list to the position
  // Use delete function to delete the string to be replaced
  // Use add function to add the string to be replaced
  for (i = 0; i < len1; i++) {
    if (currentA->data != currentB->data) {
      return 0;
    }
    currentA = currentA->next;
    currentB = currentB->next;
  }

  // Return the new string
  return 1;
}

void print(String *str) {
  // Get the head of the string by dereferencing the string
  Node *current = str->head;

  // Check if the string is empty
  if (str->head == NULL) {
    printf("The string is empty\n");
    return;
  }

  // Traverse the linked list
  for (; current != NULL; current = current->next) {
    printf("%c", current->data);
  }
  printf("\n");
}

int getLength(String *str) {
  // Get the head of the string by dereferencing the string
  Node *current = str->head;
  int n = 0;
  
  // Check if the string is empty
  if (str->head == NULL) {
    return 0;
  }

  // Traverse the linked list
  for(; current != NULL; current = current->next) {
    n++;
  }

  return n;
}


int main() {
  String *s1 = create();
  String *s2 = create();

  add(s1, 'H');
  add(s1, 'e');
  add(s1, 'l');
  add(s1, 'l');
  add(s1, 'o');

  add(s2, 'H');
  add(s2, 'e');
  add(s2, 'l');
  add(s2, 'l');
  add(s2, 'o');
  add(s2, ' ');
  add(s2, 'W');
  add(s2, 'o');
  add(s2, 'r');
  add(s2, 'l');
  add(s2, 'd');

  print(s1);
  add (s2, '!');
  print (s2); // this statement will display (Hello World!)
  insert(s2, 's', 11);
  print(s2); // this statement will return (Hello Worlds!)
  delete(s2, 11); // 11
  print(s2); // this statement will return (Hello World)
  String *find = create();
  String *replace = create();
  // Find = World
  add(find, 'W');
  add(find, 'o');
  add(find, 'r');
  add(find, 'l');
  add(find, 'd');
  // Replace = CCPROG
  add(replace, 'C');
  add(replace, 'C');
  add(replace, 'P');
  add(replace, 'R');
  add(replace, 'O');
  add(replace, 'G');
  substitute(s2, find, replace); 
  print(s2); // this statement will return (Hello CCPROG!)
  printf("%d\n", compare(s1, s2)); // this statement will return 0
  printf("%d\n", getLength(s1)); // this statement will return 1
  
  return 0;
}
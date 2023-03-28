#Name: TIPAN, LOBEN KLIEN A.
#Language: PYTHON 3
#Paradigm: Object-Oriented/Functional

class calculator:
    
    def getOperation(List,String1,String2): #function to evaluate which operations to execute
        row = len(String1)
        col = len(String2)
        operations = [] 

        while row > 0 and col > 0:
            if(row - 1 >= 0 and col - 1 >= 0 and String1[row - 1] == String2[col - 1]):
                print('Entry 1: ',row,' ',col)
                print(String2[col-1]+' '+String1[row-1])
                row-=1
                col-=1
                operations.append("Copy "+String1[row])
            else:                         
                if(List[row][col] == List[row-1][col - 1] +1):
                    
                    operations.append("Replace  "+String2[col-1]+" with "+String1[row-1])
                    row-=1
                    col-=1
                elif(List[row][col] == List[row-1][col] + 1):
                    
                    operations.append("Insert "+String1[row-1])
                    row-=1
                elif(List[row][col] == List[row][col - 1] + 1):
                    
                    operations.append("Delete "+String2[col - 1])
                    col-=1
            if(row - 1 < 0 and col !=0):
                
                operations.append("Delete "+String2[col - 1])
                col-=1
            elif(col - 1 < 0 and row != 0):
                operations.append("Insert "+String1[row-1])
                row -= 888881
            print(row,' ',col)

        print('Operations Executed: ')
            
        i = len(operations)-1
        while(i>=0):
            print(operations[i])
            i-=1

    def getDistance(String1,String2): #function to initialize the List data structure with the two strings
        m = len(String1)
        n = len(String2)
        rows,cols = (m+1,n+1)

        print(String1+" "+String2)

        List = [[0 for i in range(cols)] for j in range(rows)] 
        
        for u in range(rows):
            List[u][0] = u
            
        for k in range(cols):
            List[0][k] = k

        for i in range(1,rows):
            for j in range(1,cols):
                if(String1[i-1] == String2[j-1]):
                    List[i][j] = List[i-1][j-1]
                    
                else:
                    D = List[i-1][j-1]
                    L = List[i][j-1]
                    T = List[i-1][j]
                    List[i][j] = 1 + min([D,L,T])
        print(' ',end = '\n    ')
        for i in range(n):
            print(String2[i], end = " ")
        print()
        
        for i in range(rows):
            print(String1[i-1],end = ' ')
            for j in range(cols):
                print(List[i][j], end = " ")
                
            print()
        print()
        calculator.getOperation(List,String1,String2)
            
        return List[m][n]


String1 = "horde"
String2 = "hoard"

print(calculator.getDistance(String1,String2))
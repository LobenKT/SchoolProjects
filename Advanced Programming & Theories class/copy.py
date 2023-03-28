class distanceProj:
    def findAction(A,s1,s2):
        row = len(s1);
        col = len(s2);
        actions = [];
        while row > 0 and col > 0:
            if(row - 1 >= 0 and col - 1 >= 0 and s1[row - 1] == s2[col - 1]):
                print('Entry 1: ',row,' ',col);
                print(s2[col-1]+' '+s1[row-1])
                row-=1;
                col-=1;
                #actions.append("Copy "+s1[row]);
            else:                         
                if(A[row][col] == A[row-1][col - 1] +1):
                    #print('Entry 2: ',row,' ',col);
                    actions.append("Convert  "+s2[col-1]+" to "+s1[row-1])
                    row-=1;
                    col-=1;
                elif(A[row][col] == A[row-1][col] + 1):
                    #print('Entry 4: ',row,' ',col);
                    actions.append("Insert "+s1[row-1])
                    row-=1;
                elif(A[row][col] == A[row][col - 1] + 1):
                    #print('Entry 3: ',row,' ',col);
                    actions.append("Delete "+s2[col - 1]);
                    col-=1;
            if(row - 1 < 0 and col !=0):
                #print('Entry 3: ',row,' ',col);
                actions.append("Delete "+s2[col - 1]);
                col-=1;
            elif(col - 1 < 0 and row != 0):
                actions.append("Insert "+s1[row-1])
                row -= 888881;
            print(row,' ',col);


        print('List of Actions:');
           
        i = len(actions)-1;
        while(i>=0):
            print(actions[i]);
            i-=1;

    def minDistance(s1,s2):
        actions = [];
        m = len(s1);
        n = len(s2);
        rows,cols = (m+1,n+1);
        print(s1+" "+s2);
        arr = [[0 for i in range(cols)] for j in range(rows)] # Initialize
        
        for u in range(rows):
            arr[u][0] = u;
            
        for k in range(cols):
            arr[0][k] = k;

        for i in range(1,rows):
            for j in range(1,cols):
                if(s1[i-1] == s2[j-1]):
                    arr[i][j] = arr[i-1][j-1];
                    #actions.append("Copy");
                else:
                    D = arr[i-1][j-1];
                    L = arr[i][j-1];
                    T = arr[i-1][j];
                    arr[i][j] = 1 + min([D,L,T]);
        print(' ',end = '\n    ');
        for i in range(n):
            print(s2[i], end = " ");
        print();
        
        for i in range(rows):
            print(s1[i-1],end = ' ');
            for j in range(cols):
                print(arr[i][j], end = " ");
                
            print();
        print();
        distanceProj.findAction(arr,s1,s2);
            
        return arr[m][n];


s1 = "execution"
s2 = "intention"

print(distanceProj.minDistance(s1,s2));
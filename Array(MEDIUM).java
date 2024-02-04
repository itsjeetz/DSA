//Q1) 2Sum Problem
//Time : O(N*N)  Space: O(1) ----> Brute Force Method.
public class Solution {
    public static String read(int n, int []book, int target){
        // Write your code here.
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(i==j)
                {
                    continue;
                }
                if(book[i]+book[j]==target)
                {
                    return "YES";
                }
            }
        }
        return "NO";
    }
}

//Time : 

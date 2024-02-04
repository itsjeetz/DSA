//Q1) 2Sum Problem ----- 2 methods discussed !!

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

//Time : O(N*log N)  Space: O(N) ------> Better Method using Hashing
import java.util.HashMap;
public class Solution {
    public static String read(int n, int []book, int target){
        // Write your code here.
       HashMap<Integer,Integer> mpp=new HashMap<>();
       int a,more;
       for(int i=0;i<n;i++)
       {
           a=book[i];
           more=target-a;
           if(mpp.containsKey(more))
           {
               return "YES";
           }
           else if(!mpp.containsKey(book[i]))
           {
                mpp.put(book[i], i);
           }
       }
       return "NO";
    }
}

//Q2) Sort array of 0's , 1's and 2's.(You can use any sorting algorithm but thats not optimal so lets see other solutions)
// Time:  O(2N)     Space: O(1) 

import java.util.* ;
import java.io.*; 
public class Solution {
    public static void sortArray(ArrayList<Integer> arr, int n) 
    {
        int c0 = 0, c1 = 0, c2 = 0, i;
        for (i = 0; i < n; i++) 
        {
            if (arr.get(i) == 0) c0++;
            else if (arr.get(i) == 1) c1++;
            else c2++;
        }

        for (i = 0; i < c0; i++) arr.set(i, 0);
        for (i = c0; i < c1 + c0; i++) arr.set(i, 1);
        for (i = c1 + c0; i < n; i++) arr.set(i, 2);
    
    }
}

//C++ Solution :- 
#include <bits/stdc++.h> 
void sortArray(vector<int>& arr, int n)
{
    int c0=0,c1=0,c2=0,i;
    for(i=0;i<n;i++)
    {
        if(arr[i]==0)c0++;
        else if(arr[i]==1)c1++;
        else c2++;
    }
    for(i=0;i<c0;i++)arr[i]=0;
    for(i=c0;i<c1+c0;i++)arr[i]=1;
    for(i=c1+c0;i<n;i++)arr[i]=2;
}

//Using DUTCH NATIONAL FLAG ALGORITHM :(C++)
//Time : O(N)  Space : O(1)

#include <bits/stdc++.h> 
void sortArray(vector<int>& arr, int n)
{
    int low,mid,high;
    low=0;
    high=n-1;
    mid=0;

    while(mid<=high)
    {
        if(arr[mid]==0)
        {
            swap(arr[mid],arr[low]);
            mid++;
            low++;
        }
        else if(arr[mid]==1)
        {
            mid++;
        }
        else
        {
            swap(arr[mid],arr[high]);
            high--;
        }
    }

}


// IN Java
class Solution {
    public void sort012(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//Q3)  


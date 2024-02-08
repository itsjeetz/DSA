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
------------------------------------------------------------------------------------------------------------
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
-------------------------------------------------------------------------------------------------------------------
//Q3)  Majority Element (>n/2 times)
//Time : O(N*N)  Space : O(1)   ------> Brute Foroce

    public class Solution {
    public static int majorityElement(int []v) {
        int i,j,c=0;

        for(i=0;i<v.length;i++)
        {
            c=0;
            for(j=0;j<v.length;j++)
            {
                if(v[i]==v[j])
                {
                    c++;
                }
            }
            if(c>(v.length/2))
                return v[i];
        }
        return 0;
    }
}

//Time : O(N)+O(N)   Space : O(1) ---- Moore's Voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int ele=nums[0];
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(c==0)
            {
                c=1;
                ele=nums[i];
            }
            else if(ele==nums[i])
            {
                c++;
            }
            else
            {
                c--;
            }
        }
        int x=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==ele)
            {
                x++;
            }
        }
        if(x> nums.length/2)
            return ele;

        return 0;
    }
}

--------------------------------------------------------------------------------------------------------
//Q4) Maximum subarray Sum.
//Time : O(N*N)

    class Solution {
    public int maxSubArray(int[] nums) {
        int i,j,sum=0,max=Integer.MIN_VALUE;
		for(i=0;i<nums.length;i++)
		{
			sum=0;
			for(j=i;j<nums.length;j++)
			{
				sum+=nums[j];
			max= (max>sum)?max:sum;
			}
		}
		return max;
    }
}

//USING KADANE'S ALGORITHMS :
//Time : O(N)  Space : O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int i,sum=0,max=Integer.MIN_VALUE;
		for(i=0;i<nums.length;i++)
		{
			sum+=nums[i];
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;
		}
		return max;
    }
}

--------------------------------------------------------------------------------------------------------------
//Q5) Best time to buy and sell stocks to maximize profit.
//Time : O(N)  Space : O(1)

public class Solution {
    public static int bestTimeToBuyAndSellStock(int []prices) {
        int i,maxprofit=0,minvalue=prices[0];
        for(i=0;i<prices.length;i++)
        {
            int cost=prices[i]-minvalue;
            minvalue= Math.min(minvalue,prices[i]);
            maxprofit= Math.max(maxprofit,cost);
        }
        return maxprofit;
    }

}

-----------------------------------------------------------------------------------------------------------------
//Q6) An array contains positive and negative numbers we have to arrange then in alternate manner.
//	Eg. Input : a=[1,2,-5,5,-6,-8]  Output : a=[1,-5,2,-6,5,-8]
// Time : O(N + N/2)  Space : O(N) ---> Brute Force.
public class Solution {
    public static int[] alternateNumbers(int []a)
    {
        int positive[]=new int[a.length/2];
        int negatives[]=new int[a.length/2];
        int j=0,k=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>0)
            {
                positive[j]=a[i];
                j++;
            }
            else
            {
                negatives[k]=a[i];
                k++;
            }
        }
        for(int i=0;i<positive.length;i++)
        {
            a[2*i]=positive[i];
            a[2*i+1]=negatives[i];
        }
        return a;
    }
}

//Time : O(N)  Space : O(N)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i,p=0,n=1;
        int arr[]=new int[nums.length];
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                arr[p]=nums[i];
                p=p+2;
            }
            else if(nums[i]<0)
            {
                arr[n]=nums[i];
                n=n+2;
            }

        }
        return arr;
    }
}

-------------------------------------------------------------------------------------------------
//Q7) Leaders in an array. A leader is that element in an array whose all elements to the right of that
//	element is smaller than that element.The last element is always condiderd as a leader.

// Time : O(N) Space : O(N)
import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        int i,j,max=a[a.length-1];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(max);
        for(i=a.length-2;i>=0;i--)
        {
            if(a[i]>max)
            {
                list.add(a[i]);
                max=a[i];
            }
        }
        return list;
    }
}

---------------------------------------------------------------------------------------------------------
//Q8) Set Matrix Zero--If an element is zero mark all the elements in that row and column as zero.
//Time : O(2*M*N)  Space : O(M)+O(N) --> not optimal 

class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j;
        int n=matrix.length;
        int m=matrix[0].length;
        int row[]=new int[n];
        int col[]=new int[m];
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(row[i]==1 || col[j]==1)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}

//Time : O(2*N*M)  Space : O(1)
#include <bits/stdc++.h> 
vector<vector<int>> zeroMatrix(vector<vector<int>> &matrix, int n, int m) 
{
	int i,j,col0=1;
	for(i=0;i<n;i++)
	{
		for(j=0;j<m;j++)
		{
			if(matrix[i][j]==0)
			{
				matrix[i][0]=0;
				if(j!=0)
				{
					matrix[0][j]=0;
				}
				else
				{
					col0=0;
				}
			}
		}
	}

	for(i=1;i<n;i++)
	{
		for(j=1;j<m;j++)
		{
			if(matrix[i][j]!=0)
			{
				if(matrix[i][0]==0 || matrix[0][j]==0)
				{
					matrix[i][j]=0;
				}
			}
		}
	}

	if(matrix[0][0]==0)
	{
		for(j=0;j<m;j++)matrix[0][j]=0;
	}
	if(col0==0)
	{
		for(i=0;i<n;i++)matrix[i][0]=0;
	}
	return matrix;
}

-----------------------------------------------------------------------------------------------------
//Q9) Rotate Matrix by 90 degrees 
//	 111	  261
//  A =	 623  --> 521
//	 258	  831

//Time : O(2*N*N)  Space : O(1)

	import java.util.*;
public class Solution {
    public static void rotateMatrix(int [][]mat){
        int i,j;
        for(i=0;i<mat.length-1;i++)
        {
            for(j=i+1;j<mat.length;j++)
            {
                if(i!=j)
                {
                    mat[i][j]=mat[i][j]^mat[j][i];
                    mat[j][i]=mat[i][j]^mat[j][i];
                    mat[i][j]=mat[i][j]^mat[j][i];
                }
            }
        }

        for(i=0;i<mat.length;i++)
        {
            for(j=0;j<mat.length/2;j++)
            {
                    mat[i][j]=mat[i][j]^mat[i][mat.length-1-j];
                    mat[i][mat.length-1-j]=mat[i][j]^mat[i][mat.length-1-j];
                    mat[i][j]=mat[i][j]^mat[i][mat.length-1-j];
            }
        }
    }
}

-----------------------------------------------------------------------------------------------------
//Q10) 

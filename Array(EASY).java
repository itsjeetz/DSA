//Q1) Largest Element in an array

static int largestElement(int[] arr, int n)
    {
        int max=arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        return max;

    }
--------------------------------------------------------------------------------
//Q2) Second Largest Element in an array & Second Smallest in an array.

 public static int[] getSecondOrderElements(int n, int []a) 
  {
        int []sol =new int[2];
        int x=a[0],y=-1;
        for(int i=1;i<n;i++)
        {
            if(a[i]>x)
            {
                y=x;
                x=a[i];
            }
            else if(a[i]!=x && a[i]>y)
            {
                y=a[i];
            }
        }
        sol[0]=y;
        x=a[0];
        y=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(a[i]<x)
            {
                y=x;
                x=a[i];
            }
            else if(a[i]!=x && a[i]<y)
            {
                y=a[i];
            }
        }
        sol[1]=y;
        return sol;

    }

------------------------------------------------------------------------
//Q3) Check if array is sorted.

public static int isSorted(int n, int []a) 
    {
        for(int i=1;i<n;i++)
        {
            if(a[i]<a[i-1])
                return 0;
        }
        return 1;
    }

--------------------------------------------------------------------------
//Q4) Remove duplicates from Sorted Array and return the number of unique elements.

public static int removeDuplicates(int[] arr,int n) 
    {
       int i=0;
        for(int j=1;j<n;j++)
        {
            if(arr[i]!=arr[j])
            {
                arr[i+1]=arr[j];
                i++;
            }
        }
        return (i+1);
    }

--------------------------------------------------------------------------
//Q5) Left Rotate an array by one place
//Time : O(N)   Space: O(1) extra space and O(N) for the algorithm

import java.util.* ;
import java.io.*; 


public class Solution {

    static int[] rotateArray(int[] arr, int n) {
        // Write your code here.
        int temp=arr[0];
        for(int i=1;i<n;i++)
        {
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;
        return arr;
    }
}

----------------------------------------------------------------------------
//Q6) Left Rotate an array by k places
  
  vector<int> rotateArray(vector<int>arr, int k)
 {
    int n=arr.size();
   vector<int>temp(n);
   for(int i=0;i<n;i++)
   {
   int ind=(n+k+i)%n;
   temp[i]=arr[ind];
   }

   return temp;
}

-------------------------------------------------------------------------------
//Q7)  Move all zeros present in an array to the end of the array
//Time : O(2N)  Space : O(N)
  public class Solution {
        public static int[] moveZeros(int n, int []a) {
        // Write your code here.
        int temp[] = new int[n];
        int i,j=0;
        for(i=0;i<n;i++)
        {
            if(a[i]!=0){
            temp[j]=a[i];
            j++;}
        }
        for(i=j;i<n;i++)
        {
            temp[i]=0;
        }
        return temp;
    }
}

//SOLUTION 2:
//Time : O(N)  Space : O(1)
public class Solution {
        public static int[] moveZeros(int n, int []a) {
        // Write your code here.
        int i,j=-1;
        for(i=0;i<n;i++)
        {
            if(a[i]==0)
            {
                j=i;
                break;
            }
        }
        if(j==-1)
        {
            return a;
        }
        else{
        for(i=j+1;i<n;i++)
        {
            if(a[i]!=0)
            {
                a[i]=a[i]^a[j];
                a[j]=a[i]^a[j];
                a[i]=a[i]^a[j];
                j++;
            }
        }
        }
        return a;
    }
}

------------------------------------------------------------------------------
//Q8) Linear Search
import java.util.*;
public class Solution {
    public static int linearSearch(int n, int num, int []arr){
        // Write your code here.
        for(int i=0;i<n;i++)
        {
            if(arr[i]==num)
            {
                return i;
            }
        }
        return -1;
    }
}
--------------------------------------------------------------------------------
//Q9) Union of two sorted array
  import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        HashSet<Integer> arry=new HashSet<>();
        ArrayList<Integer> xy=new ArrayList<>();
        for(int i=0;i<a.length;i++)
        {
            arry.add(a[i]);
        }
        for(int i=0;i<b.length;i++)
        {
            arry.add(b[i]);
        }
        for(int i: arry)
        {
            xy.add(i);
        }
        return xy;
    }
}
-----------------------------------------------------------------------------------
//Q10) Find missing number in an array
//BRUTE FORCE APPROACH (BAD WAY)

  class Solution {
    public int missingNumber(int[] nums)
     {
        int i,j,x;
        for(i=1;i<=nums.length;i++)
        {
            x=0;
            for(j=0;j<nums.length;j++)
            {
                if(nums[j]==i)
                {
                    x=1;
                }
            }
            if(x==0)
            {
                return i;
            }
        }
        return 0;
    }
}

//OPTIMAL APPROACH(GOOD WAY)


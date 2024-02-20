//Q1) Binary Search to find a element

class Solution {
    public int search(int[] nums, int target) 
    {
        int low=0,high=nums.length-1,mid;
        
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}

//Q2) Implement Lower Bound and Upper Bound using Binary Search 

public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        int high=n-1,low=0,mid,ans=n;
        while(high>=low)
        {
            mid=(low+high)/2;
            if(arr[mid]>=x)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}


public class Solution {
    public static int upperBound(int []arr, int x, int n){
        int low=0,high=n-1,mid,ans=n;
        while(high>=low)
        {
            mid=(low+high)/2;
            if(arr[mid]>x)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}


//Q3) Insert Element in Sorted array . Return the postion where needs to be inserted.

class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int low=0,high=nums.length-1,mid,ans=nums.length;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]>=target)
                {
                    ans=mid;
                    high=mid-1;
                }
            else
                low=mid+1;
        } 
        return ans;       
    }
}


//Q4) Search in Rotated Sorted Array(Unique Elements)

class Solution {
    public int search(int[] nums, int target) 
    {
        int n=nums.length;
        int low=0,high=n-1,mid;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[low]<=nums[mid] )
            {
                if(nums[low]<=target && nums[mid]>=target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else
            {
                if(nums[high]>=target && nums[mid]<=target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;      
    }
}

//Q5) Search in Rotated Sorted Array(Elements are not distinct)

class Solution {
    public boolean search(int[] nums, int target) 
    {
        int n=nums.length;
       int low=0,high=n-1,mid;
       while(low<=high)
       {
           mid=(low+high)/2;
           if(nums[mid]==target)
           {
               return true;
           }
           if(nums[mid]==nums[low] && nums[mid]==nums[high])
           {
               low++;
               high--;
               continue;
           }

           if(nums[low]<=nums[mid])
           {
               if(target>=nums[low] && nums[mid]>=target)
                    high=mid-1;
                else
                    low=mid+1;
           }
           else
           {
               if(target>=nums[mid] && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
           }
       }
       return false;
    }
}

//Q6) Find Minimum is rotated sorted array

public class Solution {
    public static int findMin(int []arr) {
        int high=arr.length-1,low=0,mid;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(arr[low]<=arr[mid])
            {
                ans=(ans<arr[low])?ans:arr[low];
                low=mid+1;
            }
            else
            {
                high=mid-1;
                ans=(ans<=arr[mid])?ans:arr[mid];
            }
        }
        return ans;
    }
}




class Solution {
    public static void swap(int nums[],int i, int pivot){
        int temp=nums[i];
        nums[i]=nums[pivot];
        nums[pivot]= temp;
    }
    public static void reverse(int[] nums, int pivot, int j){
        int k = pivot;
        int l = j;
        while(k<l){
            swap(nums,k,l);
            k++;
            l--;
        }
    }
    public void nextPermutation(int[] nums) {
    int n = nums.length;
    int pivot = -1;
    for(int i = n-2 ; i >= 0; i-- ){
        if(nums[i] < nums[i+1]){
            pivot= i;
            break;
        }
    }

      if (pivot ==-1){
        reverse(nums,0,n-1);
        return;
    }
    for(int j= n-1 ; j>pivot;j--){
        if (nums[j] > nums[pivot]){
            swap(nums,j,pivot);
            break;
        }
       
    }
   reverse(nums,pivot+1,n-1);
    }
}

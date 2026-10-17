class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        int arrSum=0;
        int miss=0;
        for(int j=1;j<=n;j++){
            sum=sum+j;
        }
          for(int i=0;i<n;i++){
            arrSum=arrSum+nums[i];
            miss=sum-arrSum;
        }
        return miss;
    }
}
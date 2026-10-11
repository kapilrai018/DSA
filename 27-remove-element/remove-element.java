class Solution {
    public int removeElement(int[] nums, int val) {
    int i = 0;
    int end = nums.length;

    while (i < end) {
        if (nums[i] == val) {
               nums[i] = nums[end - 1];
               end--;
           } else {
              i++;
          }
        }

        return end;
    }
}

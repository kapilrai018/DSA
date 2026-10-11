class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        arrange(nums, 0, result);
        return result;
    }

    private void arrange(int[] nums, int pos, List<List<Integer>> result) {
        if (pos == nums.length) {
            List<Integer> copy = new ArrayList<>(nums.length);
            for (int value : nums) {
                copy.add(value);
            }
            result.add(copy);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            arrange(nums, pos + 1, result);
            swap(nums, pos, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    
    }
}
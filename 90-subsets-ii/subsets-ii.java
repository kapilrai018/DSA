class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            int from = (i > 0 && nums[i] == nums[i - 1]) ? start : 0;
            int size = result.size();

            for (int j = from; j < size; j++) {
                List<Integer> extended = new ArrayList<>(result.get(j));
                extended.add(nums[i]);
                result.add(extended);
            }

            start = size;
        }

        return result;
    }
}
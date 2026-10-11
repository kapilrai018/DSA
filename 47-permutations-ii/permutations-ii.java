
class Solution {
    private static final int OFFSET = 10;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] freq = new int[21];
        for (int value : nums) {
            freq[value + OFFSET]++;
        }

        List<List<Integer>> result = new ArrayList<>();
        build(freq, nums.length, new ArrayList<>(), result);
        return result;
    }

    private void build(int[] freq, int size, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == size) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;
            path.add(i - OFFSET);
            build(freq, size, path, result);
            path.remove(path.size() - 1);
            freq[i]++;
        }
    }
}
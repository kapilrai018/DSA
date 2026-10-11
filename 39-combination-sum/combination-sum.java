class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        search(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void search(int[] candidates, int start, int remaining,
                        List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) {
                break;
            }

            path.add(candidates[i]);
            search(candidates, i, remaining - candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }
}

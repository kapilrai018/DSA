class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        choose(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void choose(int n, int k, int start, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        int need = k - path.size();

        for (int num = start; num <= n - need + 1; num++) {
            path.add(num);
            choose(n, k, num + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
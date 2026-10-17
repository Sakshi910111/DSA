import java.util.HashSet;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean[] vis;

    public int totalNumbers(int[] digits) {
        vis = new boolean[digits.length];
        helper(0, 0, digits);
        return set.size();
    }

    public void helper(int count, int cur, int[] d) {
        if (count == 3) {
            if (cur % 2 == 0) {
                set.add(cur);
            }
            return;
        }

        for (int i = 0; i < d.length; i++) {
            if (vis[i])
                continue;

            if (count == 0 && d[i] == 0)
                continue;

            vis[i] = true;
            helper(count + 1, cur * 10 + d[i], d);
            vis[i] = false;
        }
    }
}
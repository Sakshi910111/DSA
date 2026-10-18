import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    int[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (int) (((long) comb[i - 1][j - 1]
                        + comb[i - 1][j]) % MOD);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        return (int) ((ways(list) - 1L + MOD) % MOD);
    }

    private long ways(List<Integer> nums) {
        if (nums.size() <= 2) return 1;

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            int x = nums.get(i);
            if (x < root) left.add(x);
            else right.add(x);
        }

        long l = ways(left);
        long r = ways(right);
        long choose = comb[left.size() + right.size()][left.size()];

        return choose * l % MOD * r % MOD;
    }
}
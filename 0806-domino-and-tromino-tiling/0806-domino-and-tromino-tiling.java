class Solution {

    protected static int MOD = 1_000_000_007;

	public int numTilings(int n) {
		if (n < 1) {
			return 0;
		}

		return tilings(n, new HashMap<>());
	}

	protected int tilings (int n, Map<Integer, Integer> cache) {
		if (n <= 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (cache.containsKey(n)) {
			return cache.get(n);
		}

		int n1 = 2 * tilings(n - 1, cache) % MOD;
		int n2 = tilings (n - 3, cache) % MOD;

		int ans = n1 + n2;
		ans %= MOD;
		cache.put(n, ans);
		return ans;
	}
}
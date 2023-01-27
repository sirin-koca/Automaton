class FiniteAutomaton {
    private static final int Q = 2; // number of states
    private static final int[] F = {0}; // final states
    private static final int[][] delta = {{1, 0}, {1, 1}}; // transition function

    public static boolean recognize(String s) {
        int q = 0;
        for (int i = 0; i < s.length(); i++) {
            q = delta[q][s.charAt(i) - '0'];
        }
        for (int f : F) {
            if (q == f) {
                return true;
            }
        }
        return false;
    }
}
public class Solution3 {


    public static int solution(int[] A) {

        return minSum(A, A.length - 1);
    }

    private static int minSum(int[] A, int n) {
        if (n == -1)
            return 0;
        return Math.min(Math.abs(A[n] + minSum(A, n - 1)), Math.abs(-A[n] + minSum(A, n - 1)));
    }

    public static void main(String args[]) {
        int[] val = {1, 5, 2, -2};
        System.out.println(solution(val));
    }
}

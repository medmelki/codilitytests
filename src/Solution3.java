import java.util.stream.IntStream;

public class Solution3 {


    private static int solution(int[] A) {

        int v = IntStream.of(A)
                .map(Math::abs)
                .reduce(0, Integer::sum);
        int n = A.length;

        int[][] k = new int[n + 1][v + 1];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                if (i == 0 || j == 0)
                    k[i][j] = 0;
                    // loop logic really starts when i = 1
                else {
                    // Return the min of two cases:
                    k[i][j] = Math.min(
                            // (1) -1 included with solution that leads to that
                            Math.abs(-A[i] + k[i - 1][Math.abs(j - A[i])]),
                            // (2) 1 included
                            Math.abs(A[i] + k[i - 1][Math.abs(j + A[i])]));
                }
            }
        }
        return k[n][v];
    }

    public static void main(String args[]) {
        int[] val = {1, 5, 2, -2};
        System.out.println(solution(val));
    }
}

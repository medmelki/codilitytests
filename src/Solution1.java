import java.util.Arrays;

class Solution1 {


    public static void main(String[] args) {

        int n = 5;
        int[] a = {3, 4, 4, 6, 1, 4, 4};

        int[] results = solution(n, a);

        for (int i = 0; i < results.length; i++) {
            if (i == results.length - 1)
                System.out.printf("%d%n", results[i]);
            else
                System.out.printf("%d ", results[i]);
        }


    }

    public static int[] solution(int N, int[] A) {

        int[] B = new int[N];
        int BMax = 0;
        int BMaxBeforeSpecial = 0;
        int BSpecialIndex = -1;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            // If special, then mark its index and collect the max until now
            if (value == N + 1) {
                BMaxBeforeSpecial = BMax;
                BSpecialIndex = i;
            } else {
                if (++B[value - 1] > BMax)
                    BMax = B[value - 1];
            }
        }

        // Specials exist
        if (BSpecialIndex != -1) {
            Arrays.fill(B, BMaxBeforeSpecial);
            for (int i = BSpecialIndex + 1; i < A.length; i++) {
                B[A[i] - 1]++;
            }
        }

        return B;
    }

}

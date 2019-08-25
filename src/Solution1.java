import java.util.Arrays;

class Solution1 {


    public static void main(String[] args) {

        int n = 5;
        int[] a = {3, 4, 4, 6, 1, 4, 4};
//        int[] a = {3, 4, 4, 1, 4, 4, 1};

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

        for (int value : A) {
            // If special, then collect the max until now
            if (value == N + 1) {
                BMaxBeforeSpecial = BMax;
            } else {
                // if there is a special, value should be the max collected until now + 1
                if (B[value - 1] < BMaxBeforeSpecial) {
                    B[value - 1] = BMaxBeforeSpecial + 1;
                } else { // just increment current value
                    B[value - 1]++;
                }
                // update max calculation
                if (B[value - 1] > BMax)
                    BMax = B[value - 1];
            }
        }

        for (int i = 0; i < B.length; i++) {
            if (B[i] < BMaxBeforeSpecial) {
                B[i] = BMaxBeforeSpecial;
            }
        }

        return B;
    }

}

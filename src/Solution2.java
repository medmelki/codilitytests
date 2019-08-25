
class Solution2 {

    public int[] solution(int[] A, int[] B) {

        int max = 0;
        for (int value : A) {
            max = Math.max(value, max);
        }

        int[] F = new int[max + 1];

        F[0] = 1;
        F[1] = 1;

        for (int i = 2; i <= max; i++) {
            F[i] = (F[i - 1] + F[i - 2]) % (1 << 30);
        }

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = F[A[i]] % (1 << B[i]);
        }

        return result;
    }
}

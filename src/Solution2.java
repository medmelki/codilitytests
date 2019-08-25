import java.util.stream.IntStream;

public class Solution2 {

    public int[] solution(int[] a, int[] b) {


        int maxA = 0;
        for (int value : a) {
            maxA = Math.max(value, maxA);
        }

        int[] F = new int[maxA + 1];

        F[0] = 1;
        F[1] = 1;

        IntStream.rangeClosed(2, maxA)
                .forEach(i -> F[i] = (F[i - 1] + F[i - 2]) % (2 ^ 30));

        return IntStream.range(0, a.length)
                .map(i -> F[a[i]] % (2 ^ b[i]))
                .toArray();
    }
}

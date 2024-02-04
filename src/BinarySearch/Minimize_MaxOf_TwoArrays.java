package BinarySearch;

public class Minimize_MaxOf_TwoArrays {

    // GCD is used to calculate the LCM. LCM is crucial in this problem because
    // it helps us find numbers that are divisible by both divisors. Knowing the LCM
    // allows us to accurately calculate overlaps in the sets of numbers divisible by each divisor.
    private long gcd(long a, long b) {
        // The Euclidean algorithm: the GCD of two numbers also divides their difference.
        // This recursive approach finds the GCD by reducing the problem size at each step.
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    // The binary search is used to efficiently find the minimum number that can
    // have the required counts of numbers divisible by divisor1 and divisor2,
    // without and with overlap (due to LCM).
    private void bs(long l, long h, int divisor1, int divisor2, long lcm, long[] ans, int c1, int c2) {
        if (l <= h) {
            long m = (l + h) / 2;

            // a, b, and c represent counts relevant to our search:
            // a: Count of numbers up to m not divisible by divisor1 (total - divisible)
            // b: Count of numbers up to m not divisible by divisor2 (total - divisible)
            // c: Correction for double counting of numbers divisible by both (via LCM)
            long a, b, c;
            a = m - (m / divisor1);
            b = m - (m / divisor2);
            c = m - (m / divisor1) - (m / divisor2) + (m / lcm); // Inclusion-exclusion principle

            // If the set of numbers up to m includes at least c1 numbers not divisible by divisor1
            // and at least c2 numbers not divisible by divisor2, considering overlap, we've found a valid answer.
            // We then try to find a smaller m that also satisfies the conditions.
            if (a >= c1 && b >= c2 && a + b - c >= c1 + c2) {
                ans[0] = m;
                bs(l, m - 1, divisor1, divisor2, lcm, ans, c1, c2);
            } else {
                // Otherwise, look for a larger m that satisfies the conditions.
                bs(m + 1, h, divisor1, divisor2, lcm, ans, c1, c2);
            }
        }
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        // Calculate LCM using GCD. The LCM of two numbers is their product divided by their GCD.
        // This is key to finding the overlap between two sets of divisible numbers.
        long g = gcd(Math.max(divisor1, divisor2), Math.min(divisor1, divisor2));
        long l = ((long) divisor1 * (long) divisor2) / g;

        long[] ans = new long[]{1000000000}; // Initialize with a large value as we're minimizing

        // Perform binary search. The search space is between 2 and a large upper limit,
        // assuming the answer lies within this range.
        bs(2, 10000000000L, divisor1, divisor2, l, ans, uniqueCnt1, uniqueCnt2);

        return (int) ans[0];
    }
}

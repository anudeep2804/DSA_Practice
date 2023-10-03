package ArraysandHashing;

class powerofx {
    public double myPow(double x, int n) {
        // Base case: x^0 = 1
        if (n == 0) {
            return 1.0;
        }

        // If n is negative, compute the reciprocal of x and make n positive
        if (n < 0) {
            x = 1.0 / x;
            // Convert n to long to handle edge cases like n = Integer.MIN_VALUE
            return fastExpo(x, -(long)n);
        }

        return fastExpo(x, n);
    }

    private double fastExpo(double x, long n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Recursively compute half the power
        double half = fastExpo(x, n / 2);

        // If n is even, the result is half * half
        if (n % 2 == 0) {
            return half * half;
        }
        // If n is odd, the result is half * half * x
        else {
            return half * half * x;
        }
    }
}


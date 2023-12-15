package Recursion;

import java.util.HashSet;

//  https://leetcode.com/problems/string-to-integer-atoi/description/

public class StringtoInteger {

    long result=0;

        public int myAtoi(String str) {
            if (str == null || str.isEmpty()) {
                return 0;
            }

            str = str.trim();
            int sign = 1;
            int index = 0;

            if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
                sign = str.charAt(index) == '-' ? -1 : 1;
                index++;
            }

            helper(str, index, sign);

            // Apply the sign and handle overflow/underflow
            if (sign == -1) {
                result = -result;
                if (result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }

            return (int) result;
        }

        private void helper(String str, int index, int sign) {
            if (index == str.length() || !Character.isDigit(str.charAt(index))) {
                return;
            }

            int digit = str.charAt(index) - '0';

            // Check for overflow and underflow
            if (sign == 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))) {
                result = Integer.MAX_VALUE;
                return;
            }
            if (sign == -1 && (result > -(long) Integer.MIN_VALUE / 10 || (result == -(long) Integer.MIN_VALUE / 10 && digit > -(long) Integer.MIN_VALUE % 10))) {
                result = -(long) Integer.MIN_VALUE;
                return;
            }

            result = result * 10 + digit;
            helper(str, index + 1, sign);
        }
    }



    /* Iterative Solution
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) return 0;

            // Trim leading whitespaces
            str = str.trim();

            int sign = 1;
            int index = 0;
            long result = 0; // Use long to handle overflow

            // Check for sign
            if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
                sign = str.charAt(index) == '-' ? -1 : 1;
                index++;
            }

            // Convert to number and handle overflow/underflow
            while (index < str.length()) {
                char currentChar = str.charAt(index);
                if (currentChar < '0' || currentChar > '9') break; // Break if not a digit

                result = result * 10 + (currentChar - '0');

                // Overflow and underflow checks
                if (sign == 1 && result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && -result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                index++;
            }

            return (int) result * sign;
        }

*/


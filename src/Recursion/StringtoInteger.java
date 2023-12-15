package Recursion;

import java.util.HashSet;

public class StringtoInteger {

    //  https://leetcode.com/problems/string-to-integer-atoi/description/


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
    }

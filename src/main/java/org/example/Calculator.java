package org.example;



public class Calculator {
    public static int _min(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int _max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static long _sum(int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            try {
                sum = Math.addExact(sum, number);
            } catch (ArithmeticException e) {
                sum = -1;
            }
        }
        return sum;
    }

    public static long _mult(int[] numbers) {
        long mult = 1;
        for (int number : numbers) {
            if (number > Long.MAX_VALUE / mult) {
                mult = -1;
                break;
            }
            mult *= number;
        }
        return mult;
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        Tests.run_all_tests();
//    }
}
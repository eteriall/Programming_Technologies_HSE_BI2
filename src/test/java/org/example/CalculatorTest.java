package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void _min() {
        int min = Calculator._min(new int[]{1, 2, 3});
        assertEquals(min, 1);
        min = Calculator._min(new int[]{123123, 123123, 123123});
        assertEquals(min, 123123);
    }

    @Test
    void _max() {
        int max = Calculator._max(new int[]{1, 2, 3});
        assertEquals(max, 3);
        max = Calculator._max(new int[]{123123, 123123, 123123});
        assertEquals(max, 123123);
    }

    @Test
    void _sum() {
        long sum = Calculator._sum(new int[]{1, 2, 3});
        assertEquals(sum, 6);
        sum = Calculator._sum(new int[]{11, 0, 0});
        assertEquals(sum, 11);
    }

    @Test
    void _mult() {
        long mult = Calculator._mult(new int[]{1, 2, 3});
        assertEquals(mult, 6);
        mult = Calculator._mult(new int[]{2, 9, 0});
        assertEquals(mult, 0);
        mult = Calculator._mult(new int[]{9999999, 9999999, 9999999});
        assertEquals(mult, -1);
    }

    @Test
    public void test_time() throws FileNotFoundException {
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);
        System.out.println("el_c\t_min\t_max\t_sum\t_mult");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        for (int i = 1; i < 50; i++) {
            String fname = "build/resources/test/test_files/numbers_" + i + ".txt";
            int[] numbers = new int[0];
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNextInt()) {
                int[] temp = numbers;
                numbers = new int[numbers.length + 1];
                System.arraycopy(temp, 0, numbers, 0, temp.length);
                numbers[numbers.length - 1] = scanner.nextInt();
            }
            scanner.close();

            double[] time = {0, 0, 0, 0};

            long st = System.nanoTime();
            int min = Calculator._min(numbers);
            time[0] = System.nanoTime() - st;

            st = System.nanoTime();
            int max = Calculator._max(numbers);
            time[1] = System.nanoTime() - st;

            st = System.nanoTime();
            long sum = Calculator._sum(numbers);
            time[2] = System.nanoTime() - st;

            st = System.nanoTime();
            long mult = Calculator._mult(numbers);
            time[3] = System.nanoTime() - st;

            System.out.print(numbers.length + "\t");

            System.out.printf("%.9f\t", time[0] / 1_000_000_000);
            System.out.printf("%.9f\t", time[1] / 1_000_000_000);
            System.out.printf("%.9f\t", time[2] / 1_000_000_000);
            System.out.printf("%.9f\n", time[3] / 1_000_000_000);
        }

    }
}
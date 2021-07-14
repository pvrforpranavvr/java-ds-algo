package edu.ds_algo.algo.sort;

import java.util.Arrays;

public class BubbleSort {


    /**
     * Bubble sort using normal for loop.
     *
     * @param input
     * @return
     */
    private static int[] iterateAndSort(int[] input) {

        for (int i = 0; i < input.length; i++) {

            for (int j = i + 1; j < input.length; j++) {

                if (input[i] > input[j]) {

                    int temp = input[j];

                    input[j] = input[i];
                    input[i] = temp;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {

        int[] input = {5, 2, 6, 3, 1, 7};
        System.out.println(Arrays.toString(BubbleSort.iterateAndSort(input)));
    }
}

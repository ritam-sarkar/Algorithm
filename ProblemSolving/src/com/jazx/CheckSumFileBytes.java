package com.jazx;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a list of integers (fileBytes), each in the range 0 to 255, representing the bytes of a file.
 * Your task is to compute the checksum for every chunk and return a list of these checksums.
 *
 * Checksum Calculation
 * For each chunk, sum up all data bytes (exclude the header).
 * Keep only the lowest 8 bits of the sum → equivalent to sum % 256.
 * The result is the checksum for that chunk.
 * For a chunk of size 0, the checksum is 0.
 *
 * Output :
 * Return a list of integers, where each integer is the checksum of a chunk,
 * in the order the chunks appear in the file.
 *
 * [3, 44, 55, 66, 2, 110, 220]
 *
 * 3 is the chunk size , sum(44,55,66) = 165 % 256 = 165
 *
 * again 2 is header sum(110, 220) = 330 % 256 = 74
 *
 * answer is 165 ,74
 *
 * If Input is [0] answer is 0
 *
 *
 *
 */
public class CheckSumFileBytes {

    public static void main(String[] args) {
        findCheckSum(new int[]{3, 44, 55, 66, 2, 110, 220});
        findCheckSum(new int[]{0,0,0});
        findCheckSum(new int[]{0});
        findCheckSum(new int[]{0,2,10,20});

    }

    private static void findCheckSum(int[] arr) {
       List<Integer> result = new ArrayList<>();
       int i=0;
        while (i < arr.length) {
            int header = arr[i];
            int sum = 0;

            for (int j = i + 1; j <= i + header; j++) {
                if (j < arr.length) {
                    sum += arr[j];
                }
            }

            result.add(sum % 256); // Keep only lowest 8 bits
            i += 1 + header; // Move to next header
        }
       result.forEach(System.out :: println);
        System.out.println("----------end ----------");
    }

}



























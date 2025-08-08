package com.gs.hard;

import java.util.LinkedList;

/**
 * A group of students is sitting in a circle. The teacher is electing a new class president.
 * The teacher does this by singing a song while walking around the circle. After the song is
 * finished the student at which the teacher stopped is removed from the circle.
 *
 * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
 * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
 *
 * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
 *
 * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first
 * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
 * n = number of student
 * k = after how many student the teacher stop singing , means length of the song
*/
public class Election {

    public static void main(String[] args) {
        System.out.println(findLeader(4,2));
        System.out.println(findLeader(9,3));
        System.out.println(findLeader(10,3));
    }

    /**
     * The Josephus Problem
     * J(n,k) = (J(n-1,k)+k) % n
     * for n =1 J(n,k) = 0
     */
    private static int findLeader(int n , int k){
        int winner = 0; // 0-based index
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner+1; // Convert to 1-based indexing
    }
}

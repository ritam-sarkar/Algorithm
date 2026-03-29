package com.jazx;

import java.util.*;

/**
 * You are given N persons. M pairs of persons among them meet each other every day .
 * A person X is said to "know" another person Y if either X meets Y every day or there is a person Z
 * that both X and Y "know". Count all pairs of persons that do not "know" each other.
 * Input: First line contains N and M. Then follows
 * M pairs of persons who meet every day. Sample Input:
 * 6 5
 * 0 1
 * 1 2
 * 2 0
 * 3 4
 * 3 5
 * Sample Output: 9
 *
 * Leet code https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 *
 * as 0 is parent of 1 ,2 and also 0 so rank is 3
 * as 3 is parent of 4, 5 and also 3 so rank is 3
 * parent array contains parent of each node
 */
public class DisjoinSetFunctionProblem {

    public static void main(String[] args) {
      System.out.println(countPairs(6,new int[][] {{0,1},{1,2},{2,0},{3,4},{3,5}}));
      //System.out.println(countPairs(6,new int[][] {{0,1},{1,2},{2,0},{3,4},{3,5},{3,2}}));

    }
    public static long countPairs(int n, int[][] edges) {

        Disjoint ds=new Disjoint(n);
        for(int a[]:edges){
            ds.union(a[0],a[1]);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            int rank=ds.rank[ds.findParent(i)];
            ans+=n-rank;
        }
        // beacuse its a pair
        return ans/2;
    }

    static class Disjoint{
        int parent[];
        int rank[];
        public Disjoint(int n){
            parent =new int[n];
            rank=new int[n];
            Arrays.fill(rank,1);
            for(int i=0;i<n;i++){
                parent[i]=i;
            }


        }
        public int findParent(int a){
            if(parent[a]==a){
                return a;
            }
            return parent[a]= findParent(parent[a]);
        }
        public void union(int a,int b){
            int pa= findParent(a);
            int pb= findParent(b);
            if(pa!=pb){
                if(rank[pa]>=rank[pb]){
                    parent[pb]=pa;
                    rank[pa]+=rank[pb];
                }
                else{
                    parent[pa]=pb;
                    rank[pb]+=rank[pa];
                }
            }
        }
    }
}

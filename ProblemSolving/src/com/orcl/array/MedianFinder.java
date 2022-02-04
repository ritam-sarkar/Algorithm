package com.orcl.array;

import java.util.PriorityQueue;
/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

 * @author ritsarka
 *
 */
public class MedianFinder {

	 private PriorityQueue<Integer> maxQ;
	  private PriorityQueue<Integer> minQ;

	  /** initialize your data structure here. */
	  public MedianFinder() {
	    // max queue
	    maxQ = new PriorityQueue<>((a, b) -> b.compareTo(a));
	    // min queue
	    minQ = new PriorityQueue<>();
	  }

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(6);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(10);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(9);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(15);
		System.out.println(medianFinder.findMedian());

	}
	
    public void addNum(int num) {
        if (maxQ.isEmpty()) {
            maxQ.add(num);
          } else {
            if (num > maxQ.peek()) {
              minQ.add(num);
              // re-balance the queue
              if (minQ.size() > maxQ.size()) {
                maxQ.add(minQ.poll());
              }
            } else {
              // re-balance the queue
              maxQ.add(num);
              if (maxQ.size() > minQ.size()) {
                minQ.add(maxQ.poll());
              }
            }
          }
    }
    
    public double findMedian() {
        if (maxQ.size() == minQ.size()) {
          return ((double) (maxQ.peek() + minQ.peek())) / 2;
        } else if (maxQ.size() > minQ.size()) {
          return maxQ.peek();
        } else {
          return minQ.peek();
        }
      }

}

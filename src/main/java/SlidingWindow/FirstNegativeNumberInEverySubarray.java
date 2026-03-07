package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNumberInEverySubarray {

    static List<Integer> findFirstNegativeBF(int[] a, int k){
        List<Integer> ans = new ArrayList<>();
        int n = a.length; //size of the array
        for(int i=0; i<=n-k; i++){
            //it will help us to check if there are any negative elements in the array
            boolean flag = false;
            for(int j=i; j<i+k; j++){
                if(a[j] < 0) {
                    flag = true;
                    ans.add(a[j]);
                    break;
                }
            }
            if(!flag) ans.add(0);
        }

        return ans;
    }

    static List<Integer> optimizedFirstNegativeWithQueue(int[] a, int k){
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<k; i++){
            if(a[i] < 0) {
                queue.add(i);
            }
        }

        //add the first negative element from base case if not then add 0.
        if(!queue.isEmpty()){
            ans.add(a[queue.peek()]);
        } else {
            ans.add(0);
        }

        int slide = 1;
        while(slide <= a.length - k) {

            // STEP 1: CLEAN UP THE QUEUE
            // The window has moved forward by 1 position.
            // The element at the front of the queue might now be OUTSIDE the window.
            // Example: window now starts at index 2, but queue front has index 1 — that's old, remove it.
            if(!queue.isEmpty() && queue.peek() < slide) {
                queue.poll();
            }

            // STEP 2: WELCOME THE NEW ELEMENT
            // Every time the window slides, one new element enters from the right.
            // Its index is always (slide + k - 1).
            // If this new element is negative, we store its INDEX in the queue.
            // We store the INDEX (not the value) so we can later check if it's still inside the window.
            if(a[slide + k - 1] < 0) {
                queue.add(slide + k - 1);
            }

            // STEP 3: RECORD THE ANSWER FOR THIS WINDOW
            // The front of the queue always holds the index of the FIRST negative in the current window.
            // Why? Because we add indices in order, and remove them when they leave the window.
            // So queue.peek() is always the leftmost (first) negative index still inside the window.
            if(!queue.isEmpty()) {
                ans.add(a[queue.peek()]);
            }

            // If the queue is empty, there are no negative numbers in this window at all.
            if(queue.isEmpty()) {
                ans.add(0);
            }

            slide++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2,-1,23,15,-8,30};
        int k = 3; //size of Subarray
        //Total windows in an array - (n-k+1)
        //n = Length of the
        System.out.println(optimizedFirstNegativeWithQueue(a,k));
    }
}

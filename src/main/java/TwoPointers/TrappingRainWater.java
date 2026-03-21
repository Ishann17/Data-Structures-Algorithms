package TwoPointers;

import java.util.Arrays;

public class TrappingRainWater {

    public static int trapBruteForce(int[] height) {

        // This will store the total units of water trapped across all positions
        int water = 0;

        // Visit every index — water can potentially sit at each position
        for (int i = 0; i < height.length; i++) {

            // The highest bar to the left of i (including i itself)
            // This acts as the left wall for position i
            int leftMax = 0;

            // The highest bar to the right of i (including i itself)
            // This acts as the right wall for position i
            int rightMax = 0;

            // Scan everything from start up to i to find the tallest left wall
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(height[j], leftMax);
            }

            // Scan everything from i to end to find the tallest right wall
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }

            // Water at position i is limited by the shorter of the two walls
            // Subtract the bar height at i — that space is occupied by the bar itself
            // min(leftWall, rightWall) - barHeight = water units at this position
            water += Math.min(leftMax, rightMax) - height[i];
        }

        // Return total water accumulated across all positions
        return water;
    }

    public static int trapWaterUsingArrays(int[] height) {

        // This will store the total units of water trapped across all positions
        int water = 0;

        // leftMax[i] = tallest bar from index 0 to i (the left wall for position i)
        int[] leftMax = new int[height.length];

        // rightMax[i] = tallest bar from index i to n-1 (the right wall for position i)
        int[] rightMax = new int[height.length];

        // Fill leftMax left to right
        // For each position, the left wall is either the current bar
        // or the tallest bar seen so far to the left — whichever is greater
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                // No bar to the left, so the bar itself is the left wall
                leftMax[i] = height[i];
            } else {
                // Extend the previous leftMax by comparing with current bar
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
        }

        // Fill rightMax right to left
        // For each position, the right wall is either the current bar
        // or the tallest bar seen so far to the right — whichever is greater
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                // No bar to the right, so the bar itself is the right wall
                rightMax[i] = height[i];
            } else {
                // Extend the previous rightMax by comparing with current bar
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
        }

        // For every position, water = shorter wall - bar height at that position
        // The shorter wall is the bottleneck — water cannot rise above it
        for (int i = 0; i < height.length; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    public static int trapOptimized(int[] height) {

        // Total water trapped across all positions
        int water = 0;

        // Two pointers starting from both ends of the array
        int left = 0, right = height.length - 1;

        // Track the tallest bar seen so far from each side
        // Initialize with the first and last bar heights
        int leftMax = height[left], rightMax = height[right];

        // Move pointers toward each other until they meet
        while (left < right) {

            if (leftMax < rightMax) {
                // Left wall is the bottleneck — we don't need to know exact rightMax
                // Move left pointer inward first, then update leftMax
                left++;
                leftMax = Math.max(leftMax, height[left]);

                // Water at this position = left wall height - bar height
                // leftMax >= height[left] always, so this never goes negative
                water += leftMax - height[left];

            } else {
                // Right wall is the bottleneck — process from the right side
                // Move right pointer inward first, then update rightMax
                right--;
                rightMax = Math.max(rightMax, height[right]);

                // Water at this position = right wall height - bar height
                water += rightMax - height[right];
            }
        }

        return water;
    }

    public static void main(String[] args) {

        int[] a = {4,2,0,3,2,5};
        //System.out.println(trapOptimized(a));
        trapWaterUsingArrays(a);

    }
}

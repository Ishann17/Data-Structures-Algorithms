package SlidingWindow;



public class MaxSumSubArray {


    static int bruteForceMaxSum(int[] a, int k){
        int maxSum = 0;

        for (int i = 0; i <= a.length - k; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++){
                currentSum += a[j];
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[] a = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(bruteForceMaxSum(a,k));
    }
}

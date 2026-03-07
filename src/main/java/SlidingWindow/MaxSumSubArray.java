package SlidingWindow;



public class MaxSumSubArray {

    static int bruteForceMaximumSumSubArray(int[] a, int k){

        int maxSum = 0;
        for(int i=0; i<a.length-k; i++){
            int sum = 0;
            for(int j=i; j<i+k; j++){
                sum += a[j];
            }
            if(maxSum < sum){
               maxSum = sum;
            }
        }

        return maxSum;
    }

    static int slidingWindowApproach(int[] a, int k){
        int result = 0;
        int low=0, high = k-1;

        for(int i=low; i<=high; i++){
            result += a[i];
        }

        int windowSum = result;
        while(high < a.length){

            result = Math.max(windowSum, result);

            low++;
            high++;

            //Check if high is out of index
            if(high == a.length){
                break;
            }

            windowSum = windowSum - a[low-1] + a[high];
        }
        return result;
    }

    static int slidingWindowApproachMyWay(int[] a, int k){
        int result = 0;
        int low=0, high = k-1;

        //Calculate the firstWindow Sum and treat as the base case
        for(int i=low; i<=high; i++){
            result += a[i];
        }

        int slide = 1;
        int windowSum = result;

        while(slide <= a.length-k){

            int sum=0;
            sum = windowSum - a[slide-1] + a[slide+k-1];
            windowSum = sum;

            result = Math.max(result, sum);
            slide++;

        }
        return result;
    }



    public static void main(String[] args) {
        int[] a = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(slidingWindowApproachMyWay(a,k));
    }
}

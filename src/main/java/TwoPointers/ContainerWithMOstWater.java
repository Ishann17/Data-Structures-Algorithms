package TwoPointers;

public class ContainerWithMOstWater {

    static int maxArea(int[] arr){
        int maxArea = -1;
        int left = 0, right = arr.length - 1;

        while(left < right){
           maxArea = Math.max(maxArea, Math.min(arr[left], arr[right]) * (right - left));
            //Moving pointers - We need to move one pointer to always find the next taller height and re-calculate the area again.
            if(arr[left] < arr[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}

package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWhoseSumIsZero {

    static List<List<Integer>> findTriplets(int[] nums){

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            //Making sure my fixed point is always unique
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(nums[left] + nums[right] == -nums[i]){
                    List<Integer> triplets = List.of(nums[left], nums[right], nums[i]);
                    result.add(triplets);
                    left++;
                    right--;
                    //making sure my pointers are always at a new value
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }

                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int a[] = {-1,0,1,2,-1,-4};
        System.out.println(findTriplets(a));
    }
}

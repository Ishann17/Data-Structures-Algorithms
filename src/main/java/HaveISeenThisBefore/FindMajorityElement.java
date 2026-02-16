package HaveISeenThisBefore;
//Link : https://www.geeksforgeeks.org/problems/majority-element-1587115620/1
public class FindMajorityElement {

    public static int majorityElement(int[] a){
        //Boyer-Moore Voting Algorithm
        int candidate = 0, count = 0;
        for(int num : a){
            if(count == 0){
                candidate = num;
            }
            if(candidate == num){
                count++;
            }
            else{
                count--;
            }
        }
        /*int n = a.length;
        int actualCount = 0;
        for(int i:a){
            if(candidate == i) actualCount ++;
        }
        return (actualCount > n/2) ? candidate : -1;*/

        return candidate;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 3, 5};
        System.out.println(majorityElement(a));
    }
}

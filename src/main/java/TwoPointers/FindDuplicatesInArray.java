package TwoPointers;

//Solve it using Time - O(n) Space - O(1)
public class FindDuplicatesInArray {

    static int duplicate(int[] a){
        int duplicate = 0;
        int slow=0, fast=0;
        while(true){
            slow = a[slow];
            fast = a[fast];
            fast = a[fast];

            if(slow == fast){
                break;
            }
        }
        slow = 0;
        while(slow != fast){
            slow = a[slow];
            fast = a[fast];
        }


        return slow;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,2};
        System.out.println(duplicate(a));
    }
}

package TwoPointers;


//https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
public class MergeWithoutExtraSpace {

    //DO NOT USE EXTRA SPACE
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        while (a[n-1] > b[0]){

                //swap them
                int temp = b[0];
                b[0] = a[n-1];
                a[n-1] = temp;
                // Fix a[] after swap - move last element to correct position
                int lastOfA = a[n-1];
                int k = n-2;
                while(k>=0 && a[k] > lastOfA){
                    a[k+1] = a[k];
                    k--;
                }
                a[k+1] = lastOfA;

                // Fix b[] after swap - move first element to correct position
                int firstOfB = b[0];
                int l = 1;
                while(l < m && b[l] < firstOfB){
                    b[l-1] = b[l];
                    l++;
                }
                b[l-1] = firstOfB;

        }

    }

    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10};
        int[] b = {2, 3};

    }
}

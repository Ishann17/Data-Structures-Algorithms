package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Fruit_Into_Baskets {


    public static int totalFruit(int[] fruits) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int low=0;
        int high=0;

        for(high=0; high<fruits.length; high++){

            //Store the fruit into the map
            freqMap.put(fruits[high], freqMap.getOrDefault(fruits[high], 0)+1);

            //check size of the map
            if(freqMap.size() <= 2){
                int len = high-low+1;
                maxLength = Math.max(len, maxLength);
            }

            if(freqMap.size() > 2){
                Integer currentCount = freqMap.get(fruits[low]);
                //decrement the fruit while shrinking the window
                freqMap.put(fruits[low], currentCount-1);

                if(currentCount-1<=0){
                    freqMap.remove(fruits[low]);
                }
                low++;
            }


        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] fruits = {1,1,1,1};

        System.out.println(totalFruit(fruits));

    }
}

package Done;

import java.util.ArrayList;
import java.util.List;

public class serviceNow {

    public static void main(String[] args){

        int[] arr = {1,3,4,6,2};
        int min=arr[0];
        int secondMin = Integer.MAX_VALUE;

        for(int i=1;i<arr.length;i++){
            min = min<=arr[i]?min:arr[i];

            if(arr[i]<=secondMin){
                secondMin=arr[i];
            }
        }
        System.out.println("min num second :- "+secondMin);
    }
}

package Done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class missingNum {

    public static void main(String[] args){

        int[] arr = {2,1,4,6,5,8,9};
        List<Integer> ans = missing(arr);
    }

    public static List<Integer> missing(int[] num){
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> li = new ArrayList<Integer>();
        Arrays.sort(num);
        for(int i : num){
            li.add(i);
        }
    for(int i=1;i<=num[num.length-1];i++){
            if(!(li.contains(i))){
                System.out.println(i);
                res.add(i);
            }
        }
    return res;
    }
}

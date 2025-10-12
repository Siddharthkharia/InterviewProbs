import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.util.Arrays.asList;

public class airbnb {

    static int addNumbers(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(0,2,4);
        List<Integer> l2 = Arrays.asList(1,2,5);
        List<Integer> l3 = Arrays.asList(2,4,5);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        int sum = maxInterest(list);
        System.out.println(sum);
//   List<List<Integer>> experiences = asList(
//     asList(2, 5, 5),
//     asList(3, 6, 6),
//     asList(5, 10, 2),
//     asList(4, 10, 8),
//     asList(8, 9, 5),
//     asList(13, 14, 1),
//     asList(13, 17, 5),
//     asList(14, 16, 8)
//   );


    }

    public static int[] dp;

    public static int maxInterest (List<List<Integer>> activities){
        dp = new int[activities.size()];
        Arrays.fill(dp, -1);

        int max =0;
        activities.sort(Comparator.comparingInt(a->a.get(0)));
        int index=0;
        max = calMax(activities, max, index);


        return max;
    }

    private static int calMax(List<List<Integer>> activities, int max, int index) {

        if(index>=activities.size()){
            return max;
        }
        if(dp[index]!=-1){
            return dp[index];
        }


        int currentEndTime = activities.get(index).get(1);
        int currentInterest = activities.get(index).get(2);

        int nextActivity = binarySearch(activities, currentEndTime);
        System.out.println("index of NextActivity :- " + nextActivity);

        max = Math.max(
                calMax(activities,max+currentInterest,nextActivity),
                calMax(activities, max, index+1)
        );
        dp[index]=max;
        return max;
    }

    private static int binarySearch(List<List<Integer>> activities, int currentEndTime) {
        int left=0;
        int right = activities.size();
        int nextIndex =0;
        int[] startTime= new int[activities.size()];
        for(int i =0; i<activities.size();i++){
            startTime[i]= activities.get(i).get(0);
        }
        while(left<right){
            int mid = left*(right-left+1)/2;
            if(currentEndTime<=startTime[mid]){
                nextIndex = mid;
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        return nextIndex;
    }
}







//
//    You will be scheduling a day of travel for your friends. Each experience has a start time, end time, interest level.
//        An interest level is defined by non-negative number. Higher the number means more interest.
//        You want to schedule a day maximizing the total interest level.
//        Given a list of tuples that represents start time, end time, and interest level, schedule experiences maximizing interest levels without any conflict. Return max interest level possible
//
//        experiences = [
//        [0,2,4],
//        [1,2,5],
//        [2,4,5],
//        [3,4,5]
//        [4,4,5]
//        ]
//
//        Approach 1 :
//        1. sort based on start time.
//        2. choose or not choose recursively.
//
//        List<List<Integer>> activities
//
//        sort it based on my start time
//
//
//        next activity can only be the one that is having startime >= endtime
//
//        total =0
//        choices if m selecting it or not
//
//        Time complexity - O(NlogN) N: no of elements
//        Space complexity


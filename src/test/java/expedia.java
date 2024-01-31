import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class expedia {

    public static void main(String[] args){
        Integer[] teamA = {1,2,3};
        Integer[] teamB = {2,4};
        System.out.println(count(Arrays.asList(teamA),Arrays.asList(teamB)));
    }

    public static List<Integer> count(List<Integer> teamA, List<Integer> teamB){
        List<Integer> countList = new ArrayList<>();
        Collections.sort(teamA);
        Collections.sort(teamB);

        for(Integer scoreB : teamB){
            countList.add(search(teamA,scoreB)+1);
        }

        return countList;
    }

    public static int search(List<Integer> scoreList, int score) {

        if (scoreList.contains(score)) {
            return scoreList.indexOf(score);
        } else {
            int l=0;
            int r=scoreList.size()-1;
            int mid;
            int closestInd=-1;
            while(l<=r){
                mid=(l+r)/2;
                if (scoreList.get(mid)<score){
                    closestInd=mid;
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            return closestInd;
        }
    }

}

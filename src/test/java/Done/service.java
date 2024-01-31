package Done;

import org.apache.poi.ss.formula.functions.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class service {

    public static void main(String[] args){
        String s= "I am in Servicenow interview today";

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].length()-1;j>=0;j--){
                sb.append(arr[i].charAt(j));
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}

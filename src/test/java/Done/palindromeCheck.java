package Done;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class palindromeCheck {

    public static void main(String[] args){

        String str = "abaa";
        String str2= "";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("Aba"));
        System.out.println(isPalindrome("abc12abc"));
        System.out.println(isPalindrome("a.%.a"));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("paragraph having special chars." +
                "\nThe asdasdahj b%%4$3 123"));
        System.out.println(isPalindrome("123321"));
        System.out.println(isPalindrome("abc d"));


        int[]  arr ={1,2,3,4};
        int sum =5;

    }

    public static Boolean isPalindrome(String s){
        s=s.toLowerCase(Locale.ROOT);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void twoSumNum(int[] nums, int target){

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length-1;j++){
                if(nums[i]+nums[j]==target){
                    int[] temparr = {i,j};
                }
            }
        }
//        return null;


        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(target-nums[i],nums[i]);
        }

        map.remove(5);

    }
    WebDriver oDriver= new ChromeDriver();

}

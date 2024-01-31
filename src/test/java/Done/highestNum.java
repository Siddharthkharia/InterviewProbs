package Done;

public class highestNum {

    public static void main(String[] args){
        int[] arr = { 20, 100, 55, 48, 77, 60, 48, 80, 90, 30, 50 };
        System.out.println(highest(arr,3));
    }

    public static int highest(int[]arr, int limit){
        for (int i=0;i<arr.length-1;i++){
            if(i==limit){
                break;
            }
            for(int j=i+1;j< arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr[limit-1];
    }

}

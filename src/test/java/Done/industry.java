package Done;

public class industry {

    public static void main(String[] args){

        String[] arr = {"flower","flow","flight"};

        int size=0;
        int ind = 0;
        for (int i=0;i<arr.length;i++){
            if(size<=arr[i].length() && size!=0){
                size= arr[i].length();
                ind=i;
            }
        }
        int fin=0;
        StringBuilder fina = new StringBuilder();

        for (int j=0;j<size;j++){
            StringBuilder checker = new StringBuilder();
            checker.append(arr[ind].charAt(j));
            for (int i=0;i< arr.length;i++) {
                if (checker.toString() != arr[i].substring(0, i)) {
                    fin = i - 1;
                    break;
                }
            }
            fina.append(arr[ind].charAt(j));
        }
    }
}

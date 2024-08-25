import java.util.Arrays;

public class P100394 {
    public static void main(String[] args) {
//        {12,21,5387,8357,400,4,11,11,11,8356,23,320,123456,213456}
        int nums[] = {12,21,5387,8357,400,4,11,11,11,8356,23,320,123456,213456,11,100000,1};
        int cases = 0;
        for (int i = 0; i < nums.length; i++) {
//            System.out.println(Arrays.toString(digit1));
            for (int j = i+1; j < nums.length ; j++){
                cases += check(nums[i], nums[j]);
//                System.out.println(Arrays.toString(digit2));
            }
        }
        System.out.println(cases);
    }

    public static int[] digits(int num){
        int[] digit = new int[6];
        for (int i = digit.length-1; i >= 0; i--){
            digit[i] = (int) ((num % Math.pow(10, i + 1)) / Math.pow(10, i));
        }
        return digit;
    }

    public static void swap(int[] array,int i, int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static int check(int num1, int num2){
        if (num1 == num2) return 1;
        int[] digit1 = digits(num1);
        int[] digit2 = digits(num2);
        int i = 0;
        while (i < digit1.length ){
            if (digit1[i] == 0) i++;
            else if (digit1[i] == digit2[i]){
                i++ ;
            }
            else if (digit1[i] != 0){
                for (int j = 0; j < digit2.length; j++){
                    if (digit1[i] == digit2[j] && digit1[j] == digit2[i] && i != j){
                        swap(digit2, i, j);
                        if (Arrays.equals(digit1, digit2)) return 1;
                    }
                }
                i++;
            }
            ;
        }
        return 0;
    }
}


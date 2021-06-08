package Array;

public class ArrayTwoD {
    static int hourglassSum(int[][] arr) {
        int count = -63;
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                if(sum > count){
                    count = sum;
                }
            }
        }
        return count;
    }


}

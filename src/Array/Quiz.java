package Array;

public class Quiz {
//    Given a matrix of 1s and 0s,
//    return the number of “islands”
//    in the matrix. A 1 represents island and 0
//    represents water, so an island is a group of 1s
//    that are neighboring whose perimeter is surrounded by
//    water. For example, this matrix has 4 islands
//            1 0 0 0 0
//            0 0 1 1 0
//            0 1 1 0 0
//            0 0 0 0 0
//            1 1 0 0 1
//            1 1 0 0 1

    public static int countIsland(int[][] arr){
        if(arr == null || arr.length <= 0 ){
            return  0;
        }
        int islands = 0;
        for(int i = 0; i<= arr.length; i++){
            for(int j = 0; j <= arr[i].length; j++){
                if(arr[i][j] == '1'){
                    islands += dfc(arr, i ,j);
                }
            }
        }
        return islands;
    }

    private static int dfc(int[][] arr, int i, int j) {
        if(i == 0 || arr.length <= 0 || j == 0 || j >= arr[i].length){
            return  0;
        };
        arr[i][j] = '0';
        dfc(arr, i + 1, j);
        dfc(arr, i - 1, j);
        dfc(arr, i, j + 1);
        dfc(arr, i, j - 1);
        return  1;
    }
}

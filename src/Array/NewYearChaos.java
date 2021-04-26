package Array;

public class NewYearChaos {
    private static  void  minimumBribe(int[] arr){
        int swapCount = 0;
        for(int i = arr.length -1; i>=0; i--){
            if(arr[i] != i + 1){
                if(((i-1) >= 0) && arr[i-1] == (i + 1)){
                    swapCount++;
                    swap(arr, i, i-1);
                }
                if((i - 2) >= 0 && arr[i - 2] == (i + 1)){
                    swapCount += 2;
                    swap(arr, i - 2, i-1);
                    swap(arr, i, i -1);
                }
                else {
                    System.out.println("Too chaotic");
                }
                return;
            }
        }


    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

}

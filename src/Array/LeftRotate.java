package Array;

public class LeftRotate {
  static int[] RotLeft(int[] a, int d) {
        int n = a.length;
        int[] NewArray = new int[n];

        for(int oldArray = 0; oldArray<n; oldArray++){
            int newIndex = (oldArray + n - d)%n;
            NewArray[newIndex] = a[oldArray];
        }
        return NewArray;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        LeftRotate leftRotate = new LeftRotate();
        System.out.println();
    }
}

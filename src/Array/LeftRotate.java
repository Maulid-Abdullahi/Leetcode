package Array;public class LeftRotate {
    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int[] NewArray = new int[n];

        for(int oldArray = 0; oldArray<n; oldArray++){
            int newIndex = (oldArray + n - d)%n;
            NewArray[newIndex] = a[oldArray];
        }
        return NewArray;
    }
}

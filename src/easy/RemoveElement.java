package easy;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int length=A.length;
        if(length==0) return 0;
        int i=0;
        for(int j=0; j<length; j++)
        {
            if(A[j]!=elem)
            {
                A[i]=A[j];
                i++;
            }
        }
        if(i<length) A[i]='\0';
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,5};
        RemoveElement removeElement = new RemoveElement();
       // System.out.println(removeElement.removeElement(arr, 2));
        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeElement.removeElement(arr, 3);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }


    }
}

package easy;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;

        int hayStack = haystack.length();
        int Needle = needle.length();
        if(hayStack < Needle)
            return -1;
        for(int i=0; i<=hayStack - Needle; i++){
            int j;
            for(j = 0; j<Needle; j++){
                if(haystack.charAt( i + j) != needle.charAt(j))
                    break;
            }
            if( j == Needle)
                return i;

        }
        return -1;

    }

    public static void main(String[] args) {
        ImplementstrStr implementstrStr = new ImplementstrStr();
        System.out.println(implementstrStr.strStr("TeacherTech", "Tech"));
    }
}

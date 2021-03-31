package easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String trimS = s.trim();
        int t = trimS.length();
        int start = 0;

        for(int i = start; i<trimS.length(); i++){
            if(trimS.charAt(i) == ' ')
                return start;
            else start ++;
        }
        return start;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String k = "Hello World";
        System.out.println(lengthOfLastWord.lengthOfLastWord(k));
    }
}

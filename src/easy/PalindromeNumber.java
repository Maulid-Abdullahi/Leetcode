package easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int compare = x;

        while(x > 0){
            int digit = x % 10;
            reverse = reverse * 10 +  digit;
            x /= 10;
        }
        if(compare == reverse){
            return true;
        }
        else{
            return false;
        }

    }
    public static void main(String[] args) {

        boolean Reverse = new PalindromeNumber().isPalindrome(121);
        System.out.println("Palindrome Number " + Reverse);
    }
}

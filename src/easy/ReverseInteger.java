package easy;

public class ReverseInteger {
    public int reverseIntegers(int num){
        //two integers, reversed, prev_reversed-num
        //while loop
        //123 / 10, 12.3
        //reversed * 10 + digit(3)
        int reversed  = 0;
        int prev_rev_num = 0;
        while (num != 0){
            int digit  = num % 10;
            reversed  = reversed * 10 + digit;
            if((reversed - digit)/10 != prev_rev_num){
                return  0;
            }
            prev_rev_num = reversed;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int Reverse = new ReverseInteger().reverseIntegers(12345);
        System.out.println("reversed Integer " + Reverse);
    }
}

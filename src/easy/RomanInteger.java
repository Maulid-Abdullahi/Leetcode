package easy;

public class RomanInteger {
    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    public int romanToInt(String s) {
        int total = 0;
        String x = s;

        for(int i=0; i<x.length(); i++){
            int s1 = value(x.charAt(i));
            if(i+1 < x.length()){
                int s2 = value(x.charAt(i+1));
                if(s1 >= s2){
                    total = total + s1;
                }
                else{
                    total = total -s1;
                }
            }
            else{
                total = total + s1;
            }
        }

        return total;

    }

    public static void main(String[] args) {
        RomanInteger ob = new RomanInteger();
        String val = "MCMXCIV";
        System.out.println(ob.romanToInt(val));
    }

}

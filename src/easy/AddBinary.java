package easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        // pad zeros
        if(a.length()>b.length()){
            int dif1=a.length()-b.length();
            for(int i=0;i<dif1;i++){
                b="0"+b;
            }
        }else{
            int dif2=b.length()-a.length();
            for(int i=0;i<dif2;i++){
                a="0"+a;
            }
        }

        // add with carry
        String sum=new String("");
        int carry=0;
        for(int j=a.length()-1;j>=0;j--){
            String temp_a=""+a.charAt(j);
            String temp_b=""+b.charAt(j);
            int temp=Integer.parseInt(temp_a)+Integer.parseInt(temp_b)+carry;
            if(temp>=2){
                carry=1;
                sum=temp-2+""+sum;
            }else{
                carry=0;
                sum=temp+""+sum;
            }
        }
        if(carry==1) sum="1"+sum;
        return sum;
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
    }
}

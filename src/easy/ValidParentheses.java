package easy;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        else{
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i<s.length(); i++){
                char current = s.charAt(i);
                if(current == '(' || current =='{' || current == '['){
                    stack.push(current);
                }else {
                    if(stack.isEmpty()){
                        return false;
                    }
                    char peekChar = stack.peek();
                    if((current == ')' && peekChar != '(') ||
                            (current == '}' && peekChar != '{') ||
                            (current == ']' && peekChar != '[')){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(stack.empty()){
                return true;
            }
            else{
                return false;
            }
        }


    }



    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("[]"));
    }
}

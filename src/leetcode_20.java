import java.util.Stack;

public class leetcode_20 {
    public static boolean isValid(String s) {
        if(s.length()%2!=0)
            return false;
        Stack<Character> stack=new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else{
                if(stack.empty())
                    return false;
                Character temp=stack.pop();
                if(!((temp=='('&&c==')')||(temp=='{'&&c=='}')||(temp=='['&&c==']')))
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        System.out.println(isValid("()"));
    }
}

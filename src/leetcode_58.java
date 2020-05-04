public class leetcode_58 {
    public boolean isAlphabet(char c){
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }

    public int lengthOfLastWord(String s) {
        int count=0;
        boolean find=false;
        for(int i=s.length()-1;i>=0;i--){
            if(find&&isAlphabet(s.charAt(i)))
                break;
            if(isAlphabet(s.charAt(i))){
                find=true;
                count++;
            }
        }
        return count;
    }
}

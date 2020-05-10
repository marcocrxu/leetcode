public class OneBitCharacter {
    public static boolean isOneBitCharacter(int[] bits) {
        for(int i=0;i<bits.length;i++){
            if(bits[i]==1) {
                i++;
                if(i>= bits.length)
                    return false;
            }
            else if(bits[i]==0&&i==bits.length-1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1,1,1,0}));
    }
}

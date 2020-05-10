
public class LCP3 {
    static int r_num;
    static int u_num;
    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        u_num=0;r_num=0;
        for(char temp:command.toCharArray()){
            if(temp=='U')
                u_num++;
            else
                r_num++;
        }
        if(isOn(command,x,y)) {
            if(obstacles==null)
                return true;
            for (int[] temp : obstacles) {
                if (temp[0] <= x && temp[1] <= y) {
                    if (isOn(command, temp[0], temp[1])) {
                        return false;
                    }
                }
            }
            return true;
        }
        else
            return false;

    }

    public static boolean isOn(String command,int x,int y) {
        if(Math.abs(x/r_num-y/u_num)>1)
            return false;
        int times=Math.min(x/r_num,y/u_num);
        x-=times*r_num;
        y-=times*u_num;
        int temp_x,temp_y;
        temp_x=0;temp_y=0;
        if(temp_x==x&&temp_y==y)
            return true;
        for(char temp:command.toCharArray()){
            if(temp=='U'){
                temp_y++;
                if(temp_x==x&&temp_y==y)
                    return true;
            }
            else{
                temp_x++;
                if(temp_x==x&&temp_y==y)
                    return true;
            }
        }
        return false;
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input.toString();
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args){
        System.out.println(robot("URRURRR",new int[][]{new int[]{7, 7}, new int[]{0, 5},new int[]{2, 7},new int[] {8, 6}, new int[]{8, 7},new int[] {6, 5}, new int[]{4, 4}, new int[]{0, 3},new int[] {3, 6}},
        4915,
        1966));
    }

}

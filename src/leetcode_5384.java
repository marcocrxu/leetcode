import java.util.ArrayList;
import java.util.List;

public class leetcode_5384 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res=new ArrayList<>();
        int max=0;
        for (int candy : candies) {
            if (candy > max)
                max = candy;
        }
        for (int candy : candies) {
            if (candy + extraCandies >= max)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}

public class ListType {
    public static int numberOfList(int n,int k,int l,int r){
        int nl=n*l;int nr=n*r;
        int start_z=nl%k==0?nl:(nl/k+1)*k;
        int start_num=1;
        for(int i=0;i<n;i++){
            start_num*=(start_z-nl+i+1)%(1e9+7);
        }
        int res=start_num;
        int num=start_num;
        for(int z=start_z+k;z<=nr;z+=k){
            for(int i=z+n-k+1;i<z+n;i++){
                num*=i;
            }
            for(int i=z+1;i<=z+k;i++){
                num/=i;
            }
            res+=num;
            res= (int) (res%(1e9+7));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfList(9,1,1,3));
    }
}

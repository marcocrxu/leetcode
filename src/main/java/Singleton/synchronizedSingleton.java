package Singleton;

public class synchronizedSingleton {
    private static synchronizedSingleton instance;

    private synchronizedSingleton(){};

    public static synchronized synchronizedSingleton getInstance(){
        if(instance==null)
            instance=new synchronizedSingleton();
        return instance;
    }
}

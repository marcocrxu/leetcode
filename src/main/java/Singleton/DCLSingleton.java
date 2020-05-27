package Singleton;

public class DCLSingleton {
    private static DCLSingleton instance;

    private DCLSingleton(){};

    public DCLSingleton getInstance(){
        synchronized (DCLSingleton.class) {
            if (instance==null)
                instance=new DCLSingleton();
        }
        return instance;
    }
}

package Singleton;

import jdk.internal.loader.AbstractClassLoaderValue;

public class SubClassSingleton {
    private static class Singleton{
        public static SubClassSingleton instance=new SubClassSingleton();
    }
    
    private SubClassSingleton(){};

    public static SubClassSingleton getInstance(){
        return Singleton.instance;
    }


}

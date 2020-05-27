## 为什么需要Singleton

- 避免一个对象需要重复使用的时候，JVM重复创建销毁所带来的损耗，减少了内存的开销

- 避免对资源的重复占用

## 什么是Singleton

- Singleton是单例模式，这个类他只有一个对象可以通过getInstance方法获得（也可能是别的方法），获得的对象是固定的，是一个静态的对象。

- Singleton类的构建函数是私有的，只能够被自己所调用

- Singleton类不可以被继承

##### After All
##### ***Singleton只有一个实例，且只能被自己所创造，且必须要为别的类提供一个获得这个实例的方法***

## 创建Singleton的方式

1. ##### BasicSingleton——详见BasicSingleton.java 
   
   懒汉模式：yes
   
   线程安全：no
   
   ```java
    public class BasicSingleton { 
       private static BasicSingleton instance;

       private BasicSingleton(){}

       public static BasicSingleton getInstance(){
           /*在这里是线程不安全的，因为可能有多个线程进入到下面的创建过程中，就违背了Singleton的本意*/
           if(instance==null)
               instance=new BasicSingleton();
           return instance;
       }
    }
   ```

2. ##### synchronizedSingleton——在BasicSingleton的基础上增加synchronized来保证线程安全
   
    懒汉模式：yes
    
    线程安全：yes
    
    ```java
    public class synchronizedSingleton {
        private static synchronizedSingleton instance;
    
        private synchronizedSingleton(){};
        /*加上synchronized来保证线程安全*/
        public static synchronized synchronizedSingleton getInstance(){
            if(instance==null)
                instance=new synchronizedSingleton();
            return instance;
        }
    }
    ```
3. ##### LazySingleton——事先初始化好
   
    懒汉模式：no
    
    线程安全：yes
    
    ```java
    public class LazySingleton {
        /*事先初始化好的instance*/
        private static LazySingleton instance=new LazySingleton();
    
        private LazySingleton(){};
    
        public static LazySingleton getInstance(){
            return instance;
        }
    }
    ```
4. ##### DCLSingleton——Double Checked Locking 双充锁验证
   
    懒汉模式：yes
    
    线程安全：yes
    
    ```java
    public class DCLSingleton {
        private static DCLSingleton instance;
    
        private DCLSingleton(){};
    
        public DCLSingleton getInstance(){
            /*只在判断有没有初始化的时候加锁*/
            synchronized (DCLSingleton.class) {
                if (instance==null)
                    instance=new DCLSingleton();
            }
            return instance;
        }
    }
    ```
5. ##### SubClassSingleton——在子类里面创建自己的实例
   
    懒汉模式：yes
    
    线程安全：yes
    
    ```java
    public class SubClassSingleton {
        /*在子类里面创建自己的实例，只有在getInstance被调用的时候，才会加载这个子类*/
        private static class Singleton{
            public static SubClassSingleton instance=new SubClassSingleton();
        }
        
        private SubClassSingleton(){};
    
        public static SubClassSingleton getInstance(){
            return Singleton.instance;
        }
    }
    ```
6. ##### enum方式——待填坑
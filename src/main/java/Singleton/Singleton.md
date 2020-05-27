## Ϊʲô��ҪSingleton

- ����һ��������Ҫ�ظ�ʹ�õ�ʱ��JVM�ظ�������������������ģ��������ڴ�Ŀ���

- �������Դ���ظ�ռ��

## ʲô��Singleton

- Singleton�ǵ���ģʽ���������ֻ��һ���������ͨ��getInstance������ã�Ҳ�����Ǳ�ķ���������õĶ����ǹ̶��ģ���һ����̬�Ķ���

- Singleton��Ĺ���������˽�еģ�ֻ�ܹ����Լ�������

- Singleton�಻���Ա��̳�

##### After All
##### ***Singletonֻ��һ��ʵ������ֻ�ܱ��Լ������죬�ұ���ҪΪ������ṩһ��������ʵ���ķ���***

## ����Singleton�ķ�ʽ

1. ##### BasicSingleton�������BasicSingleton.java 
   
   ����ģʽ��yes
   
   �̰߳�ȫ��no
   
   ```java
    public class BasicSingleton { 
       private static BasicSingleton instance;

       private BasicSingleton(){}

       public static BasicSingleton getInstance(){
           /*���������̲߳���ȫ�ģ���Ϊ�����ж���߳̽��뵽����Ĵ��������У���Υ����Singleton�ı���*/
           if(instance==null)
               instance=new BasicSingleton();
           return instance;
       }
    }
   ```

2. ##### synchronizedSingleton������BasicSingleton�Ļ���������synchronized����֤�̰߳�ȫ
   
    ����ģʽ��yes
    
    �̰߳�ȫ��yes
    
    ```java
    public class synchronizedSingleton {
        private static synchronizedSingleton instance;
    
        private synchronizedSingleton(){};
        /*����synchronized����֤�̰߳�ȫ*/
        public static synchronized synchronizedSingleton getInstance(){
            if(instance==null)
                instance=new synchronizedSingleton();
            return instance;
        }
    }
    ```
3. ##### LazySingleton�������ȳ�ʼ����
   
    ����ģʽ��no
    
    �̰߳�ȫ��yes
    
    ```java
    public class LazySingleton {
        /*���ȳ�ʼ���õ�instance*/
        private static LazySingleton instance=new LazySingleton();
    
        private LazySingleton(){};
    
        public static LazySingleton getInstance(){
            return instance;
        }
    }
    ```
4. ##### DCLSingleton����Double Checked Locking ˫������֤
   
    ����ģʽ��yes
    
    �̰߳�ȫ��yes
    
    ```java
    public class DCLSingleton {
        private static DCLSingleton instance;
    
        private DCLSingleton(){};
    
        public DCLSingleton getInstance(){
            /*ֻ���ж���û�г�ʼ����ʱ�����*/
            synchronized (DCLSingleton.class) {
                if (instance==null)
                    instance=new DCLSingleton();
            }
            return instance;
        }
    }
    ```
5. ##### SubClassSingleton�������������洴���Լ���ʵ��
   
    ����ģʽ��yes
    
    �̰߳�ȫ��yes
    
    ```java
    public class SubClassSingleton {
        /*���������洴���Լ���ʵ����ֻ����getInstance�����õ�ʱ�򣬲Ż�����������*/
        private static class Singleton{
            public static SubClassSingleton instance=new SubClassSingleton();
        }
        
        private SubClassSingleton(){};
    
        public static SubClassSingleton getInstance(){
            return Singleton.instance;
        }
    }
    ```
6. ##### enum��ʽ���������
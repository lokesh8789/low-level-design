package com.lld;

class EagerSingleton {
    public static final EagerSingleton INSTANCE = new EagerSingleton();
    private EagerSingleton() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Singleton already initialized");
        }
    }
}

class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {
        if (instance != null) {
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

class LazySingletonThreadSafe {
    private static LazySingletonThreadSafe instance;
    private LazySingletonThreadSafe() {
        if (instance != null) {
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static synchronized LazySingletonThreadSafe getInstance() {
        if(instance == null) {
            instance = new LazySingletonThreadSafe();
        }
        return instance;
    }
}

class LazySingletonThreadSafe2 {
    private static volatile LazySingletonThreadSafe2 instance;
    private LazySingletonThreadSafe2() {
        if (instance != null) {
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static LazySingletonThreadSafe2 getInstance() {
        if (instance == null) {
            synchronized (LazySingletonThreadSafe2.class) {
                if (instance == null) {
                    instance = new LazySingletonThreadSafe2();
                }
            }
        }
        return instance;
    }
}

class LazySingletonBillPugh {
    private static boolean instanceCreated = false;
    private LazySingletonBillPugh() {
        if (instanceCreated) {
            throw new IllegalStateException("Singleton already initialized");
        }
        instanceCreated = true;
    }

    private static class LazyInner {
        private static final LazySingletonBillPugh INSTANCE = new LazySingletonBillPugh();
    }
    
    public static LazySingletonBillPugh getInstance() {
        return LazyInner.INSTANCE;
    }
}

enum SingletonEnum {
    INSTANCE;
}

public class SingletonPattern {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.INSTANCE;
        LazySingletonBillPugh lazySingletonBillPugh = LazySingletonBillPugh.getInstance();
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingletonThreadSafe lazySingletonThreadSafe = LazySingletonThreadSafe.getInstance();
        LazySingletonThreadSafe2 lazySingletonThreadSafe2 = LazySingletonThreadSafe2.getInstance();
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
    }
}

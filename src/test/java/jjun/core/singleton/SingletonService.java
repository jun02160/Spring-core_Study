package jjun.core.singleton;

public class SingletonService {
    
    private static final SingletonService instance = new SingletonService();  // 자기 자신을 단 하나만 생성
    
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {  // private: 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막기 위함

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}

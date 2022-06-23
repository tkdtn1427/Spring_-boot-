package com.example.cmarket.singleton;

public class SingletonService {
    //1. static 영역에 객체를 1개만 생성합니다.
    private static final SingletonService instance = new SingletonService();

    //2. 객체 인스턴스가 필요하면 아래 public static 메서드를 통해서만 조회
    public static SingletonService getInstance(){
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 new로 생성 금지
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체를 호출합니다.");
    }
}

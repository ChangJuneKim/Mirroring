package com.ssafy.live4.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    // 문자열을 저장할 List, 구현체는 ArrayList
    List<String> friends = new ArrayList<>();


    public static void main(String[] args) {

        ListTest alt = new ListTest();
        alt.createTest();
        alt.retrieveTest();
        alt.updateTest();
        alt.deleteTest();
    }

    public void createTest() {
        // @@TODOBLOCK: friends에 여러명의 친구를 등록해보자.
        friends.add("홍길동");
        friends.add("홍길동"); // 동일 데이터 추가
        friends.add("장길산");
        friends.add("임꺽정");
        friends.add(0, "이몽룡"); // 끼워넣기
        // @@END:
        System.out.println("추가 후 내용 출력: " + friends);
    }

    public void retrieveTest() {
        // @@TODOBLOCK: 다양한 조회 기능을 사용해보자.
        // @@KEEP: 혹시 비어있지는 않나? 요소의 개수는 ?
        System.out.printf("비었나? %b, 요소 수는? %d%n", friends.isEmpty(), friends.size());


        // @@KEEP: 반복을 이용한 요소 순회
        for (int i = 0; i < friends.size(); i++) { // 리스트의 크기 조회
            System.out.printf("%d - %s%n", i, friends.get(i));
        }

        for (String name : friends) {
            System.out.println(name);
        }

        // @@KEEP: 홍길동이 있다면 그 위치 출력
        if (friends.contains("홍길동")) { // 객체의 포함 여부
            System.out.printf("홍길동의 위치는 %d%n", friends.indexOf("홍길동"));
            System.out.printf("마지막 위치는 %d%n", friends.lastIndexOf("홍길동"));
        }

        // @@KEEP 0번 부터 2번 친구만 모아본다면?
        List<String> sub = friends.subList(0, 2);
        System.out.printf("sub의 내용은? %s%n", sub);
        // @@END:
    }

    public void updateTest() {
        // @@TODOBLOCK: 홍길동이 있다면 값을 율도국 왕으로 변경해보자.
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).equals("홍길동")) {
                friends.set(i, "율도국 왕");
            }
        }
        System.out.println("업데이트 후: " + friends);
        // @@END:
    }

    public void deleteTest() {
        // @@TODOBLOCK: 0번째 친구와 율도국 왕을 삭제하시오.
        friends.remove(0); // 특정 위치의 객체 삭제
        friends.remove("율도국 왕"); // 특정 객체가 있다면 처음 객체 삭제
        // @@END:
        System.out.println("삭제 후 : " + friends);
        friends.clear();// 리스트 초기화
        System.out.println("초기화 후 : " + friends);
    }
}

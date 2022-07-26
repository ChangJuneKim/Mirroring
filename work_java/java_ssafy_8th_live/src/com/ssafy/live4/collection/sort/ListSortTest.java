package com.ssafy.live4.collection.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ssafy.live4.collection.set.SmartPhone;

public class ListSortTest {

    private List<String> names = Arrays.asList("Hi", "Java", "World", "Welcome");

    public void basicSort() {
        // @@TODOBLOCK: names를 이름의 오름차순, 또는 그 역순으로 정렬해서출력하시오.
        Collections.sort(names);
        System.out.println(names); // [Hi, Java, Welcome, World]
        Collections.reverse(names);
        System.out.println(names); // [Hi, Java, Welcome, World]
        // @@END:
    }

    public void sortPhone() {
        // @@TODOBLOCK: 전화 번호에 따라 SmartPhone을 정렬해보자.
        List<SmartPhone> phones =
                Arrays.asList(new SmartPhone("010"), new SmartPhone("011"), new SmartPhone("000"));
        Collections.sort(phones);
        System.out.println(phones); // [전화 번호: 000, 전화 번호: 010, 전화 번호: 011]
        
        Collections.reverse(phones);
        System.out.println(phones); // [전화 번호: 000, 전화 번호: 010, 전화 번호: 011]
        // @@END:
    }

    public void stringLengthSort() {
        // @@TODOBLOCK: 문자열의 길이에 따라 names를 정렬해보자.
        // outer class
        Collections.sort(names, new StringLengthComparator());

        // anonymous inner class
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length()) * -1;
            }
        });
        // lambda expression
        Collections.sort(names, (o1, o2) -> {
            return Integer.compare(o1.length(), o2.length()) * -1;
        });

        // @@END:
        System.out.println(names); // [Hi, Java, World, Welcome]
    }

    public static void main(String[] args) {
        ListSortTest st = new ListSortTest();
        //st.basicSort();
        st.sortPhone();
        //st.stringLengthSort();
    }

}

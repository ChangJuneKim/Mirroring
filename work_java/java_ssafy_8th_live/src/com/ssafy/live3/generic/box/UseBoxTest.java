package com.ssafy.live3.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
        Double a = 10.0;
    }

    private static void useNormalBox() {
        // @@TODOBLOCK: NormalBox 타입의 객체를 생성하고 사용해보세요.
        NormalBox nbox = new NormalBox();
        nbox.setSome("Hello");

        Object some = nbox.getSome();
        if (some instanceof String) {
            String someStr = (String) some;
            System.out.printf("문자열: %s, 길이: %d%n", someStr, someStr.length());
        }
        // @@END:
    }

    private static void useGenericBox() {
        // @@TODOBLOCK: GenericBox 타입의 객체를 생성하고 사용해보세요.
        GenericBox<String> gbox = new GenericBox<>();
        gbox.setSome("Hello");
        String some = gbox.getSome();
        System.out.printf("문자열: %s, 길이: %d%n", some, some.length());
        // @@END:
    }

    private static void useNumberBox() {
        // @@TODOBLOCK: NumberBox 타입의 객체를 생성하고 사용해보세요.
        NumberBox<Number> nbox = new NumberBox<>();
        nbox.setSome(10.5);
        
        nbox.addSomes(3.14, 5, 4L);

        //NumberBox<String> nbox2 = new NumberBox<>();
        // @@END:
    }

}

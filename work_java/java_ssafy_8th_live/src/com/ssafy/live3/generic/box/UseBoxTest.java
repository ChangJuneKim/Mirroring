package com.ssafy.live3.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
    	NormalBox nb = new NormalBox();
    	
    	// 파라미터로 Object를 받기 때문에 뭐든지 가능
    	nb.setSome(1); 
    	nb.setSome("Hello");
    	
    	Object ob = nb.getSome();
    	
    	// Integer num = (Integer)ob; // 컴파일에서 에러를 잡아주지 않음.. 런타임에서 에러 발생
    	
    	if(ob instanceof String) {
    		String string = (String)ob;
    		System.out.println(string + " : " + string.length());
    	}
        // END:
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
    	GenericBox<String> sBox = new GenericBox<>(); // String으로 지정
    	sBox.setSome("Hello");
//    	sBox.setSome(1); // 컴파일 시점에 체크를 해서 String이 아니면 못해~
    	String string = sBox.getSome();
    	System.out.println(string);
        // END:
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
    	NumberBox<Number> numberBox = new NumberBox<>();
    	
    	numberBox.addSome(1, 10L, 3.14, 22);
    	
    	NumberBox<Integer> doubleBox = new NumberBox<>();
    	doubleBox.addSome(1, 3, 22);
        // END:
    }

}

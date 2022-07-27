package com.ssafy.offline5.lambda.primitive;

import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.ToIntFunction;

/**
 * 람다식에 기본형을 사용하고 싶을 때
 */
public class PrimitiveTypeLambda {
	
	public static void main(String[] args) {
		
		// A, B는 기본형 작성 부분
		
		// A To B Function
		DoubleToIntFunction f1 = (doubleValue) -> (int) doubleValue;
		System.out.println(f1.applyAsInt(10.5));
		
		LongToIntFunction f10 = (l) -> (int) l;
		LongToDoubleFunction f11 = (l) -> (double) l;
		DoubleToLongFunction f12 = (d) -> (long) d;
		
		// To B Function To B 로 할거고 리턴타입은 <T>
		ToIntFunction<Double> f2 = (doubleValue) -> doubleValue.intValue();
		System.out.println(f2.applyAsInt(12.7));
		
		// A Function
		DoubleFunction<Integer> f3 = (doubleValue) -> (int) doubleValue;
		System.out.println(f3.apply(15.9));
		
		// Obj A Consumer
		ObjIntConsumer<Double> f4 = (doubleValue, intValue) -> System.out.println(doubleValue * 10 + ", " + intValue * 10);
		f4.accept(21.56, 12);
		
	}
}

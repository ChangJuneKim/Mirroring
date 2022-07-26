// @@DELETE_FILE:
package com.ssafy.live3.inter.replace.impl;

import com.ssafy.live3.inter.replace.Calculator;

public class CalculatorImpl implements Calculator {
	
	@Override
    public int add(int a, int b) {
      System.out.printf("파라미터 확인: %d, %d%n", a, b);
      return a + b;
    }
  }


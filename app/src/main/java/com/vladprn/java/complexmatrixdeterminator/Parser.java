package com.vladprn.java.complexmatrixdeterminator;

import java.util.ArrayList;;

public class Parser {
	private String str;
	private int index = 0;
	
	public Parser(String str) {
		this.str = str;
	}
	
	public Complex[][] getArray() {
		ArrayList<Complex> list = new ArrayList<>();
		Complex curr = getNextComplex();
		while (curr != null) {
			list.add(curr);
			curr = getNextComplex();
		}
		
		int size = (int) Math.sqrt(list.size());
		if (size * size != list.size()) {
			return null;
		}
		
		Complex[][] res = new Complex[size][size];
		for (int i = 0; i < list.size(); i++) {
			res[i / size][i % size] = list.get(i);
		}
		
		return res;
 	}
	
	private Complex getNextComplex() {
		String tmp = getNextExpression();
		if (tmp == null) {
			return null;
		}
		
		String[] arr = tmp.split(" ");
		
		double re = 0, im = 0, mn = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].charAt(0) == 'i') {
				im = Double.parseDouble(arr[i].substring(1)) * mn;
			} else if (arr[i].length() == 1 && arr[i].charAt(0) == '+') {
				mn = 1;
			} else if (arr[i].length() == 1 && arr[i].charAt(0) == '-') {
				mn = -1;
			} else {
				re = Double.parseDouble(arr[i]) * mn;
			}
		}
		
		return new Complex(re, im);
	}
	
	private String getNextExpression() {
		int begin, end;
		
		while (index < str.length() && str.charAt(index) != '(') {
			index++;
		}
		begin = index + 1;
		if (begin >= str.length()) {
			return null;
		}
	
		while (index < str.length() && str.charAt(index) != ')') {
			index++;
		}
		end = index;
		if (end >= str.length()) {
			return null;
		}
		
		return str.substring(begin, end);
	}
}
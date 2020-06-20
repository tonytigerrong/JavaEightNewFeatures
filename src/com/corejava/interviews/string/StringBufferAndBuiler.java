package com.corejava.interviews.string;

public class StringBufferAndBuiler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("abcde");
		sb.append("fghi");
		StringBuffer sbuf = new StringBuffer("ABCDE");
		sbuf.append("FGHI");
		System.out.println(sb.toString());
		System.out.println(sbuf.toString());
	}

}

package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    double[] a ={1.f,2.f,3.f,2.f};
        double[] b = {1.f,2.f,3.f,4.f,5.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f};
	    ArrayVectorImpl vector1 = new ArrayVectorImpl();
        ArrayVectorImpl vector2 = new ArrayVectorImpl();
	    vector1.set(a);
        vector2.set(b);
	    vector1.set(10,10.f);
	    vector1.mult(2.5f);
        vector1.sum(vector2);
        String intArrayString1 = Arrays.toString(vector1.get());
        System.out.println(intArrayString1);
        String intArrayString2 = Arrays.toString(vector2.get());
        System.out.println(intArrayString2);
    }
}

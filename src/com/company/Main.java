package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    double a[] ={1.f,2.f,3.f,2.f};
	    ArrayVectorImpl vector = new ArrayVectorImpl();
	    vector.set(a);
	    vector.set(10,10.f);
	    //vector.sortAscending();
	    vector.mult(2.5f);
        ArrayVectorImpl vector2 = new ArrayVectorImpl();
        double b[] = {1.f,2.f,3.f,4.f,5.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f,0.f};
        vector2.set(b);
        vector.sum(vector2);
        String intArrayString2 = Arrays.toString(vector.get());
        System.out.println(intArrayString2);
        String intArrayString = Arrays.toString(vector2.get());
        System.out.println(intArrayString);
    }
}

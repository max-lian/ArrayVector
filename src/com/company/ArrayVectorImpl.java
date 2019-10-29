package com.company;
import static java.lang.Math.sqrt;

public class ArrayVectorImpl implements ArrayVector {
    private double[] a;
    private int lenght;
    public ArrayVectorImpl(){
    }

    public ArrayVectorImpl(double[] a, int lenght) {
        this.a = a;
        this.lenght = lenght;
    }

    @Override
    public void set(double[] elements) {
        a=elements;
        this.lenght=a.length;
    }

    @Override
    public double[] get() {
        return a;
    }

    @Override
    public ArrayVector clone() {
        double aClone[] = new double[lenght];
        System.arraycopy(a,0,aClone,0,lenght);
        return new ArrayVectorImpl(aClone,lenght);
    }

    @Override
    public int getSize() {
        return lenght;
    }

    @Override
    public void set(int index, double value) {
        if (index >= 0){
            if (index > lenght-1){
                double[] b = new double[index+1];
                System.arraycopy(a,0,b,0,lenght);
                a=b;
                lenght=index+1;
            }
            a[index]=value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        try {
            return a[index];
        }
        catch(ArrayIndexOutOfBoundsException ex){
            throw ex;
        }
    }

    @Override
    public double getMax() {
        double max = a[0];
        for (int i = 0; i < lenght; i++){
            if(a[i]>max) max=a[i];
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = a[0];
        for (int i = 0; i < lenght; i++){
            if(a[i]<min) min=a[i];
        }
        return min;
    }

    @Override
    public void sortAscending() {
        int j = 0;
        double tmp = 0;
        for(int i=0; i<lenght; i++){
            j = i;
            for(int k = i; k<lenght; k++){
                if(a[j]>a[k]){
                    j = k;
                }
            }
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    @Override
    public void mult(double factor) {
        for(int i = 0; i < lenght;i++){
            a[i]=a[i]*factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int anotherLenght=anotherVector.getSize();
        if(lenght > anotherLenght){
            for (int i = 0; i < anotherLenght;i++){
                double value1=anotherVector.get(i);
                value1+=a[i];
                anotherVector.set(i,value1);
            }
        }
        else{
            for (int i = 0; i < lenght;i++) {
                double value1 = anotherVector.get(i);
                value1 += a[i];
                anotherVector.set(i, value1);
            }
        }
        return anotherVector;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double scalar=0;
        int count=0;
        if (lenght > anotherVector.getSize()) count = anotherVector.getSize();
        else count = lenght;
        for(int i = 0; i < count;i++){
            scalar+=a[i]*anotherVector.get(i);
        }
        return scalar;
    }

    @Override
    public double getNorm() {
        double norm = 0;
        for (int i = 0; i < lenght;i++){
            norm+=a[i]*a[i];
        }
        return sqrt(norm);
    }
}

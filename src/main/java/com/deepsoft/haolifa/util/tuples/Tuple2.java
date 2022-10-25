package com.deepsoft.haolifa.util.tuples;



public class Tuple2<A, B> {

    private A first;

    private B second;

    public Tuple2() {
    }

    public Tuple2(A a, B b) {
        first = a;
        second = b;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}

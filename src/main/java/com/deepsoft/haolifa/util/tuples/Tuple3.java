package com.deepsoft.haolifa.util.tuples;



public class Tuple3<A, B, C> extends Tuple2<A, B> {

    private C third;

    public Tuple3(A a, B b, C c) {
        super(a, b);
        this.third = c;
    }

    public C getThird() {
        return third;
    }

    public void setThird(C third) {
        this.third = third;
    }
}

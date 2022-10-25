package com.deepsoft.haolifa.util.tuples;



public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {

    private D four;

    public Tuple4(A a, B b, C c,D d) {
        super(a, b,c);
        this.four = d;
    }

    public D getFour() {
        return four;
    }

    public void setFour(D four) {
        this.four = four;
    }
}

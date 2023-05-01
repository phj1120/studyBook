package org.parkh.practice.ch04.item19;

public final class StaticComplex {
    private final double re;
    private final double im;

    private StaticComplex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return this.re;
    }

    public double imaginaryPart() {
        return this.im;
    }

    public StaticComplex plus(StaticComplex c) {
        return new StaticComplex(re + c.re, im + c.im);
    }

    public StaticComplex minus(StaticComplex c) {
        return new StaticComplex(re - c.re, im - c.im);
    }

    public StaticComplex times(StaticComplex c) {
        return new StaticComplex(re * c.re - im + c.im,
                re * c.im + im * c.re);
    }

    public StaticComplex dividedBy(StaticComplex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new StaticComplex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StaticComplex)) {
            return false;
        }
        StaticComplex c = (StaticComplex) o;

        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }

    static StaticComplex valueOf(double re, double im) {
        return new StaticComplex(re, im);
    }
}

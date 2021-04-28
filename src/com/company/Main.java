package com.company;

import java.math.BigInteger;

public class Main {


    public static void main(String[] args) {
        System.out.println(karatsuba3(BigInteger.valueOf(12347634456346L), BigInteger.valueOf(23346345643565L)));
    }
    public static BigInteger karatsuba3(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);


        N = (N / 2) + (N % 2);


        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));


        BigInteger ac    = karatsuba3(a, c);
        BigInteger bd    = karatsuba3(b, d);
        BigInteger abcd  = karatsuba3(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }
}

package com.naresh.calculatornaresh;

public class MathCal implements Cal {

    @Override
    public String add(Num n) {
        String add= (String.valueOf((n.getFirstNumber())+(n.getSecondNumber())));

        return add;

    }

    @Override
    public String sub(Num n) {
        String add= (String.valueOf((n.getFirstNumber())-(n.getSecondNumber())));
        return add;
    }

    @Override
    public String divide(Num n) {
        String add= (String.valueOf((n.getFirstNumber())/(n.getSecondNumber())));

        return add;
    }

    @Override
    public String mul(Num n) {
        String add= (String.valueOf((n.getFirstNumber())*(n.getSecondNumber())));

        return add;
    }
}

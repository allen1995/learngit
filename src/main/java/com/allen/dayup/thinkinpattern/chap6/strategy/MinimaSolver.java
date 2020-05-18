package com.allen.dayup.thinkinpattern.chap6.strategy;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 16:39
 * @Description: 策略模式更偏向于运行时，改变一个动作的处理策略，增加应用的灵活性.
 */
public class MinimaSolver {

    private FindMinima findMinima;

    public MinimaSolver(FindMinima findMinima) {
        this.findMinima = findMinima;
    }

    double[] minima(double[] line){
        return findMinima.algorithm(line);
    }

    public void changeFindMinima(FindMinima changeFindMinima){
        findMinima = changeFindMinima;
    }

    public static void main(String[] args) {
        MinimaSolver solver = new MinimaSolver(new LeastSquares());
        double[] lines = {1.1,2.2,3.3,4.4,-1.1};
        print(solver.minima(lines));
        solver.changeFindMinima(new Bisection());
        print(solver.minima(lines));
    }

    private static void print(double[] lines){
        Arrays.stream(lines).forEach( line -> {
            System.out.print( line + ",");
        });
        System.out.println();
    }
}

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.TrapezoidIntegrator;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a, b, e; // пределы интегрирования, b - верхний, a - нижний, e - погрешность
        boolean flag = false; // если верхний предел меньше нижнего
        int n = 4, u; //u - номер уравнения

        List<Double> ansL;
        List<Double> ansR;
        List<Double> ansM;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер функции:");
        System.out.println("1: (x^2+1)/2");
        System.out.println("2: (x^3 + 2x^2 - x + 1)");
        System.out.println("3: (2x-1)");
        System.out.println("4: (2 + 0*x)");
        u = scanner.nextInt();
        System.out.println("Введите верхний и нижний пределы интегрирования соответственно: ");
        b = scanner.nextDouble();
        a = scanner.nextDouble();
        System.out.println("Введите точность: ");
        e = scanner.nextDouble();

        if(a > b) {
            System.out.println("Меняю местами");
            flag  = true;
            a=a+b-(b=a); // меняем местами значения, учтем будущий минус через флаг
        }

        if( b - a < e){
            System.out.println("0");
        } else{
            ansL = Solver.leftRectangle(u, a, b, n, e);
            ansR = Solver.rightRectangle(u, a, b, n, e);
            ansM = Solver.middleRectangle(u, a, b, n, e);

            if(flag){
                ansL.add(1, -ansL.get(1)); // 0 элемент - число разбиений, 1 - ответ
                ansR.add(1, -ansR.get(1));
                ansM.add(1, -ansM.get(1));
            }
            System.out.println("По формуле левых прямоугольников: "+ ansL.get(1) + ", число разбиений  - " + ansL.get(0));
            System.out.println("По формуле средних прямоугольников: "+ ansM.get(1) + ", число разбиений  - " + ansM.get(0));
            System.out.println("По формуле правых прямоугольников: "+ ansR.get(1) + ", число разбиений  - " + ansR.get(0));
        }



//        UnivariateFunction function = x -> Math.pow(x, 3) - 3 * Math.pow(x, 2) + 6 * x - 19;;
//        TrapezoidIntegrator trapezoidIntegrator = new TrapezoidIntegrator(1.0e-12, 1.0e-8, 1, 32);
//        double answer = trapezoidIntegrator.integrate(100, function, 1, 3);
//        System.out.println(answer);






    }
}

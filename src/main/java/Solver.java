import java.util.ArrayList;
import java.util.List;

public class Solver {

    private static double summ;
    private static double answer;
    private static double currE;
    private static double previousAns;

    public static List<Double> rightRectangle(int u, double a, double b, int n, double e) {
        summ = 0;
        answer = 0;
        currE = Double.MAX_VALUE;
        double h;
        double currA;

        List<Double> list = new ArrayList<>();

        while (currE > e) {
            currA = a;
            h = (b - a) / n; // считаем h
            summ = 0;

            switch (u) {
                case 1:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += (Math.pow(currA, 2) + 1) / 2;
                        //summ += Math.pow(currA, 2);
                    }
                    break;

                case 2:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += (Math.pow(currA, 3) + 2 * Math.pow(currA, 2) - currA + 1);
                    }
                    break;

                case 3:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += (2 * currA - 1);
                    }
                    break;

                case 4:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += 2;
                    }
                    break;

                case 5:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += Math.pow(currA, currA);
                    }
                    //System.out.println("right");
                    break;


                default:
                    System.out.println("Некорректный номер уравнения!");
                    System.exit(0);

            }
            previousAns = answer;
            answer = summ * h;
            n = n * 2;
            currE = Math.abs(previousAns - answer);
        }
        list.add(0, (double) n);
        list.add(1, answer);
        return list;
    }

    public static List<Double> leftRectangle(int u, double a, double b, int n, double e) {
        answer = 0;
        currE = Double.MAX_VALUE;
        double h;
        double currA;

        List<Double> list = new ArrayList<>();

        while (currE > e) {
            currA = a;
            summ = 0;
            h = (b - a) / n; // считаем h
            switch (u) {
                case 1:
                    for (int i = 1; i <= n; i++) {
                        summ += (Math.pow(currA - h / 2, 2) + 1) / 2;
                        //summ += Math.pow(currA - h / 2, 2);
                        currA += h;
                    }
                    break;

                case 2:
                    for (int i = 1; i <= n; i++) {
                        summ += (Math.pow(currA - h / 2, 3) + 2 * Math.pow(currA - h / 2, 2) - (currA - h / 2) + 1);
                        currA += h;
                    }
                    break;

                case 3:
                    for (int i = 1; i <= n; i++) {
                        summ += (2 * (currA - h / 2) - 1);
                        currA += h;
                    }
                    break;

                case 4:
                    for (int i = 1; i <= n; i++) {
                        summ += 2;
                        currA += h;
                    }
                    break;

                case 5:
                    for (int i = 1; i <= n; i++) {
                        summ += Math.pow(currA - h/2, currA - h/2);
                        currA += h;
                    }
                    //System.out.println("left");
                    break;

                default:
                    System.out.println("Некорректный номер уравнения!");
                    System.exit(0);

            }
            previousAns = answer;
            answer = summ * h;
            n = n * 2;
            currE = Math.abs(previousAns - answer);
        }
        list.add(0, (double) n);
        list.add(1, answer);
        return list;
    }

    public static List<Double> middleRectangle(int u, double a, double b, int n, double e) {
        answer = 0;
        currE = Double.MAX_VALUE;
        double h;
        double currA;

        List<Double> list = new ArrayList<>();

        while (currE > e) {
            currA = a;
            summ = 0;
            h = (b - a) / n; // считаем h
            switch (u) {
                case 1:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += (Math.pow(currA - h / 2, 2) + 1) / 2;
                        //summ += Math.pow(currA - h / 2, 2);
                    }
                    break;

                case 2:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += (Math.pow(currA - h / 2, 3) + 2 * Math.pow(currA - h / 2, 2) - (currA - h / 2) + 1);
                    }
                    break;

                case 3:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += (2 * (currA - h / 2) - 1);
                    }
                    break;

                case 4:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += 2;
                    }
                    break;

                case 5:
                    for (int i = 1; i <= n; i++) {
                        currA += h;
                        summ += Math.pow(currA - h/2, currA - h/2);
                    }
                    //System.out.println("m");
                    break;

                default:
                    System.out.println("Некорректный номер уравнения!");
                    System.exit(0);

            }
            previousAns = answer;
            answer = summ * h;
            n = n * 2;
            currE = Math.abs(previousAns - answer);
        }
        list.add(0, (double) n);
        list.add(1, answer);
        return list;
    }
}


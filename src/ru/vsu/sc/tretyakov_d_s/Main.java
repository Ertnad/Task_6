package ru.vsu.sc.tretyakov_d_s;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readNumber("x");
        double sizeOfSequence = readNumber("size of Sequence");
        double epsilon = readNumber("epsilon");

        double sumOfSequence = calculateSumOfSequence(x, sizeOfSequence);
        printResult("of N terms", sumOfSequence);

        double sumOfSequenceWithEpsilon = calculateSumOfSequenceWithEpsilon(x, sizeOfSequence, epsilon);
        printResult("of N terms of which the absolute value of more than epsilon", sumOfSequenceWithEpsilon);

        double sumOfSequenceWithEpsilonDividedBy10 = calculateSumOfSequenceWithEpsilon(x, sizeOfSequence, epsilon / 10);
        printResult("of N terms of which the absolute value of more than epsilon divided by 10",
            sumOfSequenceWithEpsilonDividedBy10);

        double sumOfSequenceWithMath = Math.cos(x);
        printResult("using Math", sumOfSequenceWithMath);
    }

    private static double readNumber(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter value %s: ", name);
        return scanner.nextDouble();
    }

    private static void printResult(String phrase, double resultOfSum) {
        System.out.printf("The sum %s: %f\n", phrase, resultOfSum);
    }

    // Метод для возведения числа из последовательности в степень
    private static double pow(double base, int index) {
        double result = 1;
        for (int i = 0; i < index; i++) {
            result *= base;
        }
        return result;
    }

    // Метод для получения модуля числа
    private static double abs(double x) {
        return x < 0 ? - x : x;
    }

    private static double getFactorial(double n) {
        double result = 1;
        for (double i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    // Метод для получения N члена последовательности
    private static double getNMemberOfSequence(double x, int n) {
        double numerator = pow(-1, n+1) * pow(x, 2 * n - 2); // числитель
        double denominator = getFactorial(2 * n - 2); // знаменатель
        return numerator / denominator;
    }

    // Метод для подсчёта суммы n слагаемых заданного вида;
    private static double calculateSumOfSequence(double x, double sizeOfSequence) {
        double sum = 0;
        for (int i = 1; i <= sizeOfSequence; i++) {
            sum += getNMemberOfSequence(x, i);
        }
        return sum;
    }

    // Метод для подсчёта суммы тех слагаемые, которые по модулю больше e или больше e/10
    private static double calculateSumOfSequenceWithEpsilon(double x, double sizeOfSequence, double epsilon) {
        double sum = 0;
        for (int i = 1; i <= sizeOfSequence; i++) {
            double nMemberOfSequence = getNMemberOfSequence(x, i);
            if (abs(nMemberOfSequence) > epsilon) {
                sum += getNMemberOfSequence(x, i);
            }
        }
        return sum;
    }
}

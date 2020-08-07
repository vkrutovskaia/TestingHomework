package Test2;

import java.util.Scanner;

/*Simple calculator, for testing only*/

public class Calculator {

    public Calculator() {

    }
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int num1 = calculator.getInt();
        int num2 = calculator.getInt();
        char operation = calculator.getOperation();
        int result =calculator.calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);
    }

    public int getInt() {
        System.out.println("Введите число:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    public char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+': result = num1 + num2;
                break;
            case '-': result = num1 - num2;
                break;
            case '*': result = num1 * num2;
                break;
            case '/': result = num1 / num2;
                break;
            default: result = calc(num1, num2, operation);
        }
        return result;
    }

}

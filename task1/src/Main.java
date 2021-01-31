import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /*  Реализуйте функцию, которая конвертирует число (без знака) из десятичной системы исчисления
        в любую другую. Ваша функция должна иметь следующий прототип:
        String itoBase(unsigned int nb, String base); nb – это подаваемое число, base – система исчисления.
        На пример, «01» - двоичная, «012» - троичная, «0123456789abcdef» - шеснадцатиричная, «котики»
        - система исчисления в котиках.

        Для проверки задания, напишите метод main, который принимает необходимые значения из
        аргументов командной строки, и выводит результат на экран. При некорректном вводе
        аргументов должен выводится usage. */

    public static void main(String[] args) {

        Scanner userScanner = new Scanner(System.in);

        showInstructions();

        while (true) {

            System.out.println("Конвертировать число? [Type [N] for exit]");
            String repeatValue = userScanner.next();

            if (repeatValue.toLowerCase().equals("n")){
                System.exit(0);
            } else {
                try {
                    System.out.print("Пожалуйста, введите [ЧИСЛО ДЛЯ КОНВЕРТАЦИИ]: ");
                    int nb = userScanner.nextInt();
                    System.out.print("И [ЖЕЛАЕМУЮ СИСТЕМУ СЧИСЛЕНИЯ В ДИАПАЗОНАХ [2-36]] (а также [КОТИКИ]/[CATS]):");
                    String base = userScanner.next();
                    System.out.println(iToBase(nb, base));
                } catch (InputMismatchException e) {
                    System.out.println("ОШИБКА ВВОДА ДАННЫХ");
                    main(args);
                }
            }
        }
    }

    public static String iToBase (int nb, String base) {
        Scanner sc = new Scanner(System.in);
        String convertedNumber = null;

        if (isNumeric(base)) {
            int numberSystem = Integer.parseInt(base);
            convertedNumber = Integer.toString(nb, numberSystem);
        } else {
            switch (base.toLowerCase()){
                case "котики": case "cats":
                    return Integer.toString(nb, 9) + " cats";
                default:
                    System.out.print("Вами были переданы неверные значения. ");
                    showInstructions();
                    System.out.print("Пожалуйста, введите [ЧИСЛО ДЛЯ КОНВЕРТАЦИИ]: ");
                    int newNb = sc.nextInt();
                    System.out.print("И [ЖЕЛАЕМУЮ СИСТЕМУ СЧИСЛЕНИЯ]:");
                    String newBase = sc.next();
                    return iToBase(newNb, newBase);
            }
        }
        return convertedNumber;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer number = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void showInstructions () {
        System.out.println("В качестве передаваемого числа" +
                " поддерживается [ЛЮБОЕ ЧИСЛО БЕЗ ЗНАКА], в качестве системы счисления [ЗНАЧЕНИЯ " +
                "В ДИАПАЗОНАХ [2-36]] (а также [КОТИКИ] / [CATS])");
    }
}

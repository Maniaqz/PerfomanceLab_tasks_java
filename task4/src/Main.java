import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /*  Напишите программу, которая сравнивает 2 строки одинаковые ли они. Результат: вывод «ОК»,
        если строки идентичны, «КО», если не идентичны. Строки подаются в виде аргументов командной
        строки.
        Примечание: во второй строке может быть символ ‘*’ – он заменяет собой любое количество
        любых символов.
        На пример:
        «аааа» «аааа» - ОК
        «аааа» «аа*» - ОК
        «a» «*****» - ОК  */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Провести сравнение двух строк? [Type [N] for exit]");
            String repeatValue = sc.next();

            if (repeatValue.toLowerCase().equals("n")){
                System.exit(0);
            } else {
                System.out.println("Введите значение первой строки: ");
                String str1 = sc.next();
                System.out.println("Введите значение второй строки: ");
                String str2 = sc.next();
                testCompatibility(str2, str1);

            }
        }

    }

    static boolean stringCompare (String from, String to) {

        // Если мы достигаем конца обеих строк - мы закончили
        if (from.length() == 0 && to.length() == 0)
            return true;

        // Удостоверяемся, что буквы после [*] присутствуют во второй строке
        if (from.length() > 1 && from.charAt(0) == '*' &&
                to.length() == 0)
            return false;

        // Либо настоящие буквы двух строк совпадают
        if ((from.length() != 0 && to.length() != 0 && from.charAt(0) == to.charAt(0)))
            return stringCompare(from.substring(1),
                    to.substring(1));

        // Если нам попадается [*], есть 2 варианта:
        // a) Мы считываем настоящую букву второй строки
        // б) Мы игнорируем настоящую букву второй строки
        if (from.length() > 0 && from.charAt(0) == '*')
            return stringCompare(from.substring(1), to) ||
                    stringCompare(from, to.substring(1));
        return false;
    }

    static void testCompatibility(String first, String second) {
        if (stringCompare(first, second))
            System.out.println("[" + second + "] " + "[" + first + "] " + "- OK");
        else
            System.out.println("[" + second + "] " + "[" + first + "] " + "- KO");
    }

}

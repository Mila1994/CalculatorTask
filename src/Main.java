import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, '2 + 2'):");
        String input = scanner.nextLine();


        try {
            System.out.println("Результат: " + calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static String calc(String input) throws Exception {
        String[] numericExpression = input.split(" ");
        if (numericExpression.length != 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }


        String num1Str = numericExpression[0];
        String operator = numericExpression[1];
        String num2Str = numericExpression[2];

        int num1;
        int num2;
        try {
            num1 = Integer.parseInt(num1Str);
            num2 = Integer.parseInt(num2Str);
        } catch (NumberFormatException e) {
            throw new Exception("Ошибка: введено не целое число.");
        }


        if (num1 < 1 || num2 < 1 || num1 > 10 || num2 > 10) {
            throw new Exception("Ошибка: числа должны быть в диапазоне от 1 до 10.");
        }
        int result;

        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> result = num1 / num2;

            default -> throw new Exception("строка не является математической операцией");
        }


        return String.valueOf(result);
    }
}

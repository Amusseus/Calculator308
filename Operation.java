public class Operation {
    public static float CalculateResult(String number1, String number2, String operator) {
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> (float) num1 / (float) num2;
            default -> 0;
        };
    }


}

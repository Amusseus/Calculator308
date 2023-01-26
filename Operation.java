/**
 * A class that allows you to get two numbers and an operator and find the solution based on those.
 */
public class Operation {

    enum Num {
        First,
        Second,
        Result
    }
    Num numState;
    String[] nums;
    String operator;

    /**
     * Constructs and initializes the Operation object to empty values.
     */
    public Operation() {
        numState = Num.First;
        nums = new String[]{"", "", ""};
        operator = "";

    }

    /**
     * Processes the button that the user clicked and takes the appropriate action whether it was a number or an operator.
     * @param buttonText A string from the label of the button that was clicked.
     */
    public void Process(String buttonText) {

        if (Operation.IsNumeric(buttonText)) {
            NumberClicked(buttonText);
        } else {
            OperatorClicked(buttonText);
        }
    }

    private void NumberClicked(String buttonText) {
        if (numState == Num.Result) {
            Reset();
        }
        nums[numState.ordinal()] += buttonText;
    }

    private void OperatorClicked(String buttonText) {
        // Check if clicked button is +, -, *, or /
        if (Calculator.operators.contains(buttonText)) {
            if (numState == Num.First) {
                if (!nums[0].equals("")) {
                    operator = buttonText;
                    numState = Num.Second;
                }
            } else {
                if (buttonText.equals("=")) {
                    if (numState == Num.Second && !nums[1].equals("")) {
                        EqualsClicked();
                    }
                }
            }
            if (buttonText.equals("C")) {
                Reset();
            }
        }
    }
    private void EqualsClicked() {
        numState = Num.Result;
        float result = CalculateResult();

        // Check if result is a whole number
        if (result == (int) result) {
            nums[numState.ordinal()] = Integer.toString((int) result);
        } else {
            nums[numState.ordinal()] = Float.toString(result);
        }
    }

    /**
     * Uses the current state of the calculator to determine what the calculator should display.
     * @return The current string that should be in the calculator's display
     */
    public String GetCurrentNumStr() {
        return nums[numState.ordinal()];
    }

    /**
     * Uses the Operation class' nums array and operator to calculate the solution.
     * Only executes once the "=" button is clicked.
     * @return The solution to the desired equation
     */
    public float CalculateResult() {
        int num1 = Integer.parseInt(nums[0]);
        int num2 = Integer.parseInt(nums[1]);
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> (float) num1 / (float) num2;
            default -> 0;
        };
    }

    /**
     * Checks whether a String is a number or not.
     * @param number A String that could potentially be a number
     * @return A boolean whether the String was a number or not.
     */
    public static boolean IsNumeric(String number) {
        try {
            double d = Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    private void Reset() {
        numState = Num.First;
        nums = new String[]{"", "", ""};
        operator = "";
    }

}

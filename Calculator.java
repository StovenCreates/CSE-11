public class Calculator {

    public static String formatResult(String number) {
        if (number == null || number.isEmpty()) {
            return "0.0";
        }

        String formatted = number.replaceFirst("^0+(?!$)", "");

        if (formatted.contains(".")) {
            formatted = formatted.replaceAll("0+$", "");
            if (formatted.endsWith(".")) {
                formatted = formatted.substring(0, formatted.length() - 1);
            }
        }

        if (!formatted.contains(".")) {
            formatted = formatted + ".0";
        } 
        else if (formatted.startsWith(".")) {
            formatted = "0" + formatted;
        }

        return formatted;
    }

    public static String extractWholeNumber(String number) {
        if (number.contains(".")) {
            String[] parts = number.split("\\.");

            if (parts[0].isEmpty()) {
                return "";
            } 
            else {
                return parts[0];
            }
        } 
        else {
            return number;
        }
    }

    public static String extractDecimal(String number) {
        if (number.contains(".")) {
            String[] parts = number.split("\\.");
            if (parts.length > 1) {
                return parts[1];
            } 
            else {
                return "";
            }
        } 
        else {
            return "";
        }
    }

    public static String prependZeros(String number, int numZeros) {
        if (numZeros <= 0) {
            return number;
        }

        StringBuilder zeros = new StringBuilder();

        for (int i = 0; i < numZeros; i++) {
            zeros.append("0");
        }

        return zeros.toString() + number;
    }

    public static String appendZeros(String number, int numZeros) {
        if (numZeros <= 0) {
            return number;
        }

        StringBuilder zeros = new StringBuilder(number);

        for (int i = 0; i < numZeros; i++) {
            zeros.append("0");
        }

        return zeros.toString();
    }

    public static char addDigits(char firstDigit, char secondDigit, boolean carryIn) {
        int first = firstDigit - '0';
        int second = secondDigit - '0';
        int sum = first + second + (carryIn ? 1 : 0);

        return (char) ('0' + (sum % 10));
    }

    public static boolean carryOut(char firstDigit, char secondDigit, boolean carryIn) {
        int first = firstDigit - '0';
        int second = secondDigit - '0';
        int sum = first + second + (carryIn ? 1 : 0);

        return sum >= 10;
    }

    public static String add(String firstNumber, String secondNumber) {
        firstNumber = formatResult(firstNumber);
        secondNumber = formatResult(secondNumber);

        String firstWhole = extractWholeNumber(firstNumber);
        String firstDecimal = extractDecimal(firstNumber);
        String secondWhole = extractWholeNumber(secondNumber);
        String secondDecimal = extractDecimal(secondNumber);

        int maxLengthWhole = (firstWhole.length() > secondWhole.length()) ? firstWhole.length() : secondWhole.length();
        firstWhole = prependZeros(firstWhole, maxLengthWhole - firstWhole.length());
        secondWhole = prependZeros(secondWhole, maxLengthWhole - secondWhole.length());
        int maxLengthDecimal = (firstDecimal.length() > secondDecimal.length()) ? firstDecimal.length() : secondDecimal.length();
        firstDecimal = appendZeros(firstDecimal, maxLengthDecimal - firstDecimal.length());
        secondDecimal = appendZeros(secondDecimal, maxLengthDecimal - secondDecimal.length());

        firstNumber = firstWhole + "." + firstDecimal;
        secondNumber = secondWhole + "." + secondDecimal;

        StringBuilder resultWhole = new StringBuilder();
        StringBuilder resultDecimal = new StringBuilder();
        boolean carry = false;

        for (int i = firstDecimal.length() - 1; i >= 0; i--) {
            char sum = addDigits(firstDecimal.charAt(i), secondDecimal.charAt(i), carry);
            carry = carryOut(firstDecimal.charAt(i), secondDecimal.charAt(i), carry);
            resultDecimal.insert(0, sum);
        }

        for (int i = firstWhole.length() - 1; i >= 0; i--) {
            char sum = addDigits(firstWhole.charAt(i), secondWhole.charAt(i), carry);
            carry = carryOut(firstWhole.charAt(i), secondWhole.charAt(i), carry);
            resultWhole.insert(0, sum);
        }

        if (carry) {
            resultWhole.insert(0, '1');
        }

        String result = resultWhole.toString() + "." + resultDecimal.toString();

        return formatResult(result);
    }

    public static String multiply(String number, int numTimes) {
        if (numTimes <= 0) {
            return "0.0";
        }

        String result = "0.0";
        String tempNumber = number;

        while (numTimes > 0) {
            if ((numTimes % 2) == 1) {
                result = add(result, tempNumber);
            }
            tempNumber = add(tempNumber, tempNumber);
            numTimes /= 2;
        }

        return formatResult(result);
    }

    public static void main(String[] args) {
        // Test cases for add method
        System.out.println(Calculator.add("4.02", "0.0050"));  // Expected: 4.025
        System.out.println(Calculator.add("4.02", ".005"));    // Expected: 4.025
        System.out.println(Calculator.add("100", "200"));      // Expected: 300.0
        System.out.println(Calculator.add("0.1", "0.2"));      // Expected: 0.3
        System.out.println(Calculator.add("0.01", "0.09"));    // Expected: 0.1
        System.out.println(Calculator.add("0", "0"));          // Expected: 0.0
        System.out.println(Calculator.add("999999.99", "0.01")); // Expected: 1000000.0
        System.out.println(Calculator.add("123456789.1", "987654321.9")); // Expected: 1111111111.0

        // Test cases for multiply method
        System.out.println(Calculator.multiply("100", 3));     // Expected: 300.0
        System.out.println(Calculator.multiply("0.5", 4));     // Expected: 2.0
        System.out.println(Calculator.multiply("12345.6789", 10)); // Expected: 123456.7890
        System.out.println(Calculator.multiply("0.1", 10));    // Expected: 1.0
        System.out.println(Calculator.multiply("1000000000", 1000)); // Expected: 1000000000000.0
        System.out.println(Calculator.multiply("1", 0));       // Expected: 0.0
        System.out.println(Calculator.multiply("2", 1));       // Expected: 2.0
        System.out.println(Calculator.multiply("1234.5678", 0)); // Expected: 0.0
        System.out.println(Calculator.multiply("0.00001", 1000000)); // Expected: 10.0

        // Edge cases
        System.out.println(Calculator.add("0.0000001", "0.0000001")); // Expected: 0.0000002
        System.out.println(Calculator.multiply("0.0001", 10000));  // Expected: 1.0
        System.out.println(Calculator.add("999999999.999999", "0.000001")); // Expected: 1000000000.0
        System.out.println(Calculator.multiply("999999999.999999", 1000));  // Expected: 999999999999.9990
    }

}

package ExprTesting;

import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {


        Unit_testing unit_test = new Unit_testing();

        unit_test.testing_input_value_ArgumentOutOfBoundsException("1");
        unit_test.testing_input_value_ValueAccepted("9    ");
        unit_test.testing_input_value_ValueAccepted("    4");
        unit_test.testing_input_value_NumberFormatException("    2     7 ");
        System.out.println("");
        unit_test.testing_input_value_ArgumentOutOfBoundsException("-8");
        unit_test.testing_input_value_ArgumentOutOfBoundsException("-11   ");
        unit_test.testing_input_value_ArgumentOutOfBoundsException("    -8");
        unit_test.testing_input_value_ArgumentOutOfBoundsException("-   2   3");
        unit_test.testing_input_value_ArgumentOutOfBoundsException("-    298");
        System.out.println("");
        unit_test.testing_input_value_NumberFormatException("2,004");
        unit_test.testing_input_value_ValueAccepted("30.89");
        unit_test.testing_input_value_NumberFormatException("-5. ");
        unit_test.testing_input_value_NumberFormatException("14. ");
        unit_test.testing_input_value_NumberFormatException("  2 8  .   89  ");
        unit_test.testing_input_value_NumberFormatException("  .333");
        unit_test.testing_input_value_NumberFormatException("6.,025");
        unit_test.testing_input_value_NumberFormatException("6  .,025");
        unit_test.testing_input_value_NumberFormatException("1   .,025");
        System.out.println("");
        unit_test.testing_input_value_NumberFormatException("asd!yy");
        unit_test.testing_input_value_NumberFormatException("7rR");
        unit_test.testing_input_value_NumberFormatException("7   rR");
        unit_test.testing_input_value_NumberFormatException("-45   !)t");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        unit_test.testing_input_value_ArgumentOutOfBoundsException("1");
        unit_test.testing_calculation_CorrectResult("9    ");
        unit_test.testing_calculation_CorrectResult("    4");
        unit_test.testing_calculation_ValueNotFormat("1  2 ");
        unit_test.testing_calculation_ValueOutOfRange("-8");
        unit_test.testing_calculation_ValueOutOfRange("-11    ");
        unit_test.testing_calculation_ValueOutOfRange("    -8");
        unit_test.testing_calculation_ValueNotSetted("-      2    3");
        unit_test.testing_calculation_ValueNotSetted("-    2");
        unit_test.testing_calculation_ValueNotSetted("5032");
        unit_test.testing_calculation_CorrectResult("19");
        unit_test.testing_calculation_CorrectResult("20.99");
        unit_test.testing_calculation_ValueNotSetted("36.  99");
        System.out.println("");
        unit_test.testing_calculation_ValueNotSetted("asd!yy");
        unit_test.testing_calculation_ValueNotSetted("7rR");
        unit_test.testing_calculation_ValueNotSetted("7   rR");
        unit_test.testing_calculation_ValueNotSetted("-45   !)t");
        unit_test.testing_calculation_CorrectResult("\n" + "7");
        unit_test.testing_calculation_ValueNotSetted("\n" + " \n" + "5");

    }
}
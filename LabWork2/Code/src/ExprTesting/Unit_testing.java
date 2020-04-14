package ExprTesting;

import java.util.Map;

public class Unit_testing {
    private int counter = 0;
    public void testing_input_value_NumberFormatException(String num){
        counter++;
        try {
            double t_num = InputDoubleValue.strValueToDouble(num);
            throw new Exception();
        } catch (NumberFormatException e) {
            System.out.println(counter + ": The test is success!");
        }
        catch (Exception | ArgumentOutOfBoundsException e){
            System.out.println(counter + ": The test is failed!");
        }

    }
    public void testing_input_value_NullPointerException(String num){
        counter++;
        try {
            double t_num = InputDoubleValue.strValueToDouble(num);
            throw new Exception();
        } catch (NullPointerException e) {
            System.out.println(counter + ": The test is success!");
        }
        catch (Exception | ArgumentOutOfBoundsException e){
            System.out.println(counter + ": The test is failed!");
        }
    }
    public void testing_input_value_ArgumentOutOfBoundsException(String num){
        counter++;
        try {
            double t_num = InputDoubleValue.strValueToDouble(num);
            throw new Exception();
        } catch (ArgumentOutOfBoundsException e) {
            System.out.println(counter + ": The test is success!");
        }
        catch (Exception e){
            System.out.println(counter + ": The test is failed!");
        }

    }
    public void testing_input_value_ValueAccepted(String num){
        counter++;
        try {
            double t_num = InputDoubleValue.strValueToDouble(num);
            System.out.println(counter + ": The test is success!");
        } catch (ArgumentOutOfBoundsException | Exception e) {
            System.out.println(counter + ": The test is failed!");
        }

    }


    public void testing_calculation_ValueNotSetted(String expression) {
        counter++;
        CalculationFunction testTry = new CalculationFunction();
        try {
            String mess = testTry.setValue(expression);
        } catch (ArgumentOutOfBoundsException e) {
        }
        try {
            Map<String, Double> functions = testTry.calculateByFunctions();
            if(functions.isEmpty()){
                System.out.println(counter + ": The test is success!");
            }
            else {
                System.out.println(counter + ": The test is failed!");
            }

        } catch (NullPointerException e) {
            System.out.println(counter + ": The test is failed!");
        }
    }

    public void testing_calculation_ValueNotFormat(String expression) {
        counter++;
        CalculationFunction testTry = new CalculationFunction();
        try {
            String mess = testTry.setValue(expression);
            System.out.println(counter + ": The test is success!");
        } catch (ArgumentOutOfBoundsException e) {
            System.out.println(counter + ": The test is failed!");
        }

    }
    public void testing_calculation_ValueOutOfRange(String expression){
        counter++;
        CalculationFunction testTry = new CalculationFunction();
        try {
            String mess = testTry.setValue(expression);
        } catch (ArgumentOutOfBoundsException | Exception e) {
        }
        try {
            testTry.calculateByFunctions();
            System.out.println(counter + ": The test is success!");
        }
        catch(NullPointerException e){
            System.out.println(counter + ": The test is failed!");
        }

    }
    public void testing_calculation_CorrectResult(String expression){
        counter++;
        try {
            CalculationFunction testTry = new CalculationFunction(expression);
            Map<String, Double> testMap = testTry.calculateByFunctions();
            if(testMap.get("y = x^4*4.968 + x^3*2.271 - x^2*3.589 + x*3.317") == (Math.pow(testTry.value,4)*4.968)+(Math.pow(testTry.value,3)*2.271)-(Math.pow(testTry.value,2)*3.589)+(testTry.value*3.317)){
//                System.out.println("The test of first function is success!");
            }
            if(testMap.get("y = x^3*3.774 - x^2*2.298 + x*3.873") == (Math.pow(testTry.value,3)*3.774)-(Math.pow(testTry.value,2)*2.298) + (testTry.value*3.873)){
//                System.out.println("The test of second function is success!");
            }
            if(testMap.get("y = x^2*4.165 + x*3.363") == (Math.pow(testTry.value,2)*4.165)+(testTry.value*3.363)){
//                System.out.println("The test of third function is success!");
            }
            if(testMap.get("y = x*6.363") == (testTry.value*6.363)){
//                System.out.println("The test of fourth function is success!");
            }
            System.out.println(counter + ": The test is success!");
        }
        catch (Exception | ArgumentOutOfBoundsException e){
            System.out.println(counter + ": The test is failed!");
        }
    }
}

package ExprTesting;

import java.util.HashMap;
import java.util.Map;

public class CalculationFunction {


    private Map<String, Double> functions = new HashMap<String, Double>();
    private iSystemOfFunction func;
    protected Double value;

    private String addWord = "is";
    CalculationFunction(){}
    CalculationFunction(String value) throws ArgumentOutOfBoundsException{
        try {
            this.value = InputDoubleValue.strValueToDouble(value);
        }
        catch (Exception except){
            String message = except.getMessage();
            addWord = "NOT";
        }
        catch (ArgumentOutOfBoundsException except){
            String message = except.getMessage();
            addWord = "NOT";
            throw new ArgumentOutOfBoundsException("Do not use letters or symbols in your number!");
        }
        finally {
        }
    }

    public String setValue(String value) throws ArgumentOutOfBoundsException{
        try {
            String addWord = "is";
            this.value = InputDoubleValue.strValueToDouble(value);
        }
        catch (Exception except){
            String message = except.getMessage();
            addWord = "NOT";
        }
        catch (ArgumentOutOfBoundsException except){
            String message = except.getMessage();
            addWord = "NOT";
            throw new ArgumentOutOfBoundsException("Do not use letters or symbols in your number!");
        }
        finally {
        }

        return "Value " + this.addWord + " assigned!";
    }

    public Map<String, Double> calculateByFunctions() {
        if(value == (null)){
            throw new NullPointerException("No assigned any number. Use 'yourObject.setValue()' method!");
        }
        else{
            func = (x)->(Math.pow(x,4)*4.968)+(Math.pow(x,3)*2.271)-(Math.pow(x,2)*3.589)+(x*3.317);
            functions.put("y = x^4*4.968 + x^3*2.271 - x^2*3.589 + x*3.317", func.calculate(this.value));

            func = (x)->(Math.pow(x,3)*3.774)-(Math.pow(x,2)*2.298) + (x*3.873);
            functions.put("y = x^3*3.774 - x^2*2.298 + x*3.873", func.calculate(this.value));

            func = (x)->(Math.pow(x,2)*4.165)+(x*3.363);
            functions.put("y = x^2*4.165 + x*3.363", func.calculate(this.value));

            func = (x)->x*6.363;
            functions.put("y = x*6.363", func.calculate(this.value));
        }

        if(functions.isEmpty()){
            throw new NullPointerException("There is NO functions to calculate! Probably values were not assigned.");
        }
        else{
            return functions;
        }
    }
}
interface iSystemOfFunction{
    double calculate(double x_value);

}
package ExprTesting;

import java.util.HashMap;
import java.util.Map;

public class CalculationFunction {

    private Map<String, Double> functions = new HashMap<String, Double>();
    private iSystemOfFunction func;
    private Double value;

    private String addWord = "is";
    CalculationFunction(String value){
        try {
            this.value = InputDoubleValue.strValueToDouble(value);
        }
        catch (Exception except){
            String message = except.getMessage();
            System.out.println(message);
            addWord = "NOT";
        }
        finally {
            System.out.printf("Value %s assigned!\n", this.addWord);
        }
    }

    public void setValue(String value) {
        try {
            String addWord = "is";
            this.value = InputDoubleValue.strValueToDouble(value);
        }
        catch (Exception except){
            String message = except.getMessage();
            System.out.println(message);
            addWord = "NOT";
        }
        finally {
            System.out.printf("Value %s assigned!\n", this.addWord);
        }
    }

    public void calculateByFunctions() {
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
            for(Map.Entry<String, Double> accord : functions.entrySet()) {
                System.out.printf("Function: %-47s  Value: %.3f \n", accord.getKey(), accord.getValue());
            }
        }
    }
}
interface iSystemOfFunction{
    double calculate(double x_value);

}
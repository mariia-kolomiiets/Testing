package ExprTesting;

import org.w3c.dom.ranges.RangeException;

public class InputDoubleValue {


    private static double value;

    public static double strValueToDouble(String num) throws Exception{

        try{
            value = Double.parseDouble(num);
            if((value <= 1.206)||(value>=36.373)){
                throw new ArgumentOutOfBoundsException("Inputted value is OUT of range: 1.206 >= X <= 36.373!");
            }
            return  value;
        }
        catch (NumberFormatException e){
            if(num.contains(",")){
                throw new Exception("You can not write number with coma, just with dot.");
            }
            else if(num.contains(" ")){
                throw  new Exception("Avoid spaces! Write just number.");
            }

            else{
                throw new Exception("Do not use letters or symbols in your number!");
            }
        }
        catch(NullPointerException e){
            throw new NullPointerException("There is NO number in your enter. Type any number.");
        }
        catch (ArgumentOutOfBoundsException e){
            throw new Exception(e.getMessage());
        }
    }
}

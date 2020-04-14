package ExprTesting;

public class InputDoubleValue {


    private static double value;

    public static double strValueToDouble(String num) throws Exception, ArgumentOutOfBoundsException{

        try{
            String[] arr = num.trim().split("[\\s+]");
            value = Double.parseDouble(arr[0]);
            if((value <= 1.206)||(value>=36.373)){
                throw new ArgumentOutOfBoundsException("Inputted value is OUT of range: 1.206 >= X <= 36.373!");
            }
            return  value;
        }
        catch (NumberFormatException e){
            if(num.contains(",")){
                throw new NumberFormatException("You can not write number with coma, just with dot.");
            }
            else if(num.contains(" ")){
                throw  new NumberFormatException("Avoid spaces! Write just number.");
            }

            else{
                throw new NumberFormatException("Do not use letters or symbols in your number!");
            }
        }
        catch(NullPointerException e){
            throw new NullPointerException("There is NO number in your enter. Type any number.");
        }
    }
}

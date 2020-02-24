package ExprTesting;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            System.out.print("Input a number: ");
            Scanner in = new Scanner(System.in);

            String num = in.next();

            CalculationFunction firstTry = new CalculationFunction(num);
//            try {
            firstTry.calculateByFunctions();
//            }
//            catch (Exception e){
//                System.out.print(e.getMessage());
//            }
        }
    }
}
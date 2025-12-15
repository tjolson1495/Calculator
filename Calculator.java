import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Expression.*;

public class Calculator {

    private static final String PROMPT_STRING = "> ";
       
	public static void main(String[] args) throws FileNotFoundException {
        
        Scanner s = new Scanner(System.in);
        String expression = "";
        Expression e;

        if (args.length > 0) {
            File inputFile = new File(args[0]);
            Scanner fileScan = new Scanner(inputFile);

            while (fileScan.hasNextLine()) {
                expression = fileScan.nextLine();
                System.out.println(PROMPT_STRING + expression);
                
                e = new Expression(expression);
                e.setOperation();
                e.split();
                
                String solution = e.solve();
                System.out.println(solution);
            }
        }
        
        while (!expression.equals("quit")) {
            System.out.print(PROMPT_STRING);
            
            expression = s.nextLine();

            e = new Expression(expression);
            e.setOperation();
            e.split();
            
            String solution = e.solve();
            System.out.println(solution);
        }

        s.close();
    }
}
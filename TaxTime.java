import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created on 06.01.2006
 */

/**
 * @author weberwu
 * Calculating a Berlin tax that could be done on a beer mat.
 */
public class TaxTime {
    static int nFamilyMembers;
    static int exemption;
    static double income;
    static double taxTotal;

    public static void main(String[] args) {

        // A Reader stream to read from the console
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));

        System.out.println ("Welcome to the new Berlin tax calculator."); 
        System.out.print   ("How much did you earn last year? ");
        try {  
            income = Double.parseDouble(in.readLine());
        } catch (NumberFormatException e1) {  //A0
            e1.printStackTrace();
        } catch (IOException e1) { // A2 
            e1.printStackTrace();
        }

//     check income

        if (income < 0) { //A1
            System.out.println ("Even in Berlin, no one has a negative income!"); 
            System.out.println ("Start over.");
            System.exit (-1);
        }

        System.out.print("Enter the number of dependents you have, including yourself: ");
        try {                                                           //c
            String s = in.readLine();
            nFamilyMembers = Integer.valueOf(s).intValue();
        } catch (IOException e) {           //D
            e.printStackTrace();
        }

//     check number of family members

       if (nFamilyMembers <= 0) {   //E
          System.out.println("Did you forget to count yourself?");
          System.out.println ("Start over.");
          System.exit (-1); //E1
          }

//    compute tax total

      if (income < 10000) //E2
         taxTotal = 0.12 * income; //E21
      else if (income < 50000) //E3
         taxTotal = 300.00 + 0.24 * (income - 10000); //E31
      else //E4
         taxTotal = 1500.00 + 0.36 * (income - 50000); //E4

      for (int i = 0; i <= nFamilyMembers; i++){  //CON 
           taxTotal = taxTotal - 100;
      }

//    check negative tax

    if (taxTotal < 0) // In case of negative tax
       taxTotal=0;

    System.out.println ("=€=€=€=€=€=€=€=€=€=€=€=€=€=€=€");
    System.out.println ("Wowereit & Sarrazin GmbH");
    System.out.println ("Tax bill");
    System.out.println ("Your income was " + income + " €.");
    System.out.println ("You have " + nFamilyMembers + " family members.");
    System.out.println ("Your total tax is " + taxTotal + " €.");
    System.out.println ("Family member tax saving is " + nFamilyMembers*100 + "€.");
    System.out.println ("=€=€=€=€=€=€=€=€=€=€=€=€=€=€=€");
    }
}

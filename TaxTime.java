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
// test this but after the if??
    public static void main(String[] args) {

        // A Reader stream to read from the console 
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in)); //0 

        System.out.println ("Welcome to the new Berlin tax calculator."); //1 
        System.out.print   ("How much did you earn last year? ");  //2 
        try {                                             //3 
            income = Double.parseDouble(in.readLine());  
        } catch (NumberFormatException e1) {    //4
            e1.printStackTrace();     //4.1 
        } catch (IOException e1) {    //5
            e1.printStackTrace();    //5.1 
        }

//     check income

        if (income < 0) {    //A
            System.out.println ("Even in Berlin, no one has a negative income!"); //B 
            System.out.println ("Start over.");                                   //B2 
            System.exit (-1);                                                     //B3 
        }

        System.out.print("Enter the number of dependents you have, including yourself: "); //c
        try {                                       //D
            String s = in.readLine();    //D1
            nFamilyMembers = Integer.valueOf(s).intValue(); //D2 
        } catch (IOException e) {   //E
            e.printStackTrace();    //E2
        }

//     check number of family members

       if (nFamilyMembers <= 0) { // F
          System.out.println("Did you forget to count yourself?"); //F1 
          System.out.println ("Start over.");   //F2 
          System.exit (-1);                         // F3 
          }

//    compute tax total

      if (income < 10000)   //G
         taxTotal = 0.12 * income; //G1 
      else if (income < 50000)    // H
         taxTotal = 300.00 + 0.24 * (income - 10000); //H1 
      else 
         taxTotal = 1500.00 + 0.36 * (income - 50000); //I

      for (int i = 0; i <= nFamilyMembers; i++){  //J
           taxTotal = taxTotal - 100;   // J1 
      }

//    check negative tax

    if (taxTotal < 0) // In case of negative tax  k
       taxTotal=0;          //k2
//X
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

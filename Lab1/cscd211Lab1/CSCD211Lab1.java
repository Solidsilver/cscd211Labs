package cscd211Lab1;

import java.io.*;
import java.util.*;

import cscd211Classes.Motor;
import cscd211Methods.*;
import cscd211Utils.FileUtil;
import cscd211Utils.SortUtil;
import cscd211Comparators.WattsSort;

/**
 * The provided class used to test your code.  This file will
 * not be changed!<br>
 * 
 * <br>NOTE: This class is contained within the package cscd211Lab1;
 */
public class CSCD211Lab1
{
   public static void main(String [] args) throws Exception
   {
      int total;
      File inf, onf = null;
      PrintStream fout = null;
      Motor [] myMotors = null;
      Scanner kb = new Scanner(System.in), fin = null;
      
      
      inf = FileUtil.openInputFile(kb);
      fin = new Scanner(inf);
      total = FileUtil.countRecords(fin, 2);
      fin.close();
      
      
      fin = new Scanner(inf);
      myMotors = CSCD211Lab1Methods.fillArray(fin, total);
      fin.close();
      
      System.out.println("After the Array is Filled!");
      CSCD211Lab1Methods.printArray(myMotors, System.out);

      SortUtil.selectionSort(myMotors);
      
      System.out.println();
      System.out.println("After the Array is Sorted!");
      CSCD211Lab1Methods.printArray(myMotors, System.out); 
      
      
      System.out.println();
      Arrays.sort(myMotors, new WattsSort());
      onf = FileUtil.openOutputFile(kb);
      fout = new PrintStream(onf);
      CSCD211Lab1Methods.printArray(myMotors, fout);
      fout.close();      
          
   }// end main
      
}// end class 
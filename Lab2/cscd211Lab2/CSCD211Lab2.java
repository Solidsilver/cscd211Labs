package cscd211Lab2;

import java.io.*;
import java.util.*;
import cscd211Enums.Color;
import cscd211Classes.Person;
import cscd211Utils.FileUtil;
import cscd211Utils.SortUtil;
import cscd211Comparators.ColorSort;
import cscd211Methods.CSCD211Lab2Methods;

/**
 * The provided class used to test your code.  This file will
 * not be changed!<br>
 */
public class CSCD211Lab2
{
   public static void main(String [] args) throws Exception
   {
      File inf = null;
      int total, choice;
      Person [] myPeeps = null;
      Scanner kb = new Scanner(System.in), fin = null;
      
      inf = FileUtil.openInputFile(kb);
      fin = new Scanner(inf);
      total = FileUtil.countRecords(fin, 1);
      fin.close();
      
      fin = new Scanner(inf);
      myPeeps = CSCD211Lab2Methods.fillArray(fin, total);
      SortUtil.selectionSort(myPeeps);
      fin.close();
      
      do
      {
         choice = CSCD211Lab2Methods.menu(kb);
         
         if(choice == 1)
            CSCD211Lab2Methods.printArray(myPeeps);
         
         else if(choice == 2)
         {
            Color toFind = CSCD211Lab2Methods.readColor(kb);
            CSCD211Lab2Methods.displayAll(toFind, myPeeps);
         }// end choice == 2
         
         else if(choice == 3)
            Arrays.sort(myPeeps, new ColorSort());
         
         else if(choice == 4)
            Arrays.sort(myPeeps);
            
      }while(choice != 5);
   
   }// end main
      
}// end class 
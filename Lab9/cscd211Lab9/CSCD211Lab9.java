package cscd211Lab9;

import java.io.*;
import java.util.*;
import cscd211Utils.*;
import cscd211Methods.*;
import cscd211Comparators.*;
import cscd211Classes.teams.*;
import cscd211Generics.MyArrayList;

public class CSCD211Lab9
{
   public static void main(String [] args)throws Exception
   {
      File inf = null;
      int choice;
      MyArrayList<Team> theTeams = new MyArrayList<Team>();
      Scanner fin = null, kb = new Scanner(System.in);
      
      inf = FileUtil.openInputFile(kb);
      fin = new Scanner(inf);
      CSCD211Lab9Methods.fill(fin, theTeams);
      System.out.println(theTeams.size());
      fin.close();
      
      do
      {
          choice = CSCD211Lab9Methods.menu(kb);
          switch(choice)
          {
            case 1:  System.out.println();
            		   System.out.println(theTeams + "\n");
                     break;
                     
            case 2:  Collections.sort(theTeams);
                     break;
                     
            case 3:  Collections.sort(theTeams, new TeamPayrollSort());
                     break;
                     
            default: System.out.println("Exiting");
                     
          }// end switch
          
      }while(choice != 4); 

   }// end main
   
}// end class
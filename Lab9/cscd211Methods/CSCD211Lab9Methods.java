package cscd211Methods;

import java.util.*;
import cscd211Classes.teams.*;
import cscd211Classes.players.*;
import cscd211Generics.MyArrayList;

/**
 * I have provided the menu method for you.  You must write the fill method. Please look at the file teamlist.txt
 * <br>
 * The file format is City\n Number of teams\n Type, Team Name\n Number of Players\n <br>
 * player name, ssn, salary, position, specific info based on type <br>
 * if football then # of touch downs, jersey number <br>
 * if baseball then batting average <br>
 * if hockey then jersey number <br>
 *
 * @NOTE All parameters passed must be final
 */
public class CSCD211Lab9Methods
{	
   
   /**
    * The menu method ensures a valid choice from 1 to 5 inclusive is entered and returns that value
    * <br> 1 Print all Teams
    * <br> 2 Sort all Teams by city and team name
    * <br> 3 Sort all Teams by Payroll
    * <br> 4 Exit program
    *
    * @param kb Representing a valid Scanner object
    * @return int Representing the menu choice
    *
    * @throws IllegalArgumentException If Scanner is null
    */
   public static int menu(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("Error Precond: Scanner cannot be null - menu");
         
      int choice;
      
      do
      {
         System.out.printf("MENU\n" +
                           "----------\n" +
         "1) Print all Teams.\n" +
         "2) Sort all Teams by city and team name.\n" +
         "3) Sort all Teams by Payroll.\n" +
         "4) Exit program\n" +
         "Choice --> ");
         choice = kb.nextInt();
         kb.nextLine();
      } while (choice < 1 || choice > 4);
      
      return choice;  
   }// end menu

   public static void fill(final Scanner fin, final MyArrayList<Team> theTeams) throws CloneNotSupportedException {
       if (fin == null || theTeams == null) {
           throw new IllegalArgumentException("Input is null");
       }
	   String city;
	   String tName;
	   String type;
	   Player[] temPlay;
	   int teamCount;
	   
	   Team temp = null;
	   fin.useDelimiter(", ");
	   do {
		   city = fin.nextLine();
		   teamCount = Integer.parseInt(fin.nextLine());
		   for (int cnt = 0; cnt < teamCount; cnt++) {
			   type = fin.next();
			   tName = fin.nextLine().substring(2);
			   temPlay = new Player[Integer.parseInt(fin.nextLine())];
			   for (int pl = 0; pl < temPlay.length; pl++) {
				   if (type.equals("Football")) {
					   temPlay[pl] = new FootballPlayer(fin.next(), fin.next(), Integer.parseInt(fin.next()), fin.next(), Integer.parseInt(fin.next()), Integer.parseInt(fin.nextLine().substring(2)));
				   } else if (type.equals("Hockey")) {
					   temPlay[pl] = new HockeyPlayer(fin.next(), fin.next(), Integer.parseInt(fin.next()), fin.next(), Integer.parseInt(fin.nextLine().substring(2)));
				   } else if (type.equals("Baseball")) {
					   temPlay[pl] = new BaseballPlayer(fin.next(), fin.next(), Integer.parseInt(fin.next()), fin.next(), Double.parseDouble(fin.nextLine().substring(2)));
				   } else {
					   temPlay = null;
				   }
			   }
			   temp = new Team(city, tName, temPlay);
			   theTeams.addLast(temp);
		   }
	   } while (fin.hasNextLine());
	   
   }
   
}// end class
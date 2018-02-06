package cscd211Lab6;

import java.io.*;
import java.util.*;
import cscd211Comparator.*;
import cscd211Inheritance.*;

public class CSCD211Lab6
{
   public static void main(String [] args)throws Exception
   {
      ArrayList <Student> myList = new ArrayList<Student>(5);
      myList.add(new Undergrad("Zach Burrow", 887766, 2016));
      myList.add(new Undergrad("Steve Steiner", 777, 2018));
      myList.add(new Grad("Stu Steiner", 666));
      myList.add(new Undergrad("Mehdi Ghazlane", 55556, 2017));
      myList.add(new Grad("Charles Zahara", 665533));
      
      
      for(Student s: myList)
      {
         System.out.println(s);
      }// end for
      System.out.println();
      
      Collections.sort(myList);
      for(Student s: myList)
      {
         System.out.println(s);
      }// end for
      System.out.println();
      
      
      Collections.sort(myList, new TypeSort());
      for(Student s: myList)
      {
         System.out.println(s);
      }// end for
      System.out.println();
      
   }// end main

}// end class
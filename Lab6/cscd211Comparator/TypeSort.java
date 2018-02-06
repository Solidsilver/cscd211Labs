/*
This TypeSort comparator was created by Luke Mattfeld
for CSCD211 at Eastern Washington University
*/

package cscd211Comparator;

import java.util.Comparator;

import cscd211Inheritance.Student;

public class TypeSort implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int comp = s1.getType().compareTo(s2.getType());
		if (comp == 0) {
			Integer id1 = new Integer(s1.getID());
			Integer id2 = new Integer(s2.getID());
			comp = id1.compareTo(id2);
		}
		return comp;
	
	}
	
}

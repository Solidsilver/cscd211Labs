package cscd211Inheritance;
/*
This Grad class was created by Luke Mattfeld
for CSCD211 at Eastern Washington University
*/
public class Grad extends Student {
	
	public Grad(String name, int id) {
		super(name, id);
	}

	@Override
	public String toString() {
		return "Grad Student -- " + super.toString();
	}
	
	
}

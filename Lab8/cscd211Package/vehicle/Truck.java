package cscd211Package.vehicle;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

import cscd211Package.type.Package;
import cscd211Package.type.*;

public class Truck {
	
	private String driver;
	private int load, maxPackages;
	private Package[] thePackages;
	
	public Truck(final String driver, final int maxPackages) {
		this.driver = driver;
		this.maxPackages = maxPackages;
	}

	public String getDriver() {
		return this.driver;
	}
	
	public int getLoad() {
		return this.load;
	}
	
	public int getMaxPackages() {
		return this.maxPackages;
	}
	
	public void drive(final PrintStream fout) {
		Arrays.sort(thePackages);
		fout.println("\nPackages loaded on " + LocalDate.now() + " at " + LocalTime.now());
		
		//When a lack of sleep alters the state of mind to the extent that strange behavior is exhibited in semi-public areas:
		String[] driving = {"Eating Doughnuts", "Refilling Gas", "Testing Autonomous Driving", "Realizing you dropped a package 30 miles back", "Blowout", "Getting ready to get down", "finally put final in every method argument", "Brake Check", "Calling Stu", "Mid-life crisis", "Finally getting back to where you were before the package mix-up", "Bathroom Break"};
		fout.println("Driving:");
		for (int ix = 0; ix < driving.length; ix++) {
			fout.println("• " + driving[ix]);
		}
		fout.println("Arrived at Destination!\n");
	}//End drive
	
	public void load(final Scanner fin, final PrintStream fout) {
		fout.println("Driver: " + this.driver);
		fout.println("Truck Package Capacity: " + this.maxPackages + "\n");
		this.thePackages = new Package[0];
		Package pack;
		String id, errReason = "";
		boolean added = false;
		int type, cnt = 0;
		while (fin.hasNextLine()) {
			fout.print("----- New package -----\nType: ");
			id = fin.nextLine();
			type = Integer.parseInt(id.substring(id.length() - 1));
			switch(type) {
				case 0: pack = new Letter(Integer.parseInt(id), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()));
					break;
				case 1: pack = new Box(Integer.parseInt(id), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()));
					break;
				case 2: pack = new MetalCrate(Integer.parseInt(id), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), fin.nextLine());
					break;
				case 3: pack = new WoodCrate(Integer.parseInt(id), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), Integer.parseInt(fin.nextLine()), fin.nextLine());
					break;
				default: fout.println("unknown"); pack = null;
						fout.println("Package info:");
						fout.println("Tracking Number: " + id);
						for (int ix = 0; ix < 4; ix++) {
							 fout.println(fin.nextLine());
						}
						added = false;
						errReason = "Package type is unknown";
					break;
			}
			if (pack != null) {
				fout.print(pack.getType() + "\n");
				fout.print("Shipping Viability: ");
				if (pack.getTooBig()) {
					added = false;
					errReason = "Package is too big";
					fout.println(errReason + "!");
				} else {
					if (this.thePackages.length == this.maxPackages) {
						added = false;
						errReason = "Truck is full";
						fout.println(errReason + "!");
					} else {
						added = true;
						fout.println("Ready to ship");
						loadPackage(pack, cnt);
						cnt++;
					}
				}
				fout.println("Package info: \n• " + pack);
			}
			if (added) {
				fout.println("Package was loaded successfully");
			} else {
				fout.println("Package was not loaded because " + errReason);
			}
			fout.println();	
		}
	}//End load
	
	public void loadPackage(final Package toAdd, final int index) {
		Package[] cache = this.thePackages;
		thePackages = new Package[this.thePackages.length + 1];
		for (int cnt = 0; cnt < index; cnt++) {
			thePackages[cnt] = cache[cnt];
		}
		thePackages[index] = toAdd;
		for (int cnt = index+1; cnt < thePackages.length; cnt++) {
			thePackages[cnt] = cache[cnt];
		}
	}//End loadPackage
	
	public void printToLog(final PrintStream fout, final String str) {
		// This would just make my code longer... It'd be nice if it was hard-coded to output to log.txt 
		//without needing to pass in a printstream.
		//Ex: printToLog(fout, "Test log"); 
		//vs. fout.println("Test log");      <--- ALL THIS SPACE!!!
		//vs. fout.print("Test Log");        <--- EVEN MORE SPACE!!!
	}
	
	public void unload(final PrintStream fout) {
		fout.println("Unloading Truck...");
		for (int ix = 0; ix < this.thePackages.length; ix++) {
			fout.println("• Package " + (ix+1) + ": " + this.thePackages[ix]);
		}
		fout.println("Packages unloaded");
	}
	
}//End class

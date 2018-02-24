package cscd211Classes.teams;

import cscd211Interfaces.*;
import java.util.ArrayList;
import cscd211Classes.players.*;

public class Team implements Payroll, Taxable, Comparable<Team> {
	
	protected String city, teamName;
	protected int payroll;
	protected ArrayList<Player> players;
	
	public Team(final String city, final String teamName, final Player[] players) throws CloneNotSupportedException {
		if (city.isEmpty() || city == null || teamName.isEmpty() || teamName == null || players == null || players.length <= 0) {
			throw new IllegalArgumentException("Invalid data");
		}
		this.city = city;
		this.teamName = teamName;
		this.players = new ArrayList<Player>();
		for (int ix = 0; ix < players.length; ix++) {
			this.players.add(players[ix].clone());
		}
		this.payroll = this.calculatePayroll();
	}

	public String getCity() {
		return city;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public int getPayroll() {
		return this.payroll;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	@Override
	public int compareTo(final Team pi) {
		if (pi == null) {
			throw new NullPointerException("passed in Player is null");
		}
		int cmp = this.city.compareTo(pi.city);
		if (cmp == 0) {
			cmp = this.teamName.compareTo(pi.teamName);
		}
		return cmp;
	}

	@Override
	public double calculateTaxes() {
		double taxes = 0;
		int sal;
		for(Player pl: this.players) {
			sal = pl.getSalary();
			if (sal > 250000) {
				taxes += sal * this.BASE_TAX_RATE;
			} else {
				taxes += sal * (this.BASE_TAX_RATE - 0.1);
			}
		}
		return taxes;
	}

	@Override
	public int calculatePayroll() {
		int pay = 0;
		for(Player pl: this.players) {
			pay += pl.getSalary();
		}
		return pay + this.BASE_PAYROLL;
	}
	
	@Override
	public String toString() {
		String playerInfo = "";
		for (Player pl: this.players) {
			playerInfo += pl + "\n";
		}
		return this.city + " - " + this.teamName 
				+ "\nPayroll: " + this.payroll 
				+ "\nTaxes: " + this.calculateTaxes()
				+ "\nPlayer Name\tSSN\t\tSalary\t\tPosition\t\tStats\tNumber\n"
				+ "---------------------------------------------------------------------------------------\n"
				+ playerInfo;
	}

}

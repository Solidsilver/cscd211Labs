package cscd211Comparators;

import java.util.Comparator;
import cscd211Classes.teams.Team;

public class TeamPayrollSort implements Comparator<Team> {

	@Override
	public int compare(final Team t1, final Team t2) {
		if (t1 == null || t2 == null) {
			throw new NullPointerException("a passed in Team is null");
		}
		Integer thiS = t1.getPayroll();
		Integer thatS = t2.getPayroll();
		return thiS.compareTo(thatS);
	}

}

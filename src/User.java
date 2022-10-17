
import java.time.LocalDate;

public class User implements Comparable<User> {
	
	private String name;
	private int bestScore;
	private LocalDate dayDone;


	public User(String name, int bestScore, LocalDate dayDone) {
		this.name = name;
		this.bestScore = bestScore;
		this.dayDone = dayDone;
	}

	public String getName() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}
	
	public LocalDate getDayDone() {
		return dayDone;
	}

	public void setDayDone(LocalDate dayDone) {
		this.dayDone = dayDone;
	}
	
	@Override
	public boolean equals(Object otherObj) {
		if (otherObj instanceof User) {
			User otherUser = (User) otherObj;
			
			String otherName = otherUser.name;
			int otherBestScore = otherUser.bestScore;
			
			if (name.equalsIgnoreCase(otherName) &&
				bestScore == otherBestScore) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(User other) {
		if (name.compareToIgnoreCase(other.name) != 0) {
			// the two users have different names - so order based name
			return name.compareToIgnoreCase(other.name);
		} else if (Integer.compare(bestScore, other.bestScore) != 0){
			// the users have the same name and same times table - so order based on best score (highest to lowest!!!!)
			return Integer.compare(other.bestScore, bestScore);
		} else {
			// the users have the same name and same times table and same best score - so order on time
			return dayDone.compareTo(other.dayDone);
		}
	}
	
	@Override
	public String toString() {
		String s = name;
		s += " has a Best Score of: " + bestScore;
		s += " on " + dayDone;
		return s;
	}
	

}

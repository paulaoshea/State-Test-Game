
/**
 * State --- Enum to represent all possible US States
 *              
 * @author Paula OShea
 * @version 1.0
 * @since 2021-01-09
 *        Text Editor used : Eclipse 
 *        Java Version used : Java 8 
 *        Operating system used : MacOS Mojave
 */
public enum State {
	
	AL("Alabama", "Montgomery", "SE"),
	AK("Alaska", "Juneau", "Sp"),
	AZ("Arizona", "Phoenix", "W "),
	AR("Arkansas", "Little Rock", "MW"),
	CA("California", "Sacramento", "W "),
	CO("Colorado", "Denver", "SW"),
	CT("Connecticut", "Hartford", "NE"),
	DE("Delaware", "Dover", "NE"),
	FL("Florida", "Tallahassee", "SE"),
	GA("Georgia", "Atlanta", "SE"),
	HI("Hawaii", "Honolulu", "W "),
	ID("Idaho", "Boise", "SW"),
	IL("Illinois", "Springfield", "MW"),
	IN("Indiana", "Indianapolis", "MW"),
	IA("Iowa", "Des Moines", "S "),
	KS("Kansas", "Topeka", "s "),
	KY("Kentucky", "Frankfort", "SE"),
	LA("Louisiana", "Baton Rouge", "S "),
	ME("Maine", "Augusta", "NE"),
	MD("Maryland", "Annapolis", "NE"),
	MA("Massachusetts", "Boston", "NE"),
	MI("Michigan", "Lansing", "MW"),
	MN("Minnesota", "Saint Paul", "MW"),
	MS("Mississippi", "Jackson", "SE"),
	MO("Missouri", "Jefferson City", "S "),
	MT("Montana", "Helena", "SW"),
	NE("Nebraska", "Lincoln", "SW"),
	NV("Nevada", "Carson City", "SW"),
	NH("New Hampshire", "Concord", "NE"),
	NJ("New Jersey", "Trenton", "NE"),
	NM("New Mexico", "Santa Fe", "S" ),
	NY("New York", "Albany", "NE"),
	NC("North Carolina", "Raleigh", "SE"),
	ND("North Dakota", "Bismarck", "SW"),
	OH("Ohio", "Columbus", "MW"),
	OK("Oklahoma", "Oklahoma City", "SW"),
	OR("Oregon", "Salem", "SW"),
	PA("Pennsylvania", "Harrisburg", "NE"),
	RI("Rhode Island", "Providence", "NE"),
	SC("South Carolina", "Columbia", "SE"),
	SD("South Dakota", "Pierre", "S "),
	TN("Tennessee", "Nashville", "SE"),
	TX("Texas", "Austin", "SW"),
	UT("Utah", "Salt Lake City", "SW"),
	VT("Vermont", "Montpelier", "NE"),
	VA("Virginia", "Richmond", "SE"),
	WA("Washington", "Olympia", "SW"),
	WV("West Virginia", "Charleston", "W "),
	WI("Wisconsin","Madison","MW"),
	WY("Wyoming", "Cheyenne", "SW");

	private String description;
	private String capital;
	private String region;
	
	private State(String description, String capital, String region) {
		this.description = description;
		this.capital = capital;
		this.region = region;
	}
	
	//Do not include 'setters' for the fields - it should not be possible to change them
	
	public String getDescription() {
		return description;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public String getRegion() {
		return region;
	}

	//@Override
	//public String toString() {
	//	return description + "[capital: " + capital + ", region: " + region +"]";
	//}
	
}

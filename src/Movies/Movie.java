package Movies;

public class Movie {

	private String name;

	private int yearOfRelease;

	private String country;

	private int budget;

	Movie(String name, int yearOfRelease, String country, int budget){
		this.name = name;
		this.yearOfRelease = yearOfRelease;
		this.country = country;
		this.budget = budget;
	}

	public String getName() {
		return name;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public String getCountry() {
		return country;
	}

	public int getBudget() {
		return budget;
	}
}

package Movies;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Movie {

	private final SimpleStringProperty name = new SimpleStringProperty();
	private final SimpleStringProperty country =new SimpleStringProperty();
	private final SimpleIntegerProperty yearOfRelease = new SimpleIntegerProperty();
	private final SimpleIntegerProperty budget = new SimpleIntegerProperty();

	Movie(String name, int yearOfRelease, String country, int budget){
		this.setName(name);
		this.setCountry(country);
		this.setYearOfRelease(yearOfRelease);
		this.setBudget(budget);
	}

	public StringProperty getName() {
		return name;
	}
	private void setName(final String name){
		this.name.set(name);
	}

	public StringProperty  getCountry() {
		return country;
	}
	private void setCountry(final String country){
		this.country.set(country);
	}

	public IntegerProperty getYearOfRelease() {
		return yearOfRelease;
	}
	private void setYearOfRelease(final int yearOfRelease){
		this.yearOfRelease.set(yearOfRelease);
	}

	public IntegerProperty getBudget() {
		return budget;
	}
	private void setBudget(final int budget){
		this.budget.set(budget);
	}
}

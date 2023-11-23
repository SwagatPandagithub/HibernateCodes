package in.ineuron.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String cityName;
	private String stateName;
	private String countryName;
	
	
	public Address() {
		System.out.println("The object of the Address class is created by hivbernate...");
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", stateName=" + stateName + ", countryName=" + countryName + "]";
	}
	
	

}

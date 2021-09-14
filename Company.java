import java.util.Comparator;

public class Company implements Comparable<Company>{
	private int salary;
	private String name;
	private String location;

	public static final Comparator<Company> NAME = new NameComparator();
	public static final Comparator<Company> LOCATION = new LocationComparator();

	public Company(int salary, String name, String location){
		this.salary = salary;
		this.name = name;
		this.location = location;
	}

	public String toString(){
		return "The company " + name + ", which is located at " + location + " provides the basic salary of " + salary + " US dollars to its emmployees.";
	}

	public int compareTo(Company other){
		return this.salary - other.salary;
	}

	public int getSalary(){
		return salary;
	}

	public String getName(){
		return name;
	}

	public String getLocation(){
		return location;
	}

  public String getPhoto(){
    return name + ".jpg";
  }

	static class NameComparator implements Comparator<Company>{
		public int compare(Company firstCompany, Company secondCompany){
			return (firstCompany.name).compareTo(secondCompany.name);
	   }
    }

   static class LocationComparator implements Comparator<Company>{
	    public int compare(Company firstCompany, Company secondCompany){
			return (firstCompany.location).compareTo(secondCompany.location);
		}
	}
}    

class Employee extends Company {
	private int age;

	public Employee(int salary, String name, String location, int age){
		super(salary, name, location);
		this.age = age;
	}

	public String toString(){
		return "Most of the employers at this company are of age " + age;
	}

	public int compareTo(Employee other){
		return this.age - other.age;
	}

  public int getAge(){
    return age;
  }
}

class Outreach extends Company {
	private int numOfCountries;

	public Outreach(int salary, String name, String location, int numOfCountries){
		super(salary, name, location);
		this.numOfCountries = numOfCountries;
	}

	public String toString(){
		return "The total number of countries in which this company is located is " + numOfCountries;
	}

	public int compareTo(Outreach other){
		return this.numOfCountries - other.numOfCountries;
	}

  public int getNumOfCountries(){
    return numOfCountries;
  }
}

class EmployeeVacation extends Employee {
	private int vacation;

	public EmployeeVacation(int salary, String name, String location, int age, int vacation){
		super(salary, name, location, age);
		this.vacation = vacation;
	}

	public String toString(){
		return "Most of the employers at this company has a vacation of " + vacation + " months per year.";
	}

	public int compareTo(EmployeeVacation other){
		return this.vacation - other.vacation;
	}

  public int getVacation(){
    return vacation;
  }
}
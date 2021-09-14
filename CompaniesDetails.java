import java.util.Arrays;

public class CompaniesDetails{
	public static void main(String[] args){
		In file = new In("companies.csv");
		int n = Integer.parseInt(file.readline());
		Company[] fav = new Company[n];

		for (int i=0; i<n; i++){
			String[] items = line.split(",");
			System.out.println(items[1]);
			int salary = Integer.parseInt(items[0].trim());
			fav[i] = new Company(salary, items[1], items[2]);
		}

		System.out.print("Salary, Company Name, Location");
		Arrays.sort(fav);

		for (Company c: fav){
			System.out.println(c);
		}

		In file2 = new In("employees.csv");
		int n2 = Integer.parseInt(file.readline());
		Employee[] fav2 = new Employee[n2];

		for (int i=0; i<n2; i++){
			String[] items = line.split(",");
			System.out.println(items[1]);
			int salary = Integer.parseInt(items[0].trim());
			int age = Integer.parseInt(items[3].trim());
			fav2[i] = new Employee(salary, items[1], items[2], age);
		}

		System.out.print("Salary, Company Name, Location, Age");
		Arrays.sort(fav2);

		for (Employee c: fav2){
			System.out.println(c);
		}

		In file3 = new In("outreach.csv");
		int n3 = Integer.parseInt(file.readline());
		Outreach[] fav3 = new Outreach[n3];

		for (int i=0; i<n3; i++){
			String[] items = line.split(",");
			System.out.println(items[1]);
			int salary = Integer.parseInt(items[0].trim());
			int num = Integer.parseInt(items[3].trim());
			fav3[i] = new Outreach(salary, items[1], items[2], num);
		}

		System.out.print("Salary, Company Name, Location, NumOfCountries");
		Arrays.sort(fav3);

		for (Outreach c: fav3){
			System.out.println(c);
		}

		In file4 = new In("employeevacation.csv");
		int n4 = Integer.parseInt(file.readline());
		EmployeeVacation[] fav4 = new EmployeeVacation[n4];

		for (int i=0; i<n4; i++){
			String[] items = line.split(",");
			System.out.println(items[1]);
			int salary = Integer.parseInt(items[0].trim());
			int age = Integer.parseInt(items[3].trim());
			int vacation = Integer.parseInt(items[4].trim());
			fav4[i] = new EmployeeVacation(salary, items[1], items[2], age, vacation);
		}

		System.out.print("Salary, Company Name, Location, Age, VacationTime(months)");
		Arrays.sort(fav4);

		for (EmployeeVacation c: fav4){
			System.out.println(c);
		}
	}
}
import java.util.Scanner;
import java.lang.Math;

public class Employee {
	static String firstName;

	static String lastName;

	static String type;

	static double hours;

	static String salary;

	static double wage;

	static double amount;

	static String print;

	static String print2;

	static String finalSalary;

	static String bonus;

	static String finalHours;

	static String finalRate;



	//constructor for employee class

	public Employee(String first, String last)

	{

	}



	//Set firstName

	


	//Main method

	public static void main (String[] args) 

	{

	Scanner scan = new Scanner(System.in);

	System.out.println("Welcome to the Payroll System");
	
	/*System.out.println("How many employees are you checking payroll?");
	scan.nextDouble();*/



	System.out.print("\nEnter your first and last name:");

	firstName = scan.next();

	lastName = scan.next();

	System.out.print("Hourly or Salaried employee?");

	type = scan.next();


	if (type.equalsIgnoreCase("hourly")) 

	{

	System.out.print("Hours worked this week?");

	hours = scan.nextDouble();

	finalHours = Double.toString(hours);

	System.out.print("What is the hourly wage?");

	wage = scan.nextDouble(); 

	finalRate = Double.toString(wage);

	HourlyEmployee employee = new HourlyEmployee(firstName, lastName, hours, wage);

	print = employee.toString();

	System.out.print(print);


	}


	else if (type.equalsIgnoreCase("salaried"))

	{

	System.out.print("What is the salary amount?");

	amount = scan.nextDouble();

	finalSalary = Double.toString(amount);

	SalariedEmployee employee = new SalariedEmployee(firstName, lastName, amount);

	print = employee.toString();

	System.out.println(print);

	System.out.print("Does this employee recieve a 10% bonus?");

	bonus = scan.next();



	if (bonus.equals("yes"))

	{

	print2 = employee.bonusString();

	System.out.print(print2);

	}


	}

	}

	}





	//Salaried Employee class

	class SalariedEmployee extends Employee 

	{

	double fixedSalary;

	static String hourlySalary;

	static double amount2;

	static double amount3;

	static String finalSalary2;



	//constructor in a new class that is called Salaried Employee

	public SalariedEmployee(String first, String last, double fixed)

	{

	super(first,last);

	setFixedSalary(fixed);

	bonusSalary(fixed);

	}


	//set salary

	public void setFixedSalary(double fixed)

	{

	if(fixed < 0.0)

	{

	amount = 0.0;

	}


	else 

	{

	amount2 = fixed/40; 

	}

	hourlySalary = Double.toString(amount2);

	}



	//bonus 10% 

	public void bonusSalary(double fixed)

	{

	amount3 = amount * 1.10;

	amount3 = Math.round(amount3 * 100)/100.00;

	finalSalary2 = Double.toString(amount3);

	}





	//convert all to strings without bonus 

	//first name, last name, status, hour, rate, weekly pay

	public String toString()

	{

	return String.format("%s %s %s N/A $%s $%s", firstName, lastName, type, hourlySalary, finalSalary );

	}



	//with 10% bonus

	public String bonusString()

	{

	return String.format("%s %s %s N/A $%s $%s*", firstName, lastName, type, hourlySalary, finalSalary2);

	}

	}



	//Hourly Employee class

	class HourlyEmployee extends Employee 

	{

	static double weekPay;

	static String weekTotal;



	//constructor in a new class that is called HourlyEmployee

	public HourlyEmployee(String first, String last, double hoursWorked, double hourlyRate)

	{

	super(first,last); 

	earnings(hoursWorked,hourlyRate);

	}



	//Earnings constructor for hourly employee

	public void earnings(double hoursWorked, double hourlyRate)

	{

	//no overtime 

	if ( hoursWorked <= 40 )

	{

	weekPay = hoursWorked * hourlyRate;

	}


	//overtime

	else

	{

	weekPay = (((hoursWorked - 40) * 2 * hourlyRate) + (40 * hourlyRate) );

	}

	weekTotal = Double.toString(weekPay);

	}



	//convert all strings

	//first name, last name, status, hour, rate, weekly pay amount

	public String toString()

	{

	return String.format("%s %s %s %s $%s $%s", firstName, lastName, type, finalHours, finalRate, weekTotal);

	} 
	
	}
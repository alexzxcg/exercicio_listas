import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.println("How many employees will be registered?");
		int N = sc.nextInt();
		
		for (int i = 0; i<N; i++) {
			
			System.out.println();
			System.out.println("Emplyoee #" + (i + 1) + ":");
			System.out.println("Id: ");
			Integer id = sc.nextInt();
			while(hasId(list, id)) {
				System.out.println("Id already taken! Try again: "); //Verifica id.
			}			
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.println("Enter the employee id that will have salary increase : ");
		int idSalary = sc.nextInt();
		
		// Busca employee com funcao lambda.
		// Employee e = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
		// Busca employee com uma funcao normal.
		Integer pos = position(list, idSalary);
		
		if(pos == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.println("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employee");
		
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		
		sc.close();
		

	}	
	// Funcao para varrer a lista e verificar a existencia do employee.
	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	// Funcao para varrer a lista de employee e verificar se o id ja esta em uso.
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}

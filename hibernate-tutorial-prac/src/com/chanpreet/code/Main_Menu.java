package com.chanpreet.code;

import java.util.Scanner;

public class Main_Menu {

	public static void main(String[] args) {
		int ch;
		while(true){
				System.out.println("\n\nWelcome to Hibernate CRUD example");
				System.out.println("\n\n\t\tMAIN MENU");
				System.out.println("\t\t1. Add a new Employee");
				System.out.println("\t\t2. Show all Employees");
				System.out.println("\t\t3. Find Employee by Id");
				System.out.println("\t\t4. Update Employee Details");
				System.out.println("\t\t5. Delete an Employee");
				System.out.println("\t\t6. Exit");
				System.out.print("\nPlease enter a choice:");
				Scanner sc=new Scanner(System.in);
				ch=sc.nextInt();
				switch(ch){
				
				case 1: Operations.createEmployee();
					break;
				
				case 2: Operations.showAllEmployees();
					break;
				
				case 3: Operations.findEmployeeById();
					break;
				
				case 4: Operations.updateEmployeeDetails();
					break;
				
				case 5: Operations.deleteEmployee();
					break;
				
				case 6: System.out.println("Abording!!");
						sc.close();
						System.exit(0);
					break;
				}
				
				
			}
  }
}

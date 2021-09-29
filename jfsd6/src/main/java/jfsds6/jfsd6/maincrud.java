package jfsds6.jfsd6;

import java.util.Scanner;



public class maincrud {

	public static void main(String[] args) {
		bean sb=new bean();
		 Scanner scan = new Scanner(System.in);
		 while(true) {
		 System.out.print("Interactive hibernate:\n 1.Insert a employee\n 2.Update a employee with maximum salary \n 3.Delete a employee with minimum salary \n 4.Display a employee  ");
		 System.out.print("\nselect any option: ");
		 int num = scan.nextInt();
		switch (num) {
		  case 1:
			  System.out.print("enter new registerno: ");
			  int id= scan.nextInt();
			  System.out.print("enter name of employee: ");
			  String name= scan.next();
			  System.out.print("enter dept of employee:");
			  String dept= scan.next();
			  System.out.print("enter sal of employee:");
			  double sal= scan.nextDouble();
			  System.out.print("enter age of employee:");
			  int age= scan.nextInt();
			    sb.setEid(id);
				sb.setEname(name);
				sb.setDept(dept);
				sb.setSalary(sal);
				sb.setAge(age);
				
				App si= new App();
				si.insert(sb);
				break;
				
				
		  case 2:
			  System.out.print("enter existed registerno: ");
			  int id1= scan.nextInt();
			  
			  sb.setEid(id1);
				
			
			App si1= new App();
			si1.update(sb);
			break;
		  case 3:
			  
				
			  App si12= new App();
				 si12.delete();
				break;
		  case 4:
			  System.out.print("enter existed registerno: ");
		     int regno3= scan.nextInt();
		  sb.setEid(regno3);
		  App si123= new App();
			si123.display(sb);
			break;
		  
			  
			
		 }
		

	}
	}
}



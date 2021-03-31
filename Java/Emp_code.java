import java.util.*;

class Employee{
    String name;
    int empid;
    int salary;
    public void getValues(Employee e){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the employee details as name, empid, salary: ");
        e.name = s.next();
        e.empid = s.nextInt();
        e.salary = s.nextInt();
    }

    public void sortprint(Employee e[]){
        int n = e.length;
        for (int i=0;i<e.length-1;i++){
            for (int j=i+1;j<e.length;j++){
                if (e[i].salary>e[j].salary){
                    Employee t;
                    t = e[i];
                    e[i] = e[j];
                    e[j] = t;
                }
                else{continue;}
            }
        }

        // Salaries less than 100000
        System.out.println("\nEmployee details for salaries less than 100000 in ascending order: \n");
        for (int i =0;i<n;i++){
            if (e[i].salary<100000){
                System.out.println("Name: "+e[i].name);
                System.out.println("Emp-ID: "+e[i].empid);
                System.out.println("\n");
            }
        }

        // Details for salaries in ascending order
        System.out.println("\n\nEmployee details based on ascending order salaries: \n");
        for (int i=0;i<n;i++){
            System.out.println("Name: "+e[i].name);
            System.out.println("Emp-ID: "+e[i].empid);
            System.out.println("Salary: "+e[i].salary);
            System.out.println("\n");
        }
    }
}


public class Emp_code{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of employees: ");
        int n = s.nextInt();
        Employee emp[] = new Employee[n];
        for (int i=0 ;i<n; i++){
            emp[i] = new Employee();
            emp[i].getValues(emp[i]);
        }
        Employee new1 = new Employee();
        new1.sortprint(emp);
    }
}
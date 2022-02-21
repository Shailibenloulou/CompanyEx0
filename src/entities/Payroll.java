package entities;

import java.util.Scanner; //get input from user

public class Payroll {
    public static void main(String[] args) {
        Employee[] employees=new Employee[3];
        employees[0]=new HourlyEmployee();
        employees[1]=new CommissionEmployee();
        employees[2]=new BasePlusCommissionEmployee();
        Scanner scan = new Scanner(System.in);

        for(Employee e: employees) //get 3 worker's details
        {
            System.out.println("Enter employee's first name, last name and id");
            e.setFirstName(scan.next());
            e.setLastName(scan.next());
            e.setId(scan.nextInt());
            if(e.getClass()==HourlyEmployee.class) {
                System.out.println("Enter employee's hours and wage");
                try {
                    ((HourlyEmployee) e).setHours(scan.nextInt());
                    ((HourlyEmployee) e).setWage(scan.nextFloat());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            else {
                System.out.println("Enter employee's gross Sales and commission");
                try {
                    ((CommissionEmployee) e).setGrossSales(scan.nextFloat());
                    ((CommissionEmployee) e).setCommission(scan.nextInt());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                if(e.getClass()==BasePlusCommissionEmployee.class) {
                    System.out.println("Enter base salary");
                    try {
                        ((BasePlusCommissionEmployee) e).setBaseSalary(scan.nextFloat());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

        for(Employee e: employees) //print the 3 worker's details
        {
            System.out.println(e.toString());
            if(e.getClass()==BasePlusCommissionEmployee.class)
                System.out.println("Salary=" + String.format("%.2f", e.earnings()* 1.1));
            else
                System.out.println("Salary=" + String.format("%.2f", e.earnings()));
        }
    }
}

/*"C:\Program Files\Java\jdk-17.0.2\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.2\lib\idea_rt.jar=58588:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\שילי\IdeaProjects\CompanyEx0\out\production\CompanyEx0 entities.Payroll
0 hours must be positive
0.0 grossSales must be positive
0.0 grossSales must be positive
0.0 baseSalary must be positive
Enter employee's first name, last name and id
shaili
benloulou
328606058
Enter employee's hours and wage
120
100
Enter employee's first name, last name and id
chaya
philips
11111111
Enter employee's gross Sales and commission
123456
200
Enter employee's first name, last name and id
renana
benchaim
22222222
Enter employee's gross Sales and commission
987654
170
Enter base salary
1200
HourlyEmployee{firstName='shaili', lastName='benloulou', id=328606058, hours=120, wage=100.0}
Salary=12000,00
CommissionEmployee{firstName='chaya', lastName='philips', id=11111111, grossSales=123456.0', commission=200'}
Salary=246912,00
BasePlusCommissionEmployee{firstName='renana', lastName='benchaim', id=22222222, grossSales=987654.0', commission=170', baseSalary=1200.0'}
Salary=1087739,40

Process finished with exit code 0*/
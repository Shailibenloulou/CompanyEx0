package entities;

public class Payroll {
    public static void main(String[] args) {
        Employee[] employees=new Employee[3];
        employees[0]=new HourlyEmployee();
        employees[1]=new CommissionEmployee();
        employees[2]=new BasePlusCommissionEmployee();

       //input

        for(Employee e: employees)
        {
            System.out.println(e.toString());
            if(e.getClass()==BasePlusCommissionEmployee.class)
                System.out.println("Salary="+e.earnings()*1.1);
            else
                System.out.println("Salary="+e.earnings());
        }
    }
}
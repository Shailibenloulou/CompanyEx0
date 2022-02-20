package entities;

import java.util.Objects;

//represent an employee who receives a fix salary plus a percentage of the profits he earned
public class BasePlusCommissionEmployee extends CommissionEmployee{
    private float baseSalary;

    //constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, int id, float grossSales, int commision, float baseSalary) {
        super(firstName, lastName, id, grossSales, commision);
        try {
            setBaseSalary(baseSalary);
        }
        catch (Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }

    //default constructor
    public BasePlusCommissionEmployee() {
        //super(); default
        try {
            setBaseSalary(0);
        }
        catch (Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) throws Exception {
        if(baseSalary<=0)
            throw new Exception(baseSalary+" baseSalary must be positive");
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                "baseSalary=" + baseSalary +
                ", grossSales=" + grossSales +
                ", commision=" + commision +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BasePlusCommissionEmployee that = (BasePlusCommissionEmployee) o;
        return Float.compare(that.baseSalary, baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    //returns the salary of the worker
    @Override
    public float earnings() {
        return getBaseSalary() + super.earnings();
    }
}
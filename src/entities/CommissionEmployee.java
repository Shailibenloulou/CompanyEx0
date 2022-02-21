package entities;

import java.util.Objects;

//the class represent a worker who receives a salary according to the profits he has brought to the company.
public class CommissionEmployee extends Employee{
    protected float grossSales; //week's benefit
    protected int commission; //Percentage commission

    //constructor
    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commission) {
        super(firstName, lastName, id);
        try {
            setGrossSales(grossSales);
            setCommission(commission);
        }
        catch(Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }

    //default constructor
    public CommissionEmployee() {
        //super(); default
        try {
            setGrossSales(0);
            setCommission(0);
        }
        catch(Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }

    public float getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(float grossSales) throws Exception {
        if(grossSales<=0)
            throw new IllegalArgumentException(grossSales+" grossSales must be positive");
        this.grossSales = grossSales;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) throws Exception {
        if(commission<=0)
            throw new IllegalArgumentException(commission+" commission must be positive");
        this.commission = commission;
    }


    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", grossSales=" + grossSales + '\'' +
                ", commission=" + commission + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommissionEmployee that = (CommissionEmployee) o;
        return Float.compare(that.grossSales, grossSales) == 0 && commission == that.commission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grossSales, commission);
    }

    //returns the salary of the worker
    @Override
    public float earnings() {
        return (getCommission()/100)*getGrossSales();
    }
}
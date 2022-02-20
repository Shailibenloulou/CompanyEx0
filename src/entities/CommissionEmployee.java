package entities;

import java.util.Objects;

//the class represent a worker who receives a salary according to the profits he has brought to the company.
public class CommissionEmployee extends Employee{
    protected float grossSales; //week's benefit
    protected int commision; //Percentage commission

    //constructor
    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commision) {
        super(firstName, lastName, id);
        try {
            setGrossSales(grossSales);
            setCommision(commision);
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
            setCommision(0);
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
            throw new Exception(grossSales+" grossSales must be positive");
        this.grossSales = grossSales;
    }

    public int getCommision() {
        return commision;
    }

    public void setCommision(int commision) throws Exception {
        if(commision<=0)
            throw new Exception(commision+" commision must be positive");
        this.commision = commision;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "grossSales=" + grossSales +
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
        CommissionEmployee that = (CommissionEmployee) o;
        return Float.compare(that.grossSales, grossSales) == 0 && commision == that.commision;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grossSales, commision);
    }

    //returns the salary of the worker
    @Override
    public float earnings() {
        return (getCommision()/100)*getGrossSales();
    }
}
package entities;

import java.net.SocketOption;
import java.util.Objects;

public class HourlyEmployee extends Employee{
    private int hours;
    private float wage;

    public HourlyEmployee(String firstName, String lastName, int id, int hours, float wage) {
        super(firstName, lastName, id);
        try {
            setHours(hours);
            setWage(wage);
        }
        catch(Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }

    public HourlyEmployee() {
        //super(); default
        try {
            setHours(0);
            setWage(0);
        }
        catch(Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) throws Exception {
        if(hours<=0)
            throw new IllegalArgumentException(hours+" hours must be positive");
        this.hours = hours;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) throws Exception {
        if(wage<=0)
            throw new IllegalArgumentException(wage+" wage must be positive");
        this.wage = wage;
    }


    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", hours=" + hours +
                ", wage=" + wage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return hours == that.hours && Float.compare(that.wage, wage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hours, wage);
    }

    //returns the salary of the worker
    @Override
    public float earnings() {
        return getHours() * getWage();
    }
}
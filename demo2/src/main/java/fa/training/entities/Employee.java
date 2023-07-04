package fa.training.entities;

import java.time.LocalDate;

public class Employee{

    private int employeeId;

    private String employeeName;

    private boolean gender;

    private LocalDate birthDate;

    private double salary;

    private Department department;


    public Employee() {

    }

    public Employee(int employeeId, String employeeName, boolean gender, LocalDate birthDate, double salary, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.salary = salary;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
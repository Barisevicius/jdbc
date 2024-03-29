package program.Entity;

import java.time.LocalDate;
import java.util.List;


public class Employee {

    private Integer emp_no;


    private String firstName;


    private String lastName;


    private LocalDate birthDate;


    private LocalDate hireDate;

    private List<Salary> salary;

    public Employee() {
    }

    public Employee(Integer emp_no, String firstName, String lastName, LocalDate birthDate, LocalDate hireDate, List<Salary> salary) {
        this.emp_no = emp_no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Integer getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(Integer emp_no) {
        this.emp_no = emp_no;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public List<Salary> getSalary() {
        return salary;
    }

    public void setSalary(List<Salary> salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                emp_no +
                " " + firstName  +
                " " + lastName +
                " " + birthDate +
                " " + hireDate +
            " " + salary;


    }
}

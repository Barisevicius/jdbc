package program.db;

import program.DataSource;
import program.Entity.Employee;
import program.Entity.Salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DBUtils {

    public DBUtils(){}

    public static void executeStmt(String sql, Consumer<PreparedStatement> cmd){
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            cmd.accept(preparedStatement);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Employee> showEmployee() {
        List<Employee> listas = new ArrayList<>();
        List<Salary> salIstas = new ArrayList<>();
        try {
            Connection connection = DataSource.getConnection();
            String sql ="SELECT * FROM  employees INNER JOIN salaries ON  salaries.emp_no = employees.emp_no LIMIT 20";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        Employee employee = new Employee();
        employee.setEmp_no(rs.getInt("emp_no"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setBirthDate(rs.getDate("birth_date").toLocalDate());
        employee.setHireDate(rs.getDate("hire_date").toLocalDate());
        Salary salary = new Salary();
        salary.setToDate(rs.getDate("to_date").toLocalDate());
        salary.setFromDate(rs.getDate("from_date").toLocalDate());
        salary.setSalary(rs.getInt("salary"));
        salIstas.add(salary);
        employee.setSalary(salIstas);

        listas.add(employee);

        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listas;
    }

    public static List<Employee> updSalaries(List<Employee> emp) {
        List<Salary> salary = new ArrayList<>();
        try{
            Connection conn = DataSource.getConnection();
            String sql =  "SELECT * FROM salaries";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            for(int i =0; i < emp.size(); i++){

                if(emp.get(i).getEmp_no() == rs.getInt("emp_no")){
                    Salary sal = new Salary();
                    sal.setFromDate(rs.getDate("from_date").toLocalDate());
                    sal.setToDate(rs.getDate("to_date").toLocalDate());
                    sal.setSalary(rs.getInt("salary"));
                    salary.add(sal);
                    emp.get(i).setSalary(salary);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;


    }
}

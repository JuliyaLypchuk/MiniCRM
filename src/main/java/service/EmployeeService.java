package service;

import entity.Employee;
import enumTypes.Gender;
import enumTypes.Position;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public interface EmployeeService {
    Long add(Employee employee);
    List<Employee> findAll();
    boolean delete(Long id);

    boolean changeEmployer(Employee oldEmployee, Employee newEmployee);
    boolean changePosition(Long id, Position position);
    boolean changeName(Long id, String name);
    boolean changeSurname(Long id, String surname);
    boolean changeAge(Long id, Integer age);
    boolean changeSex(Long id, Gender sex);

    Long findIdEmployer(Employee employee);
    List<Employee> findBySomeStringParam(String someParam);
    List<Employee> findByAge(Integer ninAge, Integer maxAge);

    boolean isCreatedEmployee(Employee employee);
}

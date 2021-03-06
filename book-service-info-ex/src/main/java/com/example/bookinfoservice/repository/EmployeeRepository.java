package com.example.bookinfoservice.repository;
import com.example.bookinfoservice.model.Employee;
import com.example.bookinfoservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllBy();
    Employee findByEmployeeId(int employee_id);
    @Query(value="select e from Employee e where e.user.userName=?1")
    List<Employee> findAllByuserUserName(String user_email);
    Employee findByUserEquals(User user);
    @Query(value = "SELECT * FROM public.employee e INNER JOIN public.user u ON e.user_id = u.user_id WHERE u.location_id = ?1",nativeQuery = true)
    List<Employee> findallUsersByLocationId(int location_id);
}
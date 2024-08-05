package crud_operation_spring.crud_operation_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud_operation_spring.crud_operation_spring.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel , Long> {

}

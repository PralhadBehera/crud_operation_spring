package crud_operation_spring.crud_operation_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import crud_operation_spring.crud_operation_spring.model.EmployeeModel;
import crud_operation_spring.crud_operation_spring.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeModel> getAllEmployeeService(){
        return employeeRepository.findAll();
    }

    public EmployeeModel createEmployeeService(EmployeeModel Employee){
        return this.employeeRepository.save(Employee);
    }

    public void deleteEmployeeService(Long id){
        this.employeeRepository.deleteById(id);
    }

    public EmployeeModel getAllEmployeeIdService(Long id){
        return this.employeeRepository.findById(id).orElse(null);
        
    }

    public EmployeeModel updateEmployeeService(Long id, EmployeeModel Employee){
        Optional<EmployeeModel> OptionalEmployee = this.employeeRepository.findById(id);
        if(OptionalEmployee.isPresent()){
            EmployeeModel ExistingEmployee = OptionalEmployee.get();
            ExistingEmployee.setName(Employee.getName());
            ExistingEmployee.setEmail(Employee.getEmail());
            EmployeeModel updatedEmployee = this.employeeRepository.save(ExistingEmployee);
            return updatedEmployee;
        }
        else{
            throw new EntityNotFoundException("Employee not found with ID: " + id);
        }
    }
}

package crud_operation_spring.crud_operation_spring.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crud_operation_spring.crud_operation_spring.model.EmployeeModel;
import crud_operation_spring.crud_operation_spring.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/getAllEmp") 
    public List<EmployeeModel> getAllEmployee(){
        return this.employeeService.getAllEmployeeService();
    }

    @PostMapping("/createEmp")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel Employee) {
       return this.employeeService.createEmployeeService(Employee);
    }

    @GetMapping("/getEmpById")
            public EmployeeModel getEmployeeById(@RequestParam Long id){
                return this.employeeService.getAllEmployeeIdService(id);
            }
    

    @DeleteMapping("/deleteEmp")
    public ResponseEntity<String>  deleteEmployee(@RequestParam Long id){
        EmployeeModel Employee = this.getEmployeeById(id);
        if(Employee!=null){
            this.employeeService.deleteEmployeeService(id);
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateEmp")
    public ResponseEntity<EmployeeModel> updateEmployee(@RequestParam Long id, @RequestBody EmployeeModel updatedEmployee) { // **Changed**: Use @PathVariable
        EmployeeModel updated = this.employeeService.updateEmployeeService(id, updatedEmployee);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK); // **Changed**: Return ResponseEntity with updated employee and status 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // **Changed**: Return ResponseEntity with status 404 NOT FOUND
        }
    
}

}
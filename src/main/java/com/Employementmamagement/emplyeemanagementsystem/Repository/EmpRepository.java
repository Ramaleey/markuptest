package com.Employementmamagement.emplyeemanagementsystem.Repository;

import Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Long> {
}

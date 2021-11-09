package com.example.hisproject.service;

import com.example.hisproject.entity.Department;
import com.example.hisproject.mapper.DepartmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public void insertDepartment(Department department){
        departmentMapper.insert(department);
    }

    public void deleteDepartment(Long id){
        departmentMapper.deleteById(id);
    }

    public List<Department> getAllDepartments(){
        return departmentMapper.list();
    }
}

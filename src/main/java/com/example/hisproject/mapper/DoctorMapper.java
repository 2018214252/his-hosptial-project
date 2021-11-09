package com.example.hisproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hisproject.entity.Department;
import com.example.hisproject.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {
    @Select("select * from doctor")
    List<Doctor> list();
    @Update("UPDATE doctor set name = #{name}, department = #{department}, details = #{details} where id = #{id}")
    public void updateDot(Doctor doctor);
    @Select("select * from doctor where department = #{dname}")
    List<Doctor> getDotByD(String dname);
}

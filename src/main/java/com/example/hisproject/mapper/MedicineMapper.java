package com.example.hisproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hisproject.entity.Department;
import com.example.hisproject.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MedicineMapper extends BaseMapper<Medicine> {
    @Select("select * from medicine")
    List<Medicine> list();

    @Update("update medicine set name = #{name}, inventory = #{inventory}, price = #{price}, details = #{details} where id = #{id}")
    public void update(Medicine medicine);

}
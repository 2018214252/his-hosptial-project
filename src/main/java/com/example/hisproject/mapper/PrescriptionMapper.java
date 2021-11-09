package com.example.hisproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hisproject.entity.Prescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PrescriptionMapper extends BaseMapper<Prescription> {
    @Select("select * from prescription where pid = #{id}")
    List<Prescription> getPrescription(Long id);
}

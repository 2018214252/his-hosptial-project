package com.example.hisproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hisproject.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PatientMapper extends BaseMapper<Patient> {
}

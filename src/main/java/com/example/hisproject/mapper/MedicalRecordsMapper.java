package com.example.hisproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hisproject.entity.MedicalRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MedicalRecordsMapper extends BaseMapper<MedicalRecords> {

}

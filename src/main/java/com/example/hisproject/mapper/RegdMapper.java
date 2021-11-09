package com.example.hisproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hisproject.entity.Medicine;
import com.example.hisproject.entity.Regd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RegdMapper extends BaseMapper<Regd> {
    @Select("select * from regd where patient = #{id}")
    public List<Regd> getRByP(Long id);

    @Select("select * from regd where doctor = #{id}")
    public List<Regd> getRByD(Long id);

    @Select("select * from regd where id = #{id}")
    Regd getRById(Long id);

    @Update("update regd set flag = #{flag} where id = #{id}")
    public void update(Regd regd);
}

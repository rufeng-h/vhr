package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Admin;

import java.util.List;

import com.windcf.vhr.model.query.AdminQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-15 16:11
 * @package com.windcf.vhr.mapper
 * @description admin mapper
 */

@Mapper
public interface AdminMapper {
    int deleteByPrimaryKey(Long adminId);

    int insert(Admin record);

    int insertOrUpdate(Admin record);

    int insertOrUpdateSelective(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int updateBatch(List<Admin> list);

    int updateBatchSelective(List<Admin> list);

    int batchInsert(@Param("list") List<Admin> list);

    Admin selectByExample(@Param("query") AdminQuery query);
}
package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Admin;
import java.util.List;
import com.windcf.vhr.model.query.AdminQuery;import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-22 17:15
 * @package com.windcf.vhr.mapper
 * @description TODO
 */

@Mapper
public interface AdminMapper {
    /**
     * delete by primary key
     *
     * @param adminId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long adminId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Admin record);

    int insertOrUpdate(Admin record);

    int insertOrUpdateSelective(Admin record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Admin record);

    /**
     * select by primary key
     *
     * @param adminId primary key
     * @return object by primary key
     */
    Admin selectByPrimaryKey(Long adminId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Admin record);

    int updateBatch(List<Admin> list);

    int updateBatchSelective(List<Admin> list);

    int batchInsert(@Param("list") List<Admin> list);

    Admin selectByExample(@Param("query") AdminQuery query);
}
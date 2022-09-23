package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Job;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-22 17:15
 * @package com.windcf.vhr.mapper
 * @description TODO
 */

@Mapper
public interface JobMapper {
    /**
     * delete by primary key
     *
     * @param jobId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long jobId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Job record);

    int insertOrUpdate(Job record);

    int insertOrUpdateSelective(Job record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Job record);

    /**
     * select by primary key
     *
     * @param jobId primary key
     * @return object by primary key
     */
    Job selectByPrimaryKey(Long jobId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Job record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Job record);

    int updateBatch(List<Job> list);

    int updateBatchSelective(List<Job> list);

    int batchInsert(@Param("list") List<Job> list);
}
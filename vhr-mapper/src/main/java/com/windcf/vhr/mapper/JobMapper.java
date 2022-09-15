package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Job;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-15 14:28
 * @package com.windcf.vhr.mapper
 * @description TODO
 */

@Mapper
public interface JobMapper {
    int deleteByPrimaryKey(Long jobId);

    int insert(Job record);

    int insertOrUpdate(Job record);

    int insertOrUpdateSelective(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Long jobId);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);

    int updateBatch(List<Job> list);

    int updateBatchSelective(List<Job> list);

    int batchInsert(@Param("list") List<Job> list);
}
package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Major;
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
public interface MajorMapper {
    int deleteByPrimaryKey(String majorId);

    int insert(Major record);

    int insertOrUpdate(Major record);

    int insertOrUpdateSelective(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(String majorId);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    int updateBatch(List<Major> list);

    int updateBatchSelective(List<Major> list);

    int batchInsert(@Param("list") List<Major> list);
}
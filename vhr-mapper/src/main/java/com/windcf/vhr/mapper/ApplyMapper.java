package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Apply;
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
public interface ApplyMapper {
    int deleteByPrimaryKey(Long apyId);

    int insert(Apply record);

    int insertOrUpdate(Apply record);

    int insertOrUpdateSelective(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Long apyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    int updateBatch(List<Apply> list);

    int updateBatchSelective(List<Apply> list);

    int batchInsert(@Param("list") List<Apply> list);
}
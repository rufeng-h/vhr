package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Industry;
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
public interface IndustryMapper {
    int deleteByPrimaryKey(String indId);

    int insert(Industry record);

    int insertOrUpdate(Industry record);

    int insertOrUpdateSelective(Industry record);

    int insertSelective(Industry record);

    Industry selectByPrimaryKey(String indId);

    int updateByPrimaryKeySelective(Industry record);

    int updateByPrimaryKey(Industry record);

    int updateBatch(List<Industry> list);

    int updateBatchSelective(List<Industry> list);

    int batchInsert(@Param("list") List<Industry> list);
}
package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Area;
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
public interface AreaMapper {
    int deleteByPrimaryKey(Long areaId);

    int insert(Area record);

    int insertOrUpdate(Area record);

    int insertOrUpdateSelective(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    int updateBatch(List<Area> list);

    int updateBatchSelective(List<Area> list);

    int batchInsert(@Param("list") List<Area> list);
}
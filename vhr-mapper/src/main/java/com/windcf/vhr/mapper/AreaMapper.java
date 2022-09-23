package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Area;
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
public interface AreaMapper {
    /**
     * delete by primary key
     *
     * @param areaId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long areaId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Area record);

    int insertOrUpdate(Area record);

    int insertOrUpdateSelective(Area record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Area record);

    /**
     * select by primary key
     *
     * @param areaId primary key
     * @return object by primary key
     */
    Area selectByPrimaryKey(Long areaId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Area record);

    int updateBatch(List<Area> list);

    int updateBatchSelective(List<Area> list);

    int batchInsert(@Param("list") List<Area> list);
}
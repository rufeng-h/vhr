package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Industry;
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
public interface IndustryMapper {
    /**
     * delete by primary key
     *
     * @param indId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String indId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Industry record);

    int insertOrUpdate(Industry record);

    int insertOrUpdateSelective(Industry record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Industry record);

    /**
     * select by primary key
     *
     * @param indId primary key
     * @return object by primary key
     */
    Industry selectByPrimaryKey(String indId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Industry record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Industry record);

    int updateBatch(List<Industry> list);

    int updateBatchSelective(List<Industry> list);

    int batchInsert(@Param("list") List<Industry> list);
}
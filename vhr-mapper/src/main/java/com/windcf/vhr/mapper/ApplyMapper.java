package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Apply;
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
public interface ApplyMapper {
    /**
     * delete by primary key
     *
     * @param apyId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long apyId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Apply record);

    int insertOrUpdate(Apply record);

    int insertOrUpdateSelective(Apply record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Apply record);

    /**
     * select by primary key
     *
     * @param apyId primary key
     * @return object by primary key
     */
    Apply selectByPrimaryKey(Long apyId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Apply record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Apply record);

    int updateBatch(List<Apply> list);

    int updateBatchSelective(List<Apply> list);

    int batchInsert(@Param("list") List<Apply> list);
}
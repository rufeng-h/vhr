package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Family;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-23 21:12
 * @package com.windcf.vhr.mapper
 * @description TODO
 */

@Mapper
public interface FamilyMapper {
    /**
     * delete by primary key
     *
     * @param fmId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long fmId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Family record);

    int insertOrUpdate(Family record);

    int insertOrUpdateSelective(Family record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Family record);

    /**
     * select by primary key
     *
     * @param fmId primary key
     * @return object by primary key
     */
    Family selectByPrimaryKey(Long fmId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Family record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Family record);

    int updateBatch(List<Family> list);

    int updateBatchSelective(List<Family> list);

    int batchInsert(@Param("list") List<Family> list);

    List<Family> listByCandId(Long candId);
}
package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Advantage;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-25 22:37
 * @package com.windcf.vhr.mapper
 * @description TODO
 */

@Mapper
public interface AdvantageMapper {
    /**
     * delete by primary key
     *
     * @param advId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long advId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Advantage record);

    int insertOrUpdate(Advantage record);

    int insertOrUpdateSelective(Advantage record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Advantage record);

    /**
     * select by primary key
     *
     * @param advId primary key
     * @return object by primary key
     */
    Advantage selectByPrimaryKey(Long advId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Advantage record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Advantage record);

    int updateBatch(List<Advantage> list);

    int updateBatchSelective(List<Advantage> list);

    int batchInsert(@Param("list") List<Advantage> list);

    Advantage selectByRsId(Long rsId);
}
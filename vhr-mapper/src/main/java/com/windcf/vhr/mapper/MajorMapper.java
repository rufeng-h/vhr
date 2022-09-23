package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Major;
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
public interface MajorMapper {
    /**
     * delete by primary key
     *
     * @param majorId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String majorId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Major record);

    int insertOrUpdate(Major record);

    int insertOrUpdateSelective(Major record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Major record);

    /**
     * select by primary key
     *
     * @param majorId primary key
     * @return object by primary key
     */
    Major selectByPrimaryKey(String majorId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Major record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Major record);

    int updateBatch(List<Major> list);

    int updateBatchSelective(List<Major> list);

    int batchInsert(@Param("list") List<Major> list);
}
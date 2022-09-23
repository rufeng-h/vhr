package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.WorkExpr;
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
public interface WorkExprMapper {
    /**
     * delete by primary key
     * @param workId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long workId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(WorkExpr record);

    int insertOrUpdate(WorkExpr record);

    int insertOrUpdateSelective(WorkExpr record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(WorkExpr record);

    /**
     * select by primary key
     * @param workId primary key
     * @return object by primary key
     */
    WorkExpr selectByPrimaryKey(Long workId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(WorkExpr record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(WorkExpr record);

    int updateBatch(List<WorkExpr> list);

    int updateBatchSelective(List<WorkExpr> list);

    int batchInsert(@Param("list") List<WorkExpr> list);
}
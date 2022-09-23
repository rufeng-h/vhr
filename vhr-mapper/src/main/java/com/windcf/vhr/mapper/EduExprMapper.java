package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.EduExpr;
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
public interface EduExprMapper {
    /**
     * delete by primary key
     *
     * @param eduId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long eduId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(EduExpr record);

    int insertOrUpdate(EduExpr record);

    int insertOrUpdateSelective(EduExpr record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(EduExpr record);

    /**
     * select by primary key
     *
     * @param eduId primary key
     * @return object by primary key
     */
    EduExpr selectByPrimaryKey(Long eduId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(EduExpr record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(EduExpr record);

    int updateBatch(List<EduExpr> list);

    int updateBatchSelective(List<EduExpr> list);

    int batchInsert(@Param("list") List<EduExpr> list);
}
package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.EduExpr;
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
public interface EduExprMapper {
    int deleteByPrimaryKey(Long eduId);

    int insert(EduExpr record);

    int insertOrUpdate(EduExpr record);

    int insertOrUpdateSelective(EduExpr record);

    int insertSelective(EduExpr record);

    EduExpr selectByPrimaryKey(Long eduId);

    int updateByPrimaryKeySelective(EduExpr record);

    int updateByPrimaryKey(EduExpr record);

    int updateBatch(List<EduExpr> list);

    int updateBatchSelective(List<EduExpr> list);

    int batchInsert(@Param("list") List<EduExpr> list);
}
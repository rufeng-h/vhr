package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Candidate;
import java.util.List;

import com.windcf.vhr.model.query.CandidateQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-15 14:28
 * @package com.windcf.vhr.mapper
 * @description TODO
 */

@Mapper
public interface CandidateMapper {
    int deleteByPrimaryKey(Long candId);

    int insert(Candidate record);

    int insertOrUpdate(Candidate record);

    int insertOrUpdateSelective(Candidate record);

    int insertSelective(Candidate record);

    Candidate selectByPrimaryKey(Long candId);

    int updateByPrimaryKeySelective(Candidate record);

    int updateByPrimaryKey(Candidate record);

    int updateBatch(List<Candidate> list);

    int updateBatchSelective(List<Candidate> list);

    int batchInsert(@Param("list") List<Candidate> list);

    Candidate selectByExample(@Param("query") CandidateQuery cand);
}
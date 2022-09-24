package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Candidate;
import java.util.List;
import com.windcf.vhr.model.query.CandidateQuery;import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-24 15:09
 * @package com.windcf.vhr.mapper
 * @description TODO
 */

@Mapper
public interface CandidateMapper {
    /**
     * delete by primary key
     *
     * @param candId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long candId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Candidate record);

    int insertOrUpdate(Candidate record);

    int insertOrUpdateSelective(Candidate record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Candidate record);

    /**
     * select by primary key
     *
     * @param candId primary key
     * @return object by primary key
     */
    Candidate selectByPrimaryKey(Long candId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Candidate record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Candidate record);

    int updateBatch(List<Candidate> list);

    int updateBatchSelective(List<Candidate> list);

    int batchInsert(@Param("list") List<Candidate> list);

    Candidate selectByExample(@Param("query") CandidateQuery cand);
}
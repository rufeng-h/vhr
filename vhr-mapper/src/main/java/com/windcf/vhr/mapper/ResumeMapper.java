package com.windcf.vhr.mapper;

import com.windcf.vhr.model.entity.Resume;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chunf
 * @time 2022-09-25 16:04
 * @package com.windcf.vhr.mapper
 * @description TODO
 */

@Mapper
public interface ResumeMapper {
    /**
     * delete by primary key
     *
     * @param rsId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long rsId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Resume record);

    int insertOrUpdate(Resume record);

    int insertOrUpdateSelective(Resume record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Resume record);

    /**
     * select by primary key
     *
     * @param rsId primary key
     * @return object by primary key
     */
    Resume selectByPrimaryKey(Long rsId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Resume record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Resume record);

    int updateBatch(List<Resume> list);

    int updateBatchSelective(List<Resume> list);

    int batchInsert(@Param("list") List<Resume> list);

    List<Resume> listByCandId(Long candId);
}
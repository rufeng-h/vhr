package com.windcf.vhr.service;

import com.windcf.vhr.model.entity.Resume;
import com.windcf.vhr.model.vo.ResumeInfo;

import java.util.List;

/**
 * @author chunf
 * @time 2022-09-24 18:59
 * @package com.windcf.vhr.service
 * @description resume
 */
public interface ResumeService {
    /**
     * list all by candId
     *
     * @param candId candid
     * @return list
     */
    List<Resume> listResume(Long candId);

    boolean addResume();

    ResumeInfo getResume(Long rsId);
}

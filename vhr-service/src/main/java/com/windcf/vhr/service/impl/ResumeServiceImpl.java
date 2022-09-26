package com.windcf.vhr.service.impl;

import com.windcf.vhr.mapper.AdvantageMapper;
import com.windcf.vhr.mapper.EduExprMapper;
import com.windcf.vhr.mapper.ResumeMapper;
import com.windcf.vhr.model.entity.Advantage;
import com.windcf.vhr.model.entity.EduExpr;
import com.windcf.vhr.model.entity.Resume;
import com.windcf.vhr.model.vo.ResumeInfo;
import com.windcf.vhr.service.ResumeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chunf
 * @time 2022-09-24 18:59
 * @package com.windcf.vhr.service.impl
 * @description resume service impl
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    private final ResumeMapper resumeMapper;
    private final AdvantageMapper advantageMapper;
    private final EduExprMapper eduExprMapper;

    public ResumeServiceImpl(ResumeMapper resumeMapper, AdvantageMapper advantageMapper, EduExprMapper eduExprMapper) {
        this.resumeMapper = resumeMapper;
        this.advantageMapper = advantageMapper;
        this.eduExprMapper = eduExprMapper;
    }

    @Override
    public List<Resume> listResume(Long candId) {
        return resumeMapper.listByCandId(candId);
    }

    @Override
    public boolean addResume() {
        return false;
    }

    @Override
    public ResumeInfo getResume(Long rsId) {
        Resume resume = resumeMapper.selectByPrimaryKey(rsId);
        Advantage advantage = advantageMapper.selectByRsId(rsId);
        List<EduExpr> eduExprs = eduExprMapper.selectByRsId(rsId);
        return new ResumeInfo(resume, advantage, eduExprs);
    }
}

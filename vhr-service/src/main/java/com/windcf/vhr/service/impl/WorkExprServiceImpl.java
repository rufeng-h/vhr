package com.windcf.vhr.service.impl;

import com.windcf.vhr.mapper.WorkExprMapper;
import com.windcf.vhr.model.entity.WorkExpr;
import com.windcf.vhr.model.form.InsertOrUpdateWorkForm;
import com.windcf.vhr.service.WorkExprService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author chunf
 * @time 2022-09-26 15:28
 * @package com.windcf.vhr.service.impl
 * @description work expr
 */
@Service
public class WorkExprServiceImpl implements WorkExprService {
    private final WorkExprMapper workExprMapper;

    public WorkExprServiceImpl(WorkExprMapper workExprMapper) {
        this.workExprMapper = workExprMapper;
    }

    @Override
    public WorkExpr addWork(InsertOrUpdateWorkForm form) {
        WorkExpr expr = WorkExpr.builder()
                .workComp(form.getWorkComp())
                .workRsId(form.getWorkRsId())
                .workCompSize(form.getWorkCompSize())
                .workCompType(form.getWorkCompType())
                .workDesc(form.getWorkDesc())
                .workEnd(form.getWorkEnd())
                .workStart(form.getWorkStart())
                .workInd(form.getWorkInd())
                .workPosition(form.getWorkPosition())
                .workType(form.getWorkType())
                .build();
        workExprMapper.insertSelective(expr);
        return expr;
    }

    @Override
    public boolean updateWork(InsertOrUpdateWorkForm form) {
        WorkExpr expr = WorkExpr.builder()
                .workModified(LocalDateTime.now())
                .workId(form.getWorkId())
                .workComp(form.getWorkComp())
                .workCompSize(form.getWorkCompSize())
                .workCompType(form.getWorkCompType())
                .workDesc(form.getWorkDesc())
                .workEnd(form.getWorkEnd())
                .workStart(form.getWorkStart())
                .workInd(form.getWorkInd())
                .workPosition(form.getWorkPosition())
                .workType(form.getWorkType())
                .build();
        return workExprMapper.updateByPrimaryKeySelective(expr) == 1;
    }

    @Override
    public boolean delWork(Long workId) {
        return workExprMapper.deleteByPrimaryKey(workId) == 1;
    }

}

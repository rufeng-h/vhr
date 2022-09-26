package com.windcf.vhr.service.impl;

import com.windcf.vhr.mapper.EduExprMapper;
import com.windcf.vhr.model.entity.EduExpr;
import com.windcf.vhr.model.form.InsertOrUpdateEduForm;
import com.windcf.vhr.service.EduExprService;
import com.windcf.vhr.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chunf
 * @time 2022-09-26 9:32
 * @package com.windcf.vhr.service.impl
 * @description edu service
 */
@Service
public class EduExprServiceImpl implements EduExprService {
    private final EduExprMapper eduExprMapper;
    private final UserService userService;

    public EduExprServiceImpl(EduExprMapper eduExprMapper, UserService userService) {
        this.eduExprMapper = eduExprMapper;
        this.userService = userService;
    }

    @Override
    public List<EduExpr> listEduExprByRsId(Long rsId) {
        return eduExprMapper.selectByRsId(rsId);
    }

    @Override
    public EduExpr addEdu(InsertOrUpdateEduForm form) {
        EduExpr eduExpr = EduExpr.builder()
                .eduCandId(userService.getCurrentCandId())
                .eduEducation(form.getEduEducation())
                .eduMajor(form.getEduMajor())
                .eduRsId(form.getEduRsId())
                .eduEndDate(form.getEduEndDate())
                .eduMajorDesc(form.getEduMajorDesc())
                .eduSchool(form.getEduSchool())
                .eduStartDate(form.getEduStartDate())
                .build();
        eduExprMapper.insertSelective(eduExpr);
        return eduExpr;
    }

    @Override
    public boolean delEdu(Long eduId) {
        return eduExprMapper.deleteByPrimaryKey(eduId) == 1;
    }

    @Override
    public boolean updateEdu(InsertOrUpdateEduForm form) {
        EduExpr eduExpr = EduExpr.builder()
                .eduId(form.getEduId())
                .eduStartDate(form.getEduStartDate())
                .eduEndDate(form.getEduEndDate())
                .eduMajor(form.getEduMajor())
                .eduSchool(form.getEduSchool())
                .eduMajorDesc(form.getEduMajorDesc())
                .eduEducation(form.getEduEducation())
                .eduModified(LocalDateTime.now())
                .build();
        return eduExprMapper.updateByPrimaryKeySelective(eduExpr) == 1;
    }
}

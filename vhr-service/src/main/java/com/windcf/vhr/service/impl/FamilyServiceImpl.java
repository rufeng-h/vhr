package com.windcf.vhr.service.impl;

import com.windcf.vhr.mapper.FamilyMapper;
import com.windcf.vhr.model.entity.Family;
import com.windcf.vhr.model.form.InsertOrUpdateFamilyForm;
import com.windcf.vhr.security.exception.AuthenticationException;
import com.windcf.vhr.service.FamilyService;
import com.windcf.vhr.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chunf
 * @time 2022-09-23 20:04
 * @package com.windcf.vhr.service.impl
 * @description fm service impl
 */
@Service
public class FamilyServiceImpl implements FamilyService {
    private final UserService userService;
    private final FamilyMapper familyMapper;

    public FamilyServiceImpl(UserService userService, FamilyMapper familyMapper) {
        this.userService = userService;
        this.familyMapper = familyMapper;
    }

    @Override
    public boolean delFamily(Long fmId) {
        /*有权限校验，永不为null*/
        Long candId = userService.getCurrentCandId();
        Family family = familyMapper.selectByPrimaryKey(fmId);
        if (family == null || !family.getFmCandId().equals(candId)) {
            throw new AuthenticationException("请求异常");
        }
        return familyMapper.deleteByPrimaryKey(fmId) == 1;
    }

    @Override
    public boolean addFamily(InsertOrUpdateFamilyForm form) {
        Long candId = userService.getCurrentCandId();
        if (!form.getFmCandId().equals(candId)) {
            throw new AuthenticationException("请求异常");
        }
        Family family = Family.builder()
                .fmCandId(form.getFmCandId())
                .fmCompany(form.getFmCompany())
                .fmCreated(LocalDateTime.now())
                .fmName(form.getFmName())
                .fmPosition(form.getFmPosition())
                .fmRelation(form.getFmRelation()).build();
        return familyMapper.insertSelective(family) == 1;
    }

    @Override
    public boolean updateFamily(InsertOrUpdateFamilyForm form) {
        Long candId = userService.getCurrentCandId();
        if (!form.getFmCandId().equals(candId)) {
            throw new AuthenticationException("请求异常");
        }
        Family family = Family.builder()
                .fmId(form.getFmId())
                .fmCompany(form.getFmCompany())
                .fmCreated(LocalDateTime.now())
                .fmName(form.getFmName())
                .fmPosition(form.getFmPosition())
                .fmRelation(form.getFmRelation()).build();
        return familyMapper.updateByPrimaryKeySelective(family) == 1;
    }

    @Override
    public List<Family> list(Long fmCandId) {
        return familyMapper.listByCandId(fmCandId);
    }
}

package com.windcf.vhr.service.impl;

import com.windcf.vhr.mapper.AdvantageMapper;
import com.windcf.vhr.model.entity.Advantage;
import com.windcf.vhr.model.form.InsertOrUpdateAdvForm;
import com.windcf.vhr.service.AdvantageService;
import com.windcf.vhr.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author chunf
 * @time 2022-09-25 22:23
 * @package com.windcf.vhr.service.impl
 * @description TODO CandId 验证
 */
@Service
public class AdvantageServiceImpl implements AdvantageService {
    private final AdvantageMapper advantageMapper;
    private final UserService userService;

    public AdvantageServiceImpl(AdvantageMapper advantageMapper, UserService userService) {
        this.advantageMapper = advantageMapper;
        this.userService = userService;
    }


    @Override
    public Advantage addAdv(InsertOrUpdateAdvForm form) {

        Long candId = userService.getCurrentCandId();

        Advantage advantage = Advantage.builder()
                .advContent(form.getAdvContent())
                .advModified(LocalDateTime.now())
                .advCreated(LocalDateTime.now())
                .advCandId(candId)
                .advRsId(form.getAdvRsId())
                .build();
        advantageMapper.insertSelective(advantage);
        return advantage;
    }

    @Override
    public boolean updateAdv(InsertOrUpdateAdvForm form) {
        Advantage advantage = Advantage.builder()
                .advId(form.getAdvId())
                .advContent(form.getAdvContent())
                .advModified(LocalDateTime.now())
                .build();
        return advantageMapper.updateByPrimaryKeySelective(advantage) == 1;
    }
}

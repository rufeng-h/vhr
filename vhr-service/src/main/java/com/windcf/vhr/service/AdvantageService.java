package com.windcf.vhr.service;

import com.windcf.vhr.model.entity.Advantage;
import com.windcf.vhr.model.form.InsertOrUpdateAdvForm;

/**
 * @author chunf
 * @time 2022-09-25 22:20
 * @package com.windcf.vhr.service
 * @description TODO
 */
public interface AdvantageService {
    Advantage addAdv(InsertOrUpdateAdvForm form);
    boolean updateAdv(InsertOrUpdateAdvForm form);
}

package com.windcf.vhr.service;

import com.windcf.vhr.model.entity.WorkExpr;
import com.windcf.vhr.model.form.InsertOrUpdateWorkForm;

/**
 * @author chunf
 * @time 2022-09-26 15:25
 * @package com.windcf.vhr.service
 * @description TODO
 */
public interface WorkExprService {
    WorkExpr addWork(InsertOrUpdateWorkForm form);

    boolean updateWork(InsertOrUpdateWorkForm form);

    boolean delWork(Long workId);
}

package com.windcf.vhr.service;

import com.windcf.vhr.model.entity.EduExpr;
import com.windcf.vhr.model.form.InsertOrUpdateEduForm;

import java.util.List;

/**
 * @author chunf
 * @time 2022-09-26 9:30
 * @package com.windcf.vhr.service
 * @description edu service
 */
public interface EduExprService {
    List<EduExpr> listEduExprByRsId(Long rsId);

    EduExpr addEdu(InsertOrUpdateEduForm form);

    boolean delEdu(Long eduId);

    boolean updateEdu(InsertOrUpdateEduForm form);
}

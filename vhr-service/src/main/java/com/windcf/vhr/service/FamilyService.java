package com.windcf.vhr.service;

import com.windcf.vhr.model.entity.Family;
import com.windcf.vhr.model.form.InsertOrUpdateFamilyForm;

import java.util.List;

/**
 * @author chunf
 * @time 2022-09-23 20:01
 * @package com.windcf.vhr.service
 * @description Family Service
 */
public interface FamilyService {
    /**
     * del
     *
     * @param fmId the family id
     * @return succ or fail
     */
    boolean delFamily(Long fmId);

    /**
     * insert one family record
     *
     * @param form formdata
     * @return succ or fail
     */
    boolean addFamily(InsertOrUpdateFamilyForm form);

    boolean updateFamily(InsertOrUpdateFamilyForm form);

    List<Family> list(Long fmCandId);
}

package com.windcf.vhr.model.vo;

import com.windcf.vhr.model.entity.Advantage;
import com.windcf.vhr.model.entity.EduExpr;
import com.windcf.vhr.model.entity.Resume;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chunf
 * @time 2022-09-25 22:46
 * @package com.windcf.vhr.model.vo
 * @description TODO
 */
@Data
public class ResumeInfo {
    private Long rsId;

    private String rsName;

    private String rsDesc;

    private LocalDateTime rsCreated;

    private LocalDateTime rsModified;

    private Long rsCandId;

    private Boolean rsPublic;

    private Boolean rsDefault;

    private Advantage adv;

    private List<EduExpr> edus;

    public ResumeInfo(Resume resume, Advantage adv, List<EduExpr> eduExprs) {
        BeanUtils.copyProperties(resume, this);
        this.adv = adv;
        this.edus = eduExprs;
    }
}

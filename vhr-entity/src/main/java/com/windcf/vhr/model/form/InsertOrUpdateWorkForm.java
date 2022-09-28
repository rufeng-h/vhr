package com.windcf.vhr.model.form;

import com.windcf.vhr.model.validation.Insert;
import com.windcf.vhr.model.validation.Update;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

/**
 * @author chunf
 * @time 2022-09-26 15:25
 * @package com.windcf.vhr.model.form
 * @description work form
 */
@Data
public class InsertOrUpdateWorkForm {
    @NotNull(groups = Update.class)
    @Null(groups = Insert.class)
    private Long workId;

    /**
     * 公司名称
     */
    @NotEmpty
    private String workComp;

    /**
     * 所属行业
     */
    @NotEmpty
    private String workInd;

    @NotNull
    private LocalDate workStart;

    @NotNull
    private LocalDate workEnd;

    /**
     * 公司规模
     */
    @NotEmpty
    private String workCompSize;

    /**
     * 职位
     */
    @NotEmpty
    private String workPosition;

    /**
     * 公司性质
     */
    @NotEmpty
    private String workCompType;

    /**
     * 工作描述
     */
    @NotEmpty
    private String workDesc;
    @NotNull(groups = Insert.class)
    @Null(groups = Update.class)
    private Long workRsId;

    @NotEmpty
    private String workType;
}

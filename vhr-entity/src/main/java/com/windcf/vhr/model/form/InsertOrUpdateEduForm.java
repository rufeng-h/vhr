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
 * @time 2022-09-26 9:25
 * @package com.windcf.vhr.model.form
 * @description edu
 */
@Data
public class InsertOrUpdateEduForm {
    @NotNull(groups = Update.class)
    @Null(groups = Insert.class)
    private Long eduId;
    @NotEmpty
    private String eduEducation;
    private String eduSchool;
    private String eduMajor;
    private String eduMajorDesc;
    private LocalDate eduStartDate;
    private LocalDate eduEndDate;
    @Null(groups = Update.class)
    @NotNull(groups = Insert.class)
    private Long eduRsId;
}

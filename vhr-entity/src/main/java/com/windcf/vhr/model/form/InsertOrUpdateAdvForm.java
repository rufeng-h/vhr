package com.windcf.vhr.model.form;

import com.windcf.vhr.model.validation.Insert;
import com.windcf.vhr.model.validation.Update;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

/**
 * @author chunf
 * @time 2022-09-25 22:21
 * @package com.windcf.vhr.model.form
 * @description TODO
 */
@Data
public class InsertOrUpdateAdvForm {
    @NotNull(groups = Update.class)
    @Null(groups = Insert.class)
    private Long advId;
    @NotEmpty
    private String advContent;
    @NotNull
    private Long advCandId;
    @NotNull(groups = Insert.class)
    @Null(groups = Update.class)
    private Long advRsId;
}

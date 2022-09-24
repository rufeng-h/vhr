package com.windcf.vhr.model.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author chunf
 * @time 2022-09-22 18:34
 * @package com.windcf.vhr.model.form
 * @description update cand info
 * TODO 前后端参数校验都没做全，枚举类型
 */


@Data
public class UpdateCandForm {
    @NotNull
    private Long candId;
    @NotEmpty
    private String username;
    @NotNull
    private Integer heavy;
    @NotNull
    private Integer height;
    @NotEmpty
    private String hometown;
    @NotEmpty
    private String living;
    @NotNull
    private Double visionLeft;
    @NotNull
    private Double visionRight;
    @NotEmpty
    private String nation;
    @NotEmpty
    private String politic;
}

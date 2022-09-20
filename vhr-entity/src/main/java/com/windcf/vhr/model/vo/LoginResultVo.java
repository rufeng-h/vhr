package com.windcf.vhr.model.vo;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chunf
 * @time 2022-09-15 15:44
 * @package com.windcf.vhr.model.vo
 * @description login result
 */
@Data
@AllArgsConstructor
public class LoginResultVo {
    private String token;
    @JsonUnwrapped
    private AbstractUserInfoVo userInfo;
}

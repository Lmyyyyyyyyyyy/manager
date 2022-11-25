package com.lmy.util.vo;

import com.lmy.entity.Users;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 用户vo类
 * @Date 2022/11/25 14:32
 * @Author by Soleil
 */
@Data
public class UserOut extends Users {

    @ApiModelProperty("身份")
    private String ident;

    @ApiModelProperty("生日：yyyy-MM-dd格式")
    private String birth;
}

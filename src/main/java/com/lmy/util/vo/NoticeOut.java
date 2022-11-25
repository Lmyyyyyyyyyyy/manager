package com.lmy.util.vo;

import com.lmy.entity.Notice;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 用户vo类
 * @Date 2022/11/25 13:54
 * @Author by Soleil
 */
@Data
public class NoticeOut extends Notice {

    @ApiModelProperty("发布时间：yyyy-MM-dd格式")
    private String date1;
}

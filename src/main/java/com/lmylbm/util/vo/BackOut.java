package com.lmylbm.util.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 归还 vo对象
 * @Date 2022/11/25 13:15
 * @Author by Soleil
 */
@Data
public class BackOut extends BookOut{

    @ApiModelProperty("借阅时间")
    private String borrowTime;

    @ApiModelProperty("应还时间")
    private String endTime;

    @ApiModelProperty("是否逾期")
    private String late;

}

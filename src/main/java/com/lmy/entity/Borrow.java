package com.lmy.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description 借阅表
 * @Date 2022/11/24 16:44
 * @Author by Soleil
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "borrow")
public class Borrow {

    @ApiModelProperty("ID主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("图书ID")
    private Integer bookId;

    @ApiModelProperty("借阅时间")
    private Date createTime;

    @ApiModelProperty("归还时间")
    private Date endTime;

    @ApiModelProperty("实际归还时间")
    private Date updateTime;

    @ApiModelProperty("是否归还（0 已归还 1 未归还）")
    private Integer ret;
}

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
 * <p>
 *  公告实体类
 * </p>
 *
 * @author lmylbm
 * @since 2022-11-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "notice")
public class Notice {

    @ApiModelProperty("ID主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty("公告标题")
    private String title;

    @ApiModelProperty("发布时间")
    private Date date;
    
    @ApiModelProperty("公告内容")
    private String content;

}

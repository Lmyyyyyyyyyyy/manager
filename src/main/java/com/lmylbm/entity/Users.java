package com.lmylbm.entity;

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
 *  用户实体类
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
@Table(name = "users")
public class Users {

    @ApiModelProperty("ID主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("生日")
    private Date birthday;

    @ApiModelProperty("是否为管理员（0 管理员 1 普通用户）")
    private Integer isAdmin;

    @ApiModelProperty("电话")
    private String tel;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("可借数量")
    private Integer size;

}

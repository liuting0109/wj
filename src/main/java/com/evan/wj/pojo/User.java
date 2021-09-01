package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: liuting
 * @Date: 2021/8/26 09:40
 * @Description:
 */

@Data
@Entity//表示这是一个实体类
@Table(name = "user")//表示对应的表名是 user
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Username.
     */
    private String username;

    /**
     * Password.
     */
    private String password;

    /**
     * Salt for encoding.
     */
    private String salt;

    /**
     * Real name.
     */
    private String name;

    /**
     * Phone number.
     */
    private String phone;

    /**
     * Email address.
     *
     * A Email address can be null,but should be correct if exists.
     */
    private String email;

}

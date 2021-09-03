package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: liuting
 * @Date: 2021/9/2 17:44
 * @Description:
 */
@Data
@Entity
@Table(name = "admin_user_role")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * User id.
     */
    private Integer uid;

    /**
     * Role id.
     */
    private Integer rid;
}

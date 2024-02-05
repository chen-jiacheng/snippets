package com.chenjiacheng.snippets.sharding.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenjiacheng on 2024/2/5 21:26
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String sex;

}

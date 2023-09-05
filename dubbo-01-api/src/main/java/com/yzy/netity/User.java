package com.yzy.netity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yzy
 * @date 2023/09/05
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    /**
     * 名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;
}

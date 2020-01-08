package com.lxf.controller.event;

import lombok.*;
/**
 * @author lxf
 * @date 2020/1/7 16:25
 * @modified
 * @description 用户
 */
@Data@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String phoneNum;
    private String email;
}

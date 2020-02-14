package com.lxf.entity.relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @authhor: lxf
 * @create: 2020-02-04 16:15
 * @description: 学生信息----测试OneToOne功能
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
//    @ManyToOne
//    @JoinColumn(name="schoolId")
//    private School  school;
}

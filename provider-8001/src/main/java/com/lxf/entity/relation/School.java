package com.lxf.entity.relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @authhor: lxf
 * @create: 2020-02-08 11:31
 * @description: 学校基本信息
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String schoolName;
    @OneToMany
    @JoinColumn(name="studentId")
    private Set<Student> students;
}

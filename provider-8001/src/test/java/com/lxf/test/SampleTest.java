package com.lxf.test;

import com.lxf.entity.relation.Certification;
import com.lxf.entity.relation.School;
import com.lxf.entity.relation.Student;
import com.lxf.repository.CertificationRepository;
import com.lxf.repository.SchoolRepository;
import com.lxf.repository.StudentRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;
//    @Autowired
//    private CertificationRepository certificationRepository;

    @Test
    public void testGenerator(){
        Student s=null;

//        Student s=new Student();
//        s.setName("李雪峰");
//        School school1 =new School();
//        School school2 =new School();
//        school1.setSchoolName("丹江一中");
//        school2.setSchoolName("丹江二中");
//
//
//        s.setSchool(school1);
//        studentRepository.save(s);
//        schoolRepository.save(school1);


//        Certification certification =new  Certification();
//        certification.setCertificationNo("2--420381111212");
//        s.setCertification(certification);
//        Certification certification =new  Certification();
//        certification.setId(3L);
//        System.out.println(studentRepository.existsByCrId(3L));


    }

//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mvc;
//    @Before
//    public void setup(){
//        mvc= MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//    @Test
//    public void testq() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/user").contentType(MediaType.APPLICATION_JSON).param("user","pp"))
//
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
}


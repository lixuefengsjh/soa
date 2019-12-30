package com.lxf.repository;

import com.lxf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Map;

@Repository
public interface UserManagerRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    @Query(nativeQuery = true, value = "select  user.id ,user.login,user.`password` ,ro.role_name  from    user_role_relation re  \n" +
            "left  join role ro  on  re.role_id=ro.id\n" +
            "left join user on re.user_id =user.id where  user.login=?1")
    List<Map<String, String>> findUserRole(String login);
}

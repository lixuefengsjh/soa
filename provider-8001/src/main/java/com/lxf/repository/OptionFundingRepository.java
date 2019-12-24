package com.lxf.repository;

import com.lxf.entity.OptionFunding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lxf
 */
@Repository
public interface OptionFundingRepository extends JpaRepository<OptionFunding, Long> {
    @Query(nativeQuery = true,value="SELECT  * FROM option_funding WHERE date_format(option_time,\"%Y-%m-%d\")=?1 ORDER BY option_time desc ")
    List<OptionFunding> findOptionFundingByOptionTime(String optionTime);
}

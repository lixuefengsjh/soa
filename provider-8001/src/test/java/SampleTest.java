import com.lxf.dao.DeptMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        int  dept= deptMapper.selectCount(null);
        System.out.println(dept);

    }

}
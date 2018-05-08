package tk.mybatis.springboot.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.springboot.Application;
import tk.mybatis.springboot.model.Country;
import tk.mybatis.springboot.service.CountryService;

import java.util.List;

/**
 * @author liuzh
 * @since 2017/9/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void test() {
        Country country = new Country();
        PageHelper.startPage(1,10);
        List<Country> all = countryService.getAll(country);
        System.out.println(((Page)all).getTotal());
        for (Country c : all) {
            System.out.println(c.getCountryname());
        }
    }
}

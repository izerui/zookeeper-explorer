package test;

import com.izerui.zookeeper.Application;
import com.izerui.zookeeper.service.ExplorerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by serv on 2015/4/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ZkTest {

    @Autowired
    ExplorerService service;

    @Test
    public void list()  {
        List<String> children = service.getChildren("/");
        for (String path:children){
            System.out.println(path);
            System.out.println(service.getData(path));
        }
    }
}

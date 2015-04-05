package test;

import com.izerui.zookeeper.Application;
import com.izerui.zookeeper.dto.Node;
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
        List<Node> nodes = service.getTree();
        System.out.println(nodes.toString());
    }

    @Test
    public void testChildren(){
        Node node = new Node();
        node.setName("/");
        List<Node> children = service.getChildren(node);
        System.out.println(children.toString());
    }

    @Test
    public void addPath() throws UnsupportedEncodingException {
        service.createPath("/test/三等奖放放假","你能耐我何".getBytes("utf-8"));
    }
}

package com.izerui.zookeeper.command.path;

import com.google.common.collect.Lists;
import com.izerui.zookeeper.command.Command;
import com.izerui.zookeeper.dto.Node;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 2015/4/4.
 */
public class GetTreeCommand implements Command {

    private Logger logger = LoggerFactory.getLogger(GetTreeCommand.class);

    private List<Node> nodes;

    private transient CuratorFramework client;

    @Override
    public void command(CuratorFramework client) throws Exception {
        this.client = client;
        Node parent = new Node();
        parent.setName("/");
        wrapNode(parent);
        nodes = Lists.newArrayList(parent);
    }

    private void wrapNode(Node parent) throws Exception {
        logger.debug("path:{}",parent.getFullPath());
        List<String> nodes = client.getChildren().forPath(parent.getFullPath());
        if(nodes!=null&&nodes.size()>0){
            parent.setChildren(new ArrayList<Node>());
            for(String path:nodes){
                Node node = new Node();
                node.setParent(parent);
                node.setName(path);
                wrapNode(node);
                parent.getChildren().add(node);
            }
        }else{
            parent.setData(client.getData().forPath(parent.getFullPath()));
        }

    }

    public List<Node> getNodes() {
        return nodes;
    }
}

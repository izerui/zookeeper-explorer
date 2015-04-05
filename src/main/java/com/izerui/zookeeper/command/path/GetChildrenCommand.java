package com.izerui.zookeeper.command.path;

import com.izerui.zookeeper.command.Command;
import com.izerui.zookeeper.dto.Node;
import org.apache.curator.framework.CuratorFramework;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取path的子目录
 * Created by serv on 2015/3/9.
 */
public class GetChildrenCommand implements Command {

    protected Node parent;
    private List<Node> children;

    public GetChildrenCommand(Node parent) {
        this.parent = parent;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        List<String> list = client.getChildren().forPath(parent.getFullPath());
        if(list!=null&&list.size()>0){
            parent.setHasChildren(true);
            children = new ArrayList<Node>();
            for(String path:list){
                Node node = new Node();
                node.setParent(parent);
                node.setName(path);

                //补充hasChildren 和 data属性
                List<String> grandson = client.getChildren().forPath(node.getFullPath());
                boolean hasChildren = grandson!=null&&grandson.size()>0;
                node.setHasChildren(hasChildren);
                if(!hasChildren){
                    node.setData(client.getData().forPath(node.getFullPath()));
                }
                children.add(node);
            }
            parent.setChildren(children);
        }
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }
}

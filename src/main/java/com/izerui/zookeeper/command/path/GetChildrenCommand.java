package com.izerui.zookeeper.command.path;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.utils.ZKPaths;

import java.util.List;

/**
 * 获取path的子目录
 * Created by serv on 2015/3/9.
 */
public class GetChildrenCommand implements Command {

    protected String path;
    private List<String> children;

    public GetChildrenCommand(String path) {
        this.path = path;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        children = Lists.transform(client.getChildren().forPath(path), new Function<String, String>() {
            @Override
            public String apply(String input) {
                return ZKPaths.makePath(path,input);
            }
        });
    }

    public List<String> getChildren() {
        return children;
    }
}

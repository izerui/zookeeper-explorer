package com.izerui.zookeeper.command.path;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;

/**
 * 删除路径
 * Created by serv on 2015/3/9.
 */
public class DeletePathCommand implements Command {

    protected String path;

    public DeletePathCommand(String path) {
        this.path = path;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        client.delete().forPath(path);
    }
}

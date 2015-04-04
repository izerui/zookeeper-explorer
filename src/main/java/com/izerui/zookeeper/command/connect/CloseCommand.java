package com.izerui.zookeeper.command.connect;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;

/**
 * 关闭连接
 * Created by serv on 2015/3/9.
 */
public class CloseCommand implements Command{
    public CloseCommand() {
    }

    @Override
    public void command(CuratorFramework client) {
        client.close();
    }
}

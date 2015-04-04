package com.izerui.zookeeper.command.path;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

/**
 * Created by serv on 2015/3/9.
 */
public class SetDataCommand implements Command {

    protected String path;
    protected byte[] data;
    private Stat stat;

    public SetDataCommand(String path, byte[] data) {
        this.path = path;
        this.data = data;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        stat = client.setData().forPath(path, data);
    }

    public Stat getStat() {
        return stat;
    }
}

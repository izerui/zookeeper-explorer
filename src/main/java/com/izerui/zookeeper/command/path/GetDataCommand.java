package com.izerui.zookeeper.command.path;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;

/**
 * Created by serv on 2015/4/4.
 */
public class GetDataCommand implements Command {

    private String path;
    private byte[] data;

    public GetDataCommand(String path) {
        this.path = path;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        data = client.getData().forPath(path);
    }

    public byte[] getData() {
        return data;
    }
}

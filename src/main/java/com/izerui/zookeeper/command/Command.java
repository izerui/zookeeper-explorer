package com.izerui.zookeeper.command;

import org.apache.curator.framework.CuratorFramework;

/**
 * Created by serv on 2015/3/9.
 */
public interface Command {
    public void command(CuratorFramework client) throws Exception;
}

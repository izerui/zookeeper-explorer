package com.izerui.zookeeper.command.lock;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;

import java.util.List;

/**
 * 多锁
 * Created by serv on 2015/4/26.
 */
public class InterProcessMultiLockCommand implements Command {

    private List<InterProcessLock> locks;
    private InterProcessMultiLock multiLock;

    public InterProcessMultiLockCommand(List<InterProcessLock> locks) {
        this.locks = locks;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        multiLock = new InterProcessMultiLock(locks);
    }

    public InterProcessMultiLock getMultiLock() {
        return multiLock;
    }
}

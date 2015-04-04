package com.izerui.zookeeper.command.listener;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;

/**
 * 添加节点监听
 * Created by serv on 2015/3/9.
 */
public class NodeCacheListenerCommand implements Command {

    protected String path;
    protected NodeCacheListener listener;
    private NodeCache cache;

    public NodeCacheListenerCommand(String path, NodeCacheListener listener) {
        this.path = path;
        this.listener = listener;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        cache = new NodeCache(client,path);
        cache.getListenable().addListener(listener);
        cache.start();
    }

    public NodeCache getCache() {
        return cache;
    }
}

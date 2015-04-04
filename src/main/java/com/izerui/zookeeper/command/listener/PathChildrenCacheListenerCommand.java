package com.izerui.zookeeper.command.listener;

import com.izerui.zookeeper.command.Command;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;

/**
 * 添加路径监听
 * Created by serv on 2015/3/9.
 */
public class PathChildrenCacheListenerCommand implements Command{

    protected String path;
    protected PathChildrenCacheListener listener;
    private PathChildrenCache cache;

    public PathChildrenCacheListenerCommand(String path, PathChildrenCacheListener listener) {
        this.path = path;
        this.listener = listener;
    }

    @Override
    public void command(CuratorFramework client) throws Exception {
        cache = new PathChildrenCache(client, path, true);
        cache.getListenable().addListener(listener);
        cache.start();
    }

    public PathChildrenCache getCache() {
        return cache;
    }
}

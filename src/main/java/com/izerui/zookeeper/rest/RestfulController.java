package com.izerui.zookeeper.rest;

import com.izerui.zookeeper.dto.Node;
import com.izerui.zookeeper.service.ExplorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by serv on 2015/4/5.
 */
@RestController
public class RestfulController {

    @Autowired
    private ExplorerService service;

    @RequestMapping(value = "/export")
    public List<Node> exportJson(){
        return service.getTree();
    }
}

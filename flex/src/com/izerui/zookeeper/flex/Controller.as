package com.izerui.zookeeper.flex {
import com.adobe.cairngorm.control.FrontController;
import com.izerui.zookeeper.flex.commond.GetChildrenCommond;
import com.izerui.zookeeper.flex.commond.GetTreeCommond;

public class Controller extends FrontController {

    public function initialize():void {
        this.addCommand("getChildren", GetChildrenCommond);
        this.addCommand("getTree", GetTreeCommond);

    }

    public function Controller() {
        this.initialize();
    }
}
}
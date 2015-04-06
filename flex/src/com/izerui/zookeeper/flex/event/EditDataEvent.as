package com.izerui.zookeeper.flex.event {
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.zookeeper.flex.dto.Node;

public class EditDataEvent extends CairngormEvent {

    public var node:Node;
    public var responseFun:Function;

    public function EditDataEvent(node:Node, responseFun:Function) {
        super("editData");
        this.node = node;

        this.responseFun = responseFun;
    }
}
}
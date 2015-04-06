/**
 * Created by serv on 2015/4/6.
 */
package com.izerui.zookeeper.flex.event {
import com.izerui.zookeeper.flex.dto.Node;

import flash.events.Event;

public class WrapNodeChildrenEvent extends Event{

    public static var wrapNodeChildrenEvent:String = "wrapNodeChildrenEvent";

    public var node:Node;

    public function WrapNodeChildrenEvent(node:Node) {
        super(wrapNodeChildrenEvent, true, true);
        this.node = node;
    }
}
}

package com.izerui.zookeeper.flex.business {
import com.adobe.cairngorm.business.ServiceLocator;
import com.izerui.zookeeper.flex.dto.Node;

import mx.rpc.AsyncToken;
import mx.rpc.IResponder;
import mx.rpc.remoting.RemoteObject;

public class EditDataDelegate implements IResponder {
    private var responder:IResponder;
    private var service:RemoteObject;

    public function EditDataDelegate(responder:IResponder) {
        this.responder = responder;
        this.service = ServiceLocator.getInstance().getRemoteObject("explorerService");
    }

    public function setData(node:Node):void {
        var call:AsyncToken = service.setData(node.fullPath,node.data);
        call.addResponder(responder);
    }

    public function result(data:Object):void {
        responder.result(data);
    }

    public function fault(info:Object):void {
        responder.fault(info);
    }
}
}
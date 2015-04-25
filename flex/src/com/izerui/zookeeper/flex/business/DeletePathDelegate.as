package com.izerui.zookeeper.flex.business {
import com.izerui.zookeeper.flex.dto.Node;

import mx.rpc.AsyncToken;
import mx.rpc.IResponder;
import mx.rpc.remoting.RemoteObject;

public class DeletePathDelegate extends BaseDelegate implements IResponder {
    private var responder:IResponder;
    private var service:RemoteObject;

    public function DeletePathDelegate(responder:IResponder) {
        this.responder = responder;
        this.service = getRemoteObject("explorerService");
    }

    public function deletePath(node:Node):void {
        var call:AsyncToken = service.deletePath(node.fullPath);
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
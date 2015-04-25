package com.izerui.zookeeper.flex.business {
import mx.rpc.AsyncToken;
import mx.rpc.IResponder;
import mx.rpc.remoting.RemoteObject;

public class GetTreeDelegate extends BaseDelegate implements IResponder {
    private var responder:IResponder;
    private var service:RemoteObject;

    public function GetTreeDelegate(responder:IResponder) {
        this.responder = responder;
        this.service = getRemoteObject("explorerService");
    }

    public function getTree():void {
        var call:AsyncToken = service.getTree();
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
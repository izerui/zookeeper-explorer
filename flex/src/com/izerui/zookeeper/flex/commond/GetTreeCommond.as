package com.izerui.zookeeper.flex.commond
{
import com.adobe.cairngorm.commands.ICommand;
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.zookeeper.flex.business.GetTreeDelegate;
import com.izerui.zookeeper.flex.event.GetTreeEvent;

import mx.controls.Alert;
import mx.rpc.IResponder;

public class GetTreeCommond implements IResponder, ICommand
	{
		
		private var delegate:GetTreeDelegate;
		
		private var responseFun:Function;
		
		public function GetTreeCommond()
		{
			delegate = new GetTreeDelegate(this);
		}
		
		public function result(data:Object):void
		{
			if(responseFun){
				responseFun.call(null,data.result);
			}
		}
		
		public function fault(info:Object):void
		{
			Alert.show(info.toString(),"error");
		}
		
		public function execute(event:CairngormEvent):void
		{
			var myEvent:GetTreeEvent = GetTreeEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getTree();
		}
	}
}
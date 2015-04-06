package com.izerui.zookeeper.flex.commond
{
import com.adobe.cairngorm.commands.ICommand;
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.zookeeper.flex.business.DeletePathDelegate;
import com.izerui.zookeeper.flex.event.DeletePathEvent;

import mx.controls.Alert;
import mx.rpc.IResponder;

public class DeletePathCommond implements IResponder, ICommand
	{
		
		private var delegate:DeletePathDelegate;
		
		private var responseFun:Function;
		
		public function DeletePathCommond()
		{
			delegate = new DeletePathDelegate(this);
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
			var myEvent:DeletePathEvent = DeletePathEvent(event);
			responseFun = myEvent.responseFun;
			delegate.deletePath(myEvent.node);
		}
	}
}
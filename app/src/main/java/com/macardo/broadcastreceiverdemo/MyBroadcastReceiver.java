package com.macardo.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//1.新建一个类，并让它继承自BroadcastReceiver类
public class MyBroadcastReceiver extends BroadcastReceiver {

    //2.重写父类的抽象方法onReceive()
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收广播后的逻辑（...）
        Toast.makeText(context,"接收到自定义广播",Toast.LENGTH_SHORT).show();
        //截断广播
        abortBroadcast();
    }
}

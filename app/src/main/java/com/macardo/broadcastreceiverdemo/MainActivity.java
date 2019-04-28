package com.macardo.broadcastreceiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver myBroadcastReceiver;
    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        //1.实例化 MyBroadcastReceiver、IntentFilter
        myBroadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter();
        //2.设置myBroadcastReceiver监听的广播内容
        intentFilter.addAction("com.macardo.broadcastreceiver.MyBroadcast");
        intentFilter.setPriority(1000);
        //3.动态注册myBroadcastReceiver
        registerReceiver(myBroadcastReceiver,intentFilter);*/

        //1.实例化 MyBroadcastReceiver、IntentFilter
        myBroadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter();
        //2.实例化LocalBroadcastManager
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        //3.设置myBroadcastReceiver监听的广播内容
        intentFilter.addAction("com.macardo.broadcastreceiver.MyBroadcast");
        //4.调用LocalBroadcastManager单一实例的registerReceiver（）方法进行动态注册
        localBroadcastManager.registerReceiver(myBroadcastReceiver,intentFilter);


        Button button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent("com.macardo.broadcastreceiver.MyBroadcast");
                //发送普通广播
                localBroadcastManager.sendBroadcast(intent);
/*                //发送有序广播
                // 参数1：intent
                // 参数2：与权限相关的字符串
                sendOrderedBroadcast(intent,null);*/
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
/*        //4.销毁myBroadcastReceiver
        unregisterReceiver(myBroadcastReceiver);*/
        //5.销毁myBroadcastReceiver
        localBroadcastManager.unregisterReceiver(myBroadcastReceiver);

    }
}

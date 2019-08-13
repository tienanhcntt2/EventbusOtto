package com.example.eventbus;


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.eventbus.model.EventBus;
import com.example.eventbus.model.MessageEvent;
import com.example.eventbus.ui.SecondActivity;

import com.squareup.otto.Subscribe;



public class MainActivity extends Activity {
    private EventBus bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getBus().register(this);
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getBus().post(new MessageEvent("Tran tien anh"));
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            }
        });
    }
    @Subscribe
    public void getMessage(MessageEvent event) {
        Toast.makeText(this, "" + event.getMessage(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getBus().unregister(this);
    }
}

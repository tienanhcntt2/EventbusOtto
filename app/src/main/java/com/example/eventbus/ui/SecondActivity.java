package com.example.eventbus.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.eventbus.R;
import com.example.eventbus.model.EventBus;
import com.example.eventbus.model.MessageEvent;
import com.squareup.otto.Subscribe;

public class SecondActivity  extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.btnSendData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getBus().post(new MessageEvent("hello Event bus"));
                finish();
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
        EventBus.getBus().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}

package com.example.eventbus.model;

import com.squareup.otto.Bus;

public class EventBus {
    private static Bus sBus;

    public static Bus getBus() {
        if (sBus == null)
            sBus = new Bus();
        return sBus;
    }
}

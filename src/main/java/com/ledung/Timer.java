package com.ledung;

import java.sql.Time;

public class Timer {

    private long startTime;
    private long endTime;

    public Timer tick() {
        this.startTime = System.currentTimeMillis();
        return this;
    }

    public Timer stop() {
        this.endTime = System.currentTimeMillis();
        return this;
    }

    public String report() {
        return "Elapsed " + (this.endTime - this.startTime) + " millis";
    }

    public Timer reset() {
        this.startTime = 0;
        this.endTime = 0;
        return this;
    }
}

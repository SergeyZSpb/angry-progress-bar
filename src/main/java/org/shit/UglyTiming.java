package org.shit;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class UglyTiming {

    Stopwatch stopwatch;

    public UglyTiming() {
        stopwatch = Stopwatch.createStarted();
    }

    public boolean isExceeded() {
        if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > 250) {
            stopwatch.reset();
            stopwatch.start();
            return true;
        } else {
            return false;
        }
    }
}

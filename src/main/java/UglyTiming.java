public class UglyTiming {

    private long lastTrackedTime;

    public UglyTiming() {
        lastTrackedTime = System.currentTimeMillis();
    }

    public boolean isExceeded() {
        long now = System.currentTimeMillis();
        boolean returned;

        if (now - lastTrackedTime > 2000L) {
            lastTrackedTime = now;
            returned = true;
        } else {
            returned = false;
        }

        return returned;
    }
}

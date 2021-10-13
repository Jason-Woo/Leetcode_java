import java.util.HashMap;

class Logger {

    public HashMap<String, Integer> memory;

    public Logger() {
        memory = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (memory.containsKey(message)) {
            int prevTimestamp = memory.get(message);
            if (timestamp - prevTimestamp >= 10) {
                memory.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            memory.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

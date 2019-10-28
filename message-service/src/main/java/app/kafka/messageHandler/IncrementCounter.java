package app.kafka.messageHandler;

public class IncrementCounter {
    public Integer incrementCalculations = 0;
    public Integer registerMessageCount = 0;
    public Integer updateMessageCount = 0;

    public void missedCount() {
        System.out.println(incrementCalculations + ", " + registerMessageCount + ", " + updateMessageCount);
        System.out.println("MissIncrementCalculations:" + (registerMessageCount * 10 + updateMessageCount * 10 - incrementCalculations));
    }
}

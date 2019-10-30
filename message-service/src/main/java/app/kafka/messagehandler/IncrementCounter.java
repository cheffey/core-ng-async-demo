package app.kafka.messagehandler;

public class IncrementCounter {
    public Long incrementCalculations = 0L;
    public Long registerMessageCount = 0L;
    public Long updateMessageCount = 0L;

    public void missedCount() {
        System.out.println(incrementCalculations + ", " + registerMessageCount + ", " + updateMessageCount);
        System.out.println("MissIncrementCalculations:" + (registerMessageCount * 10000 + updateMessageCount * 10000 - incrementCalculations));
    }
}

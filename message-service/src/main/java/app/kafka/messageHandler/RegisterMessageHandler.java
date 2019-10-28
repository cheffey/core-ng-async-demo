package app.kafka.messageHandler;

import app.kafka.api.message.RegisterMessage;
import core.framework.inject.Inject;
import core.framework.kafka.MessageHandler;

public class RegisterMessageHandler implements MessageHandler<RegisterMessage> {
    @Inject
    IncrementCounter incrementCounter;

    @Override
    public void handle(String key, RegisterMessage value) throws Exception {
        System.out.println("Register: "+value.id+", reward:"+value.reward);
        incrementCounter.registerMessageCount++;
        for (int i = 0; i < 10; i++) {
            incrementCounter.incrementCalculations++;
        }
        incrementCounter.missedCount();
    }
}

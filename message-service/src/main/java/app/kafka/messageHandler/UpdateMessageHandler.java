package app.kafka.messageHandler;

import app.kafka.api.message.UpdateMessage;
import core.framework.inject.Inject;
import core.framework.kafka.MessageHandler;

public class UpdateMessageHandler implements MessageHandler<UpdateMessage> {
    @Inject
    IncrementCounter incrementCounter;

    @Override
    public void handle(String key, UpdateMessage value) throws Exception {
        System.out.println("Update: "+value.version+", link:"+value.link);
        incrementCounter.updateMessageCount++;
        for (int i = 0; i < 10; i++) {
            incrementCounter.incrementCalculations++;
        }
        incrementCounter.missedCount();
    }
}

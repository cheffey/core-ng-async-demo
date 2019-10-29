package app;

import app.kafka.api.message.UpdateMessage;
import app.kafka.messageHandler.UpdateMessageHandler;
import core.framework.module.Module;

public class UpdateMessageModule extends Module {
    @Override
    protected void initialize() {
        kafka().subscribe("update", UpdateMessage.class, bind(UpdateMessageHandler.class));
    }
}

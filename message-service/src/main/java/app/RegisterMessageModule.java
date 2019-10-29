package app;

import app.kafka.api.message.RegisterMessage;
import app.kafka.messageHandler.RegisterMessageHandler;
import core.framework.module.Module;

public class RegisterMessageModule extends Module {
    @Override
    protected void initialize() {
        kafka().subscribe("register", RegisterMessage.class, bind(RegisterMessageHandler.class));
    }
}

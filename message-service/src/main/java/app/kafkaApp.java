package app;

import app.kafka.api.message.RegisterMessage;
import app.kafka.api.message.UpdateMessage;
import app.kafka.messageHandler.IncrementCounter;
import core.framework.module.App;
import core.framework.module.SystemModule;

public class kafkaApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        bind(IncrementCounter.class);
        kafka().publish("register", RegisterMessage.class);
        kafka().publish("update", UpdateMessage.class);
        //load(new RegisterMessageModule());
        //load(new UpdateMessageModule());
        load(new JobModule());
    }
}

package app;

import app.kafka.messageHandler.IncrementCounter;
import core.framework.module.App;
import core.framework.module.SystemModule;
import java.time.LocalTime;

public class kafkaApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        bind(IncrementCounter.class);
        load(new RegisterMessageModule());
        load(new UpdateMessageModule());
        load(new JobModule());
    }
}

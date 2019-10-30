package app;

import app.kafka.messagehandler.IncrementCounter;
import core.framework.module.App;
import core.framework.module.SystemModule;

public class KafkaApp extends App {
    @Override
    protected void initialize() {
        //http().httpPort(8088);
        //http().httpsPort(8089);
        load(new SystemModule("sys.properties"));
        bind(IncrementCounter.class);
        //load(new RegisterMessageModule());
        //load(new UpdateMessageModule());
        load(new JobModule());
    }
}

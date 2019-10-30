package app;

import app.kafka.api.message.RegisterMessage;
import app.kafka.api.message.UpdateMessage;
import core.framework.async.Executor;
import core.framework.module.Module;
import core.framework.util.Randoms;

import java.time.Duration;
import java.time.LocalTime;

public class JobModule extends Module {
    private int bindJobCounter = 0;

    @Override
    protected void initialize() {
        kafka().publish("register", RegisterMessage.class);
        kafka().publish("update", UpdateMessage.class);
        Executor executorImpl = executor().add("executorChef", 10);
        schedule().fixedRate("fixedRate", bindNewJobTask(), Duration.ofSeconds(10));
        schedule().trigger("every 7-13 seconds", bindNewJobTask(), time -> time.plusSeconds(Randoms.nextInt(7, 14)));
        schedule().dailyAt("daily", bindNewJobTask(), LocalTime.now().plusSeconds(20));
        onStartup(() -> {
            context.logManager.begin("");
            executorImpl.submit("DelayTask", bindNewJobTask(), Duration.ofSeconds(10));
            for (int i = 0; i < 20000; i++) {
                executorImpl.submit("instantTask", bindNewJobTask());
            }
        });
    }

    private TestJobTask bindNewJobTask() {
        TestJobTask job = new TestJobTask();
        return bind(TestJobTask.class, "TestJobID" + bindJobCounter++, job);
    }
}

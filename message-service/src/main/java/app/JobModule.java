package app;

import core.framework.async.Executor;
import core.framework.module.Module;
import core.framework.util.Randoms;

import java.time.Duration;
import java.time.LocalTime;

public class JobModule extends Module {
    @Override
    protected void initialize() {
        TestJobTask Job = bind(TestJobTask.class);
        Executor Chef = executor().add("executorChef", 10);
        schedule().fixedRate("fixedRate", Job, Duration.ofSeconds(10));
        schedule().trigger("every 7-13 seconds", Job, time -> time.plusSeconds(Randoms.nextInt(7, 14)));
        schedule().dailyAt("daily", Job, LocalTime.now().plusSeconds(20));
        //昨天你说的我忘了，怎么避免Nullpointer?
        Chef.submit("DelayTask", Job, Duration.ofSeconds(10));
        for (int i = 0; i < 200; i++) {
            Chef.submit("instantTask", Job);
        }
    }
}

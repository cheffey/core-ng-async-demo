package app;

import app.kafka.api.message.RegisterMessage;
import app.kafka.api.message.UpdateMessage;
import core.framework.async.Task;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import core.framework.scheduler.Job;
import core.framework.util.Randoms;

import java.util.UUID;

public class TestJobTask implements Job, Task {
    @Inject
    MessagePublisher<RegisterMessage> registerPublisher;
    @Inject
    MessagePublisher<UpdateMessage> updatePublisher;


    @Override
    public void execute() throws Exception {
        if(Randoms.nextInt(0,2)==0)
        {
            executeUpdateMessage();
        }
        else{
            executeRegisterMessage();
        }
    }

    private void executeRegisterMessage(){
        RegisterMessage message=new RegisterMessage();
        message.id= UUID.randomUUID().toString();
        message.reward= Randoms.nextInt(5,10);
        registerPublisher.publish(message);
    }

    private void executeUpdateMessage(){
        UpdateMessage message=new UpdateMessage();
        message.version="1.1"+Randoms.nextInt(1,9);
        message.link="http://chancetop.com";
        updatePublisher.publish(message);
    }
}

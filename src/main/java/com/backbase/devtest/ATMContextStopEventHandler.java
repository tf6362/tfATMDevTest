package com.backbase.devtest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by bbates on 1/16/17.
 */
@Component
public class ATMContextStopEventHandler implements ApplicationListener<ContextClosedEvent> {
    @Autowired
    ATMManager atmManager;
    static Log log = LogFactory.getLog(ATMContextStopEventHandler.class.getName());
    public void onApplicationEvent(ContextClosedEvent event) {

            try {
                atmManager.stopATMRefresh();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
}

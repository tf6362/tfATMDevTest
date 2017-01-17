package com.backbase.devtest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

/**
 * Created by bbates on 1/16/17.
 */
@Component
public class ATMContextRefreshEventHandler  implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    ATMManager atmManager;
    static Log log = LogFactory.getLog(ATMContextRefreshEventHandler.class.getName());
    /**
     * onApplicationEvent - this function causes the ATM data to be loaded form the configured source
     * @param event event triggered by Spring when the application context is started or refreshed
     */
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            atmManager.startATMRefresh();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);

        }
    }

}

package com.backbase.devtest;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * JSONXSSITransformProcessor processor to remove first line for JSON string to implement accepting XSSI Cross Site Script Inclusion
 * Created by bbates on 1/16/17.
 */
public class JSONXSSITransformProcessor implements Processor {
    /**
     * process
     * @param exchange Camel exchange that encapsulates a message and headers
     *
     */
    public void process(Exchange exchange)  {
        String myString = exchange.getIn().getBody(String.class);

        String[] myArray = myString.split("\\n");
        StringBuilder sb = new StringBuilder();
        boolean first=true;
        for (String s : myArray) {
           if(! first)
              sb.append(s);
           first=false;
         }

        exchange.getIn().setBody(sb.toString());
    }
}

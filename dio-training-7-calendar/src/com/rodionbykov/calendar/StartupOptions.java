package com.rodionbykov.calendar;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Created by rodionbykov on 29.06.2014.
 */
public class StartupOptions {

    private Options options;

    public StartupOptions(){
        options = new Options();

        Option help = new Option( "help", "print this message" );
        Option list = new Option( "list", "list all events" );

        options.addOption(help);
        options.addOption(list);
    }

    public Options getOptions(){ return options; }

}

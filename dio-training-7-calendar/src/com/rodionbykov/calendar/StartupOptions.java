package com.rodionbykov.calendar;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
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
        Option today = new Option( "today", "list today's events" );

        Option add  = OptionBuilder.withArgName("date title duration")
                .hasArgs(3)
                .withValueSeparator()
                .withDescription( "add event" )
                .create( "add" );
        Option delete  = OptionBuilder.withArgName("number")
                .hasArgs(1)
                .withValueSeparator()
                .withDescription( "delete event" )
                .create( "delete" );
        Option find  = OptionBuilder.withArgName("title")
                .hasArgs(1)
                .withValueSeparator()
                .withDescription( "find event by title" )
                .create( "find" );
        Option date  = OptionBuilder.withArgName("date")
                .hasArgs(1)
                .withValueSeparator()
                .withDescription( "find event by date" )
                .create( "date" );

        options.addOption(help);
        options.addOption(list);
        options.addOption(today);
        options.addOption(add);
        options.addOption(delete);
        options.addOption(find);
        options.addOption(date);
    }

    public Options getOptions(){ return options; }

}

package org.matsim.analysis;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;

import java.util.Map;

public class SimpleAnalysis {
    // What we want to do: Reaed through the output events file and capture all the person arrival and person departure events.


    public static void main(String[] args){

        SimplePersonEventHandler handler = new SimplePersonEventHandler();
        // Manages all our EventHandlers (we can have multiple ones, in this case we only have one). Pushes the events from the file into the EventHandler
        EventsManager manager = EventsUtils.createEventsManager();
        manager.addHandler(handler);

        EventsUtils.readEvents(manager, "./scenarios/serengeti-park-v1.0/output/output-serengeti-park-v1.0-run1/serengeti-park-v1.0-run1.output_events.xml.gz");

        for(Map.Entry entry : handler.linkHistogram.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
}

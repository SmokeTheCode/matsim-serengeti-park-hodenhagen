package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.floor;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler, LinkLeaveEventHandler {

    private final Map<Id<Person>, Double> personToDepartureTime = new HashMap<>();
    public final Map<Double, Double> linkHistogram = new HashMap<>();

    @Override
    public void handleEvent(PersonDepartureEvent event) {
        personToDepartureTime.put(event.getPersonId(), event.getTime());
    }

    @Override
    public void handleEvent(PersonArrivalEvent event) {
        //System.out.println("Person: " + event.getPersonId() + "Travel time: " + (event.getTime() - personToDepartureTime.get(event.getPersonId())) + "s");
    }

    @Override
    public void handleEvent(LinkLeaveEvent event) {
        if(!event.getLinkId().toString().equals("908198590000r")){
            return;
        }

        if(linkHistogram.containsKey(floor(event.getTime()/3600))){
            linkHistogram.put(floor(event.getTime()/3600), linkHistogram.get(floor(event.getTime()/3600))+1);
        } else {
            linkHistogram.put(floor(event.getTime()/3600), 1.0);
        }
    }
}

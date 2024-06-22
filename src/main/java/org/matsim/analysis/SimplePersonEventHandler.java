package org.matsim.analysis;

import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {

    @Override
    public void handleEvent(PersonArrivalEvent event) {
        System.out.println("Arrival: " + event.getTime() + " : " + event.getPersonId());
    }

    @Override
    public void handleEvent(PersonDepartureEvent event) {
        System.out.println("Departure: " + event.getTime() + " : " + event.getPersonId());
    }
}

package com.allen.dayup.thinkinjava.chap10.section10;

/**
 * @Auther: 20190598
 * @Date: 2019/10/30 11:30
 * @Description:
 */
public class GreenHouseControls extends Controller {

    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();

        gc.add(gc.new Bell(900));

        Event[] events = {
            gc.new ThermostatNight(0),
            gc.new WaterOn(200),
            gc.new WaterOff(400),
            gc.new LightOn(600),
            gc.new LightOff(800),
            gc.new ThermostatDay(1000)
        };

        gc.add(gc.new Restart(2000,events));

        if( args.length > 0 ){
            gc.add(new GreenHouseControls.Terminate(new Integer(args[0])));
        }

        gc.run();
    }

    private boolean light = false;

    public class LightOn extends Event{

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "light is on";
        }
    }

    public class LightOff extends Event{
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "light is off.";
        }
    }


    private boolean water = false;

    public class WaterOn extends Event{

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "water is on";
        }
    }

    public class WaterOff extends Event{
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "water is off.";
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event{

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "thermostat is setting night.";
        }
    }

    public class ThermostatDay extends Event{

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "thermostat is setting day.";
        }
    }

    public class Bell extends Event{

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            add(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bell ring!";
        }
    }


    public class Restart extends Event{

        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;

            for ( Event event : eventList ){
                add(event);
            }
        }

        @Override
        public void action() {
            for ( Event event : eventList ){
                event.start();
                add(event);
            }

            start();
            add(this);
        }

        @Override
        public String toString() {
            return "restart system.";
        }
    }

    public static class Terminate extends Event{


        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "System terminate.";
        }
    }
}

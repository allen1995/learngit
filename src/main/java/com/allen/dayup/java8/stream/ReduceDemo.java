package com.allen.dayup.java8.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

/**
 * @Auther: 20190598
 * @Date: 2021/6/3 14:53
 * @Description:
 */
public class ReduceDemo {

    public static void main(String[] args) {
        List<Map<String,Object>> eventlist = new ArrayList<>();
        Map<String,Object> event1 = new HashMap<>();
        event1.put("eventcode","DoorOpen");
        event1.put("total", 10);
        event1.put("unread",1);
        eventlist.add(event1);

        Map<String,Object> event2 = new HashMap<>();
        event2.put("eventcode","DoorOpen2");
        event2.put("total", 10);
        event2.put("unread",1);
        eventlist.add(event2);

        Map<String,Object> event3 = new HashMap<>();
        event3.put("eventcode","alarm");
        event3.put("total", 10);
        event3.put("unread",1);
        eventlist.add(event3);

        Map<String,Long> groupEvent = eventlist.stream()
                .map( event -> {
                    String identifier = event.get("eventcode").toString().split("\\d+$")[0];
                    event.put("eventcode", identifier);
                    return event;
                })
                .collect(Collectors.groupingBy( map -> getEventcode(map), Collectors.counting() ));

        Map<String,Long> unreadCount = eventlist.stream()
                .map( event -> {
                    String identifier = event.get("eventcode").toString().split("\\d+$")[0];
                    event.put("eventcode", identifier);
                    return event;
                })
                .collect(Collectors.groupingBy( map -> getEventcode(map),  Collectors.summingLong(ReduceDemo::mapToTotal)));

        System.out.println(groupEvent);

    }

    private static Long mapToTotal(Map<String,Object> map) {
        Long total = Long.valueOf(map.get("unread").toString()) ;
        return total;
    }

    private static String getEventcode(Map<String,Object> map) {
        return map.get("eventcode").toString();
    }
}

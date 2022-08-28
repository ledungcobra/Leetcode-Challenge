package com.ledung;

import java.util.*;
import java.util.stream.Collectors;

public class KeyAndRoom {
    public static boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>(rooms.get(0));
        rooms.get(0).clear();
        var iter = keys.iterator();
        while (iter.hasNext()) {
            var key = iter.next();
            var curRoom = rooms.get(key);
            if (curRoom.isEmpty()) {
                continue;
            }
            Set<Integer> tmp = curRoom.stream().filter(k -> !keys.contains(k)).collect(Collectors.toSet());
            keys.addAll(tmp);
            curRoom.clear();
            keys.remove(key);
            iter = keys.iterator();
        }
        for (var room : rooms) {
            if (!room.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        var beginRoom = 0;
        visited.add(beginRoom);
        Stack<Integer> pendingKey = new Stack<>();
        pendingKey.addAll(rooms.get(beginRoom));
        while (!pendingKey.isEmpty()) {
            var curKey = pendingKey.pop();
            var keysOfCurRoom = rooms.get(curKey);
            visited.add(curKey);
            for (var key : keysOfCurRoom) {
                if (!visited.contains(key)) {
                    pendingKey.add(key);
                }
            }
        }

        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        System.out.println(canVisitAllRooms1(List.of(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(2)), new ArrayList<>(List.of(3)), new ArrayList<>(List.of()))));
        System.out.println(canVisitAllRooms(List.of(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(2)), new ArrayList<>(List.of(3)), new ArrayList<>(List.of()))));
    }
}

package com.software.bookstore.utils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Resources {
    public static Set<String> setPrivateRoutes(String ... routes) {
        return Stream.of(routes).map(value -> value).collect(Collectors.toSet());
    }    
}

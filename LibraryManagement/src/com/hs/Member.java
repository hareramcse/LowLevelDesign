package com.hs;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String id;
    private final String name;
    private final List<Book> borrowed = new ArrayList<>();

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String id() { return id; }
    public String name() { return name; }
    public List<Book> borrowed() { return borrowed; }
}

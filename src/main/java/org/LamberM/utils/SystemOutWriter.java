package org.LamberM.utils;

public class SystemOutWriter implements OutputWriter {
    public String show(String text) {
        System.out.println(text);
        return text;
    }
}

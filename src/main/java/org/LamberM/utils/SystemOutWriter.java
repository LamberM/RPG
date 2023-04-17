package org.LamberM.utils;


import lombok.Getter;
import lombok.Setter;

public class SystemOutWriter implements OutputWriter {
    @Getter
    @Setter
    private String text;
    public String show() {
        System.out.println(text);
        return text;
    }

}

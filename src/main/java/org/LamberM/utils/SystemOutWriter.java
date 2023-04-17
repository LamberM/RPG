package org.LamberM.utils;




public class SystemOutWriter implements OutputWriter {
    @Override
    public String show(String text) {
        System.out.println(text);
        return text;
    }

}

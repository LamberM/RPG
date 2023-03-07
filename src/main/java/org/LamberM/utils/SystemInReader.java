package org.LamberM.utils;

import java.util.Scanner;

public class SystemInReader implements InputReader
{
    @Override
    public String read()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}

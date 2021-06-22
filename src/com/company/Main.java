package com.company;

/**
 * The Main class which starts program
 *
 * @author Rafał Karwowski
 * @version 2.0
 * @since 01.05.2020
 */

public class Main implements LoggerInterface {

    public static void main(String[] args){

        new MainFrame();
        log.info("Start MainFrame.");
        new TOTD();

    }
}

package Presentation;

import DataAccess.Serializator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new FirstPage();
        new Serializator();
    }
}

package ikt;


import de.htwberlin.fiw.profiler.ProfiledClass;
import de.htwberlin.fiw.profiler.Profiler;

import java.util.Random;

public class Main extends ProfiledClass {

    public void run() {

        DoubleLinkedList meineListe = new DoubleLinkedList();
        Random r = new Random();


        for (int i = 1; i < 10000; i++) {
            DoubleLinked e = new DoubleLinked(r.nextInt());
            meineListe.append(e);
        }

        for (int i = 1; i < 10000; i++) {
            DoubleLinked e = meineListe.get(i);
            System.out.println(e.data);
        }

        for (int i = 9999; i >= 1; i--) {
            DoubleLinked e = meineListe.get(i);
            System.out.println(e.data);
        }
    }

    public static void main(String[] args) {
        Profiler profiler = new Profiler(Main.class);
        profiler.start();
        profiler.printResults();
    }
}

package com.example.termin17jelofragment;

import java.util.ArrayList;
import java.util.List;

//
//public static Jelo[] jela = new Jelo[]{
//        new Jelo(1, "jelo1.jpg", "Sarma", "Sarma sa kupusom", "Glavno jelo", "Mleveno meso i kupus", 300, 500),
//        new Jelo(2, "jelo2.jpg", "Palacinke", "Palacinka sa kremom i plazmom", "Desert", "Jaja , brasno , mleko , voda , krem , plazma", 450, 150),
//        new Jelo(3, "jelo3.jpg", "Salata", "Salata od kupusa", "Dodatak jelu", "Kupus , sirce , so", 40, 100),
//        new Jelo(4, "jelo4.jpg", "Meze", "Lako jelo pre glavnog jela", "Predjelo", "Kulen , slanina , salama , sir", 150, 200),
//        };

public class JeloProvider {
    private static List<Jelo> jela = null;

    private static void init() {
        if (jela == null) {
            jela = new ArrayList<>();
            jela.add(new Jelo(
                    0, "jelo1.jpg", "Sarma", "Sarma sa kupusom", "Glavno jelo",
                    "Mleveno meso i kupus"
                    , 300, 499.99));
            jela.add(new Jelo(
                    1, "jelo2.jpg", "Palacinke", "Palacinka sa kremom i plazmom", "Desert",
                    "Jaja , brasno , mleko , voda , krem , plazma", 450, 149.99));
            jela.add(new Jelo(
                    2, "jelo3.jpg", "Salata", "Salata od kupusa", "Dodatak jelu",
                    "Kupus , sirce , so", 40, 99.99));
            jela.add(new Jelo(
                    3, "jelo4.jpg", "Meze", "Lako jelo pre glavnog jela", "Predjelo",
                    "Kulen , slanina , salama , sir", 150, 199.99));
        }
    }

    public static List<Jelo> getAllJela() {
        init();

        return jela;
    }

    public static Jelo getJeloById(int id) {
        init();

        if (id >= 0 && id < jela.size()) {
            return jela.get(id);
        }
        return null;
    }
}

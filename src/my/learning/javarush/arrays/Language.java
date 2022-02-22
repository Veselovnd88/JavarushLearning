package my.learning.javarush.arrays;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Language {
    private String name;
    private Double ranking;

    public Language(String name, Double ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public Double getRanking() {
        return ranking;
    }

    @Override
    public String toString() {
        return "Язык программирования - " + name + ", рейтинг  - " + ranking + "% опрошенных.";
    }
    public static Stream<Language> sortByRanking(ArrayList<Language> languages) {
        //напишите тут ваш код
        return languages.stream().sorted((x,y) ->(Double.compare(y.getRanking(),x.getRanking())));
    }
}

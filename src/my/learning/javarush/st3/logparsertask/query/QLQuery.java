package my.learning.javarush.st3.logparsertask.query;

import java.util.Set;

public interface QLQuery {
    Set<Object> execute(String query);
}

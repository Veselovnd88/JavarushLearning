package my.learning.javarush.st3.url;

import java.util.ArrayList;
import java.util.List;

public class Polygs {

    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = polygon.size() - 1; i < polygon.size(); j = i++) {
            /* берем каждый отрезок полигона = i - текущая точка, j - предыдущая*/

            if ((polygon.get(i).y > point.y) != (polygon.get(j).y > point.y)
                    //первая строчка - находится ли точка на уровне этого отрезка
                    &&//тут про пересечение лучшей
                    (point.x < (polygon.get(j).x - polygon.get(i).x) * (point.y - polygon.get(i).y) / (polygon.get(j).y - polygon.get(i).y) + polygon.get(i).x)) {
                result = !result;
            }
        }
        return result;
    }



}

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

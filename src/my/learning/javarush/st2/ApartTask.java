package my.learning.javarush.st2;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ApartTask {
    public static void task(){

            List<Apartment> apartments = new ArrayList<Apartment>();
            apartments.add(new OneRoomApt());
            apartments.add(new TwoRoomApt());
            apartments.add(new ThreeRoomApt());

            cleanAllApartments(apartments);
        }

        public static void cleanAllApartments(List<Apartment> apartments) {
            apartments.forEach(x ->{
                if (x instanceof OneRoomApt){
                    ((OneRoomApt) x).clean1Room();
                }
                else if( x instanceof TwoRoomApt){
                    ((TwoRoomApt) x).clean2Rooms();
                }
                else if( x instanceof ThreeRoomApt){
                    ((ThreeRoomApt) x).clean3Rooms();
                }
            });
        }

        static interface Apartment {
        }

        static class OneRoomApt implements Apartment {
            void clean1Room() {
                System.out.println("1 room is cleaned");
            }
        }

        static class TwoRoomApt implements Apartment {
            void clean2Rooms() {
                System.out.println("2 rooms are cleaned");
            }
        }

        static class ThreeRoomApt implements Apartment {
            void clean3Rooms() {
                System.out.println("3 rooms are cleaned");
            }
        }
    }


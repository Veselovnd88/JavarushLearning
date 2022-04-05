package my.learning.javarush.st2.serialization;

import java.io.*;

public class FindErrorTask implements Serializable {
    public static class A {

        protected String nameA = "A";// протектед
        public A(){}
        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA); //name A = name A
            this.nameA += nameA;//
            this.nameB = nameB;
        }

        private void writeObject(ObjectOutputStream out) throws IOException{
            out.defaultWriteObject();//поле с класса А не сериализируется, поэтому сначала пишем то что пишется
            out.writeObject(this.nameA);// потом пишем то что не пишется вручную



        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            in.defaultReadObject(); // тут наоборот - сначала выгружаем то что выгружается (объект This)

            this.nameA = (String) in.readObject();//и догружаем то чего не было в базовом


        }


    }

    public static void task(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        FindErrorTask solution = new FindErrorTask();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}

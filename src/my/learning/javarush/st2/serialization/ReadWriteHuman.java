package my.learning.javarush.st2.serialization;

import my.learning.javarush.st2.DebugTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWriteHuman {

    public static void task() {

        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("src/my/learning/javarush/st2/serialization",null);
            OutputStream outputStream = new FileOutputStream("src/my/learning/javarush/st2/out1.txt");
            InputStream inputStream = new FileInputStream("src/my/learning/javarush/st2/out1.txt");
            //Human zero = new Human(null, new Asset("hate", 100.00));
            //zero.save(outputStream);

           Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
           ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(somePerson.equals(ivanov));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            String haveName = this.name!=null? "name yes": "name no";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write(haveName+"\n");//записали имя
            bw.flush();// отправили в файл
            if(this.name!=null){
                bw.write(this.name+"\n");
            }
            String haveAssets = this.assets!=null? "assets yes":"assets no";
            bw.write(haveAssets+"\n");
            bw.flush();
            if(this.assets!=null){
                assets.forEach(x->{
                    try {
                        bw.write(x.getName()+" "+x.getPrice()+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } bw.flush();


        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String name=null;
            List<String> assetsStrings = new ArrayList<>();
            while (br.ready()){
                if(br.readLine().split(" ")[1].equals("yes")){
                    name = br.readLine();
                }
                if(br.readLine().split(" ")[1].equals("yes")){
                    String line;
                    while (!((line = br.readLine()) ==null)){
                        assetsStrings.add(line);
                    }
                }
                this.name = name;
                assetsStrings.forEach(x-> {
                    assets.add(new Asset(x.split(" ")[0], Double.parseDouble(x.split(" ")[1])));
                });

            }
        }
    }

}


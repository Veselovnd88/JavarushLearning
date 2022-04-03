package my.learning.javarush.st2.serialization;

import java.io.*;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadWriteJavarush {


    public static void task(){
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            String yourFile = "src/my/learning/javarush/st2/out1.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);
            JavaRush javaRush = new JavaRush();
            User ivanov = new User();
            ivanov.setLastName("Ivanov");
            ivanov.setFirstName("Vanya");
            ivanov.setBirthDate(new Date(1648984768060l));
            ivanov.setMale(true);
            ivanov.setCountry(User.Country.OTHER);
            javaRush.users.add(ivanov);
            User petrov = new User();
            petrov.setLastName("Ivanovsdf");
            petrov.setFirstName("Vanyda");
            petrov.setBirthDate(new Date(1648984768060l));
            petrov.setMale(true);
            petrov.setCountry(User.Country.OTHER);
            javaRush.users.add(petrov);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            String haveUsers = users.size()>0?"users yes":"users no";
            bw.write(haveUsers+"\n");
            bw.flush();

            if(users.size()>0){

                for(User u: users){
                    StringBuilder sb = new StringBuilder();
                    sb.append(u.getFirstName()+" ");
                    sb.append(u.getLastName()+" ");
                    sb.append(u.getBirthDate().getTime()+" ");
                    sb.append(u.isMale()+" ");
                    sb.append(u.getCountry().getDisplayName()+"\n");
                    bw.write(sb.toString());
                    bw.flush();

                }
            } bw.close();

        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String firstLine = br.readLine();
            if(firstLine.split(" ")[1].equals("yes")){
                String line;

                while(!((line = br.readLine())==null)){
                    User user = new User();
                    String[] parts = line.split(" ");
                    user.setFirstName(parts[0]);
                    user.setLastName(parts[1]);
                    user.setBirthDate(new Date(Long.parseLong(parts[2])));
                    user.setMale(Boolean.parseBoolean(parts[3]));
                    if(parts[4].equals("Ukraine")){
                        user.setCountry(User.Country.UKRAINE);
                    }
                    else if(parts[4].equals("Russia")){
                        user.setCountry(User.Country.RUSSIA);
                    }
                    else{
                        user.setCountry(User.Country.OTHER);
                    }

                this.users.add(user);

                }
            }br.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

    }

}

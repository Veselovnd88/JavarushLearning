package my.learning.javarush.st3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.security.MessageDigest;

public class md5task {
    public static void task() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(byteArrayOutputStream.toByteArray());// сюда скормили байтовый массив
        byte[] digest = md.digest();
        StringBuffer sb  =new StringBuffer();
        for (int i = 0; i<digest.length; i++){
            String x = Integer.toHexString(0xFF&digest[i]);// каждый байт переводим в шестнадцатиричное значение
            if(x.length()<2){
                x = "0"+x;//добавили лидирующие нули
            }
            sb.append(x);

        }


        return sb.toString().equals(md5);
    }
}

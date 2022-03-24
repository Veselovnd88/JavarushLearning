package my.learning.javarush.st2;

import my.learning.javarush.arrays.ArraysTasks;

import java.io.*;
import java.util.*;

public class PlayInputOutputStreams {

    public static void task(){
        read1000();

    }
    public static void training(){
        try{
        FileInputStream fis = new FileInputStream("src/my/learning/javarush/arrays/in.txt");
        long sum = 0;
            while(fis.available()>0){
                int data = fis.read();
                sum+=data;
            }
        fis.close();
            System.out.println(sum);}
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }




    }

    public static void maxByte(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            FileInputStream fis = new FileInputStream(file);
            int max = 0;
            while(fis.available()>0){
                int curr = fis.read();
                if(curr>max){
                    max = curr;
                }
            }fis.close();
            System.out.println(max);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void oftenBytes(){
        //src/my/learning/javarush/arrays/in.txt
        HashMap<Integer,Integer> hm = new HashMap<>();

        int count = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            FileInputStream fis = new FileInputStream(file);
            while (fis.available()>0){
                count++;
                int bt = fis.read();
                if (hm.containsKey(bt)){
                    hm.put(bt, hm.get(bt)+1);
                }
                else {
                    hm.put(bt,1);
                }
            } int max=0;
            for (Map.Entry<Integer,Integer> en: hm.entrySet()){
                if (en.getValue()>max){
                    max = en.getValue();
                }
            }
            for (Map.Entry<Integer, Integer> en :hm.entrySet()){
                if( en.getValue()==max){
                    System.out.print(en.getKey()+" ");
                }
            }


            fis.close();
            //System.out.println(l.size());
            //System.out.println(count);



        } catch (Exception e){
            e.printStackTrace();

        }
    }
    public static void rareBytes(){
        //src/my/learning/javarush/arrays/in.txt
        HashMap<Integer,Integer> hm = new HashMap<>();

        int count = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            FileInputStream fis = new FileInputStream(file);
            while (fis.available()>0){
                count++;
                int bt = fis.read();
                if (hm.containsKey(bt)){
                    hm.put(bt, hm.get(bt)+1);
                }
                else {
                    hm.put(bt,1);
                }
            } int min=Integer.MAX_VALUE;
            for (Map.Entry<Integer,Integer> en: hm.entrySet()){
                if (en.getValue()<min && en.getValue()!=0){
                    min = en.getValue();
                }
            }
            for (Map.Entry<Integer, Integer> en :hm.entrySet()){
                if( en.getValue()==min){
                    System.out.print(en.getKey()+" ");
                }
            }
            fis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sortBytes(){
        Set<Integer> bytesSet = new TreeSet<>();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            FileInputStream fis = new FileInputStream(file);
            while(fis.available()>0){
                int bt = fis.read();
                bytesSet.add(bt);
            }
            bytesSet.forEach(x-> System.out.print(x+" "));
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void commas(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            FileInputStream fis = new FileInputStream(file);
            int count = 0;
            while (fis.available()>0){
                if(fis.read()==44){
                    count++;
                }
            }fis.close();
            System.out.println(count);

        }
        catch ( Exception e){
            e.printStackTrace();
        }
    }

    public static void divideBytes(){

        //src/my/learning/javarush/arrays/in.txt
        int count1 = 0;
        int count2= 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file1 = br.readLine();
            String file2 = br.readLine();
            String file3 = br.readLine();
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fout1 = new FileOutputStream(file2);
            FileOutputStream fout2 = new FileOutputStream(file3);
            int len = fis.available();
            while(fis.available()>0){
                if(fis.available()>len/2){
                    fout1.write(fis.read());
                    count1++;
                } else{
                    fout2.write(fis.read());
                    count2++;
                }

            }fis.close();
            fout1.close();
            fout2.close();
            System.out.println(count1);
            System.out.println(count2);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void reverseBytes(){
        List<Integer> buff = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            String file1 = br.readLine();
            String file2 = br.readLine();
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fout1 = new FileOutputStream(file2);
            while(fis.available()>0){
                buff.add(fis.read());
            }
            for(int i=buff.size()-1; i>=0;i--){
                fout1.write(buff.get(i));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void read1000(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String file = br.readLine();
                FileInputStream fis = new FileInputStream(file);
                if(fis.available()<1000){
                    fis.close();
                    throw new DownloadException();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static class DownloadException extends Exception {

    }
}

package my.learning.javarush.st3.references;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;


public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if(!cache.containsKey(key)){// если нет ключа, то
            Constructor<V> c = clazz.getConstructor(key.getClass());// получаем  конструктор из переданного класса
            //получаю именно тот конструктор который с параметром
            V val = c.newInstance(key);// создаем новый объект с параметром К
            cache.put(key,val);
        }

        return cache.get(key);
    }

    public boolean put(V obj) {
        try{
        Method getKey = obj.getClass().getDeclaredMethod("getKey");//у этого класса должен быть метод кетКи - вот мы его получили в метод
        getKey.setAccessible(true);//разрешили доступ
        K key = (K) getKey.invoke(obj); // вызываем у объекта
            cache.put(key,obj);
            return true;
        }
        catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int size() {
        return cache.size();
    }
}

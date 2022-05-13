package my.learning.javarush.st3.shortener.strategy;

public class OurHashMapStorageStrategy implements  StorageStrategy{

    static final int DEFAULT_INITIAL_CAPACITY = 16;// начальная величина
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];

    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k){
        return k.hashCode();
    }
    public int indexFor(int hash, int length){
        return hash & (length-1);// побитовое И (выполняется быстрее, а по сути то же самое что hash % length
        //вычисляется номер бакета(корзины) в которой лежит значение
    }

    public Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash(key); // если ключ нулевой, то вернуть ноль, если нет - то хэш
        for (Entry e = table[indexFor(hash, table.length)];// ключ Лонг, получаем индекс хеша в нашей таблице
             e != null;//перебор всех эелементов массива
             e = e.next) {
            Long k;
            if (e.hash == hash &&// сначала сравнение по хешу, потом по ссылку, потом по equal
                    ((k = e.key) == key || (key != null && key.equals(k))))// () (к !=0 и к то ки)
                return e;
        }
        return null;


    }
    public void resize(int newCapacity){
        Entry[] newTable = new Entry[newCapacity];//создание новой таблицы
        transfer(newTable);// перенос старой таблицы в новую таблицу
        table = newTable;// присвоение новой таблицы полю
        threshold = (int) (newCapacity * loadFactor);// перезанзначение границы
    }

    public void transfer(Entry[] newTable){// перенос из старой таблицы в новую
        Entry[] src = table;// присвоили в новую ссылку текущую таблица
        int newCapacity = newTable.length;// новая емкость
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j];// итерация по старой таблице - ентри - из текущей таблицы
            if (e != null) {// если не нулл
                src[j] = null;//обнулили текущее ентри
                do {
                    Entry next = e.next;// следующий
                    int i = indexFor(e.hash, newCapacity);// вычисляем  индекс в новой таблице для ентри
                    e.next = newTable[i];// следующий элемент - равен элементу из новой таблицы с этим индексом
                    newTable[i] = e;// в ту ячейку пишем ентри
                    e = next; //в энтри пишем следующее
                } while (e != null);//цикл пока не наткнемся на нулл
            }
        }

    }

    public void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];// ентри - забираем из текущей таблицы
        table[bucketIndex] = new Entry(hash, key, value, e);// создали ентри с параметрами - хеш, ключ, следующий, новый поставили перед текущим
        if (size++ >= threshold)// увеличили размер, если он ббольше границы - то делаем ресайз в 2 раза больше
            resize(2 * table.length);
    }
    public void createEntry(int hash, Long key, String value, int bucketIndex){// тоже самое что и добавить ентри но без проверки ресайза
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key)!=null;
    }

    @Override
    public boolean containsValue(String value) {
        for (Entry e:table){
            while(e!=null){
                if(e.value.equals(value)){
                    return true;
                } else{
                    e = e.next;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);// рассчитали хеш для ключа
        int index = indexFor(hash, table.length);//определили куда вставщять
        for (Entry e = table[index]; e != null; e = e.next) {//идем по всем ключам, если находим такой же - то обновляем
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, index);// если нет - до добавляем
    }

    @Override
    public Long getKey(String string) {
        for(Entry e: table){
            for(Entry elem = e; elem!=null; elem = e.next){
                if(e.value.equals(string)){
                    return e.key;
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);// взяли ентри
        if (entry != null)
            return entry.getValue();

        return null;
    }
}

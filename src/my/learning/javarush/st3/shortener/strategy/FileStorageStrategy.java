package my.learning.javarush.st3.shortener.strategy;

import java.io.File;

public class FileStorageStrategy implements StorageStrategy{
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    static final int DEFAULT_INITIAL_CAPACITY = 16;// начальная величина
    //static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000l;
    int size;
    private long maxBucketSize;

    //int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
   // float loadFactor = DEFAULT_LOAD_FACTOR;
    public Long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(Long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
    public int hash(Long k){
        return k.hashCode();
    }
    public int indexFor(int hash, int length){
        return hash & (length-1);// побитовое И (выполняется быстрее, а по сути то же самое что hash % length
        //вычисляется номер бакета(корзины) в которой лежит значение
    }

    public Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash(key); // если ключ нулевой, то вернуть ноль, если нет - то хэш
        FileBucket fb = table[indexFor(hash, table.length)];//забрали файлбакет

        for (Entry e = fb.getEntry();// забрали Ентри с файлбакета
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
        FileBucket[] newTable = new FileBucket[newCapacity];//создание новой таблицы
        transfer(newTable);// перенос старой таблицы в новую таблицу
        table = newTable;// присвоение новой таблицы полю
        //threshold = (int) (newCapacity * loadFactor);// перезанзначение границы
    }

    public void transfer(FileBucket[] newTable){// перенос из старой таблицы в новую
        int newCapacity = newTable.length;// новая емкость

        for (FileBucket fb : table) {//итерируемся по таблице, забираем каждый бакет
            Entry e = fb.getEntry();//взяли ентри
            while (e != null) {//пошли по всем ентри
                Entry next = e.next;
                int indexInNewTable = indexFor(hash(e.getKey()), newCapacity);// определили новый индекс в новой таблицы
                e.next = newTable[indexInNewTable].getEntry();
                newTable[indexInNewTable].putEntry(e);
                e = next;
            } fb.remove();
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        FileBucket fb = table[bucketIndex];
        if(fb!=null){
        if ( fb.getFileSize()>= bucketSizeLimit){
            resize(2 * table.length);
            hash = hash(key);
            bucketIndex = indexFor(hash, table.length);
        }}

        createEntry(hash, key, value, bucketIndex);
    }
    public void createEntry(int hash, Long key, String value, int bucketIndex){// тоже самое что и добавить ентри но без проверки ресайза
        FileBucket fb = table[bucketIndex];//взяли наш бакет
        if(fb!=null){
        Entry e = fb.getEntry();// выьтащили из него ентри
        fb.putEntry(new Entry(hash, key, value, e));// положили туда новое ентри со next = тот которые только что вытазили
        table[bucketIndex] = fb;// положили бакет обратно в таблицу
        size++;//увеличили размер
    }   else{
            FileBucket newFb = new FileBucket();
            newFb.putEntry(new Entry(hash,key,value,null));
            table[bucketIndex] = newFb;
            size++;
        }
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key)!=null;
    }

    @Override
    public boolean containsValue(String value) {
        for(FileBucket fb: table){
            if( fb!=null){
            Entry e = fb.getEntry();

            while(e!=null){
                if(e.value.equals(value)){
                    return true;
                } else{
                    e = e.next;
                }
            }
        }}
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);// рассчитали хеш для ключа
        int index = indexFor(hash, table.length);//определили куда вставщять
        FileBucket fb = table[index];
        if( fb!=null){
        for (Entry e = table[index].getEntry(); e != null; e = e.next) {//идем по всем ключам, если находим такой же - то обновляем
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }}
        addEntry(hash, key, value, index);// если нет - до добавляем
    }

    @Override
    public Long getKey(String string) {
        for (FileBucket fb: table){
            if(fb!=null){
            Entry e = fb.getEntry();
            for(Entry elem = e; elem!=null; elem = e.next){
                if(e.value.equals(string)){
                    return e.key;
                }
            }
        }}
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

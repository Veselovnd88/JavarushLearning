package my.learning.javarush.st3;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomTree extends AbstractList<String> implements Serializable,Cloneable {
    public Entry<String> root;
    public List<Entry> listTree = new ArrayList<>();

    public CustomTree(){
        this.root = new Entry<>("name");
        listTree.add(root);

    }
    public String getParent(String s){
        for (Entry e: listTree){
            if(e.elementName!=null){
                if(e.elementName.equals(s)){
                    return e.parent.elementName;
                }
            }
        }return null;
    }

    @Override
    public boolean add(String s) {
        for (Entry e: listTree){
            if (e.isAvailableToAddChildren()){//у нас есть рут, если у него ветки установлены в тру
                Entry<String> newElem = new Entry<>(s);//создаем новый элемент
                newElem.parent = e;//устанавливаем родителя
                if (e.availableToAddLeftChildren){//проверяем левую ветвь

                    e.leftChild = newElem;// устанавливаем в левую ветвь
                    e.availableToAddLeftChildren = false;//ставим фолс на лвую ветвь
                    listTree.add(newElem);// добавили в наш список
                    return true;
                } else if (e.availableToAddRightChildren) {
                    e.rightChild = newElem;
                    e.availableToAddRightChildren = false;
                    listTree.add(newElem);
                    return true;
                }
            }
        } return false;
    }



    static class Entry<T> implements  Serializable{
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry <T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry (String s)  {
            this.elementName = s;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            return this.availableToAddLeftChildren || this.availableToAddRightChildren;
        }

    }
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return listTree.size()-1;
    }




}

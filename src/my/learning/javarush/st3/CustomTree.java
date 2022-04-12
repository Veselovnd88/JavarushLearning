package my.learning.javarush.st3;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomTree extends AbstractList<String> implements Serializable,Cloneable {
    public Entry<String> root;
    public List<Entry> listTree = new ArrayList<>();
    private List<Entry> removeList = new ArrayList<>();

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



    @Override
    public boolean remove(Object o) {
        if (! (o instanceof String)){
            throw new UnsupportedOperationException();
        }
        String name = (String) o;
        for (Entry e:listTree){
                if(e.elementName.equals(name)){
                    subRemove(e);
                    setAvailables();
                    return true;
                }
            }return false; }


    public boolean checkAvailables(){
        boolean flag = false;
        for (Entry e: listTree){
            if(e.availableToAddRightChildren || e.availableToAddLeftChildren){
               flag = true;

            }
        } return flag;
    }
    public void setAvailables(){
        if(!checkAvailables()){
        for (Entry e: listTree){
            //System.out.println("Проверяю ентри " +e.elementName);
            //System.out.println("Левая "+e.availableToAddLeftChildren);
            //System.out.println("Правая "+ e.availableToAddRightChildren);
//            System.out.println(e.rightChild.elementName+"____"+ e.leftChild.elementName);
            if(e.leftChild==null){
                //System.out.println("Нет левой ветки у "+e.elementName);
                e.availableToAddLeftChildren=true;
            }
            if(e.rightChild==null){
                //System.out.println("Нет правой ветки у "+e.elementName);
                e.availableToAddRightChildren=true;
            }
        }
    }}

    public void subRemove(Entry e){
        if(e.rightChild!=null){

            subRemove(e.rightChild);

        }
        if(e.leftChild!=null){
            subRemove(e.leftChild);

        }
        if(e.parent.rightChild!=null){
            if(e.parent.rightChild.equals(e)){
                e.parent.rightChild = null;
                //e.parent.availableToAddRightChildren = true;
            }
        }
        if(e.parent.leftChild!=null){
            if(e.parent.leftChild.equals(e)){
                e.parent.leftChild = null;
                //e.parent.availableToAddLeftChildren = true;
            }
        }



        listTree.remove(e);


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

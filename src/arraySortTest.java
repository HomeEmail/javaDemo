import javax.xml.bind.Element;
import java.util.*;

class Animal{
    int size;
}
class Dog extends Animal{
    public Dog(int s){
        size = s;
    }
}
class Cat extends Animal{
    int weight;
    public Cat(int s,int w){
        size = s;
        weight = w;
    }
}

//<Animal>标识Comparator接口只传入Animal类型,因为compare参数是Animal类型，否则出错
class AnimalSizeComparator implements Comparator<Animal>{

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.size - o2.size;
    }
    //in this way,all sub classes of Animal can use this
}

class CatWeightComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat d1, Cat d2){
        return  d1.weight - d2.weight;
    }
}


public class arraySortTest {
    public static void main(String[] args){
        Dog d1=new Dog(2);
        Dog d2=new Dog(1);
        Dog d3=new Dog(3);
        Dog[] dogArray = {d1,d2,d3};
        System.out.println("dog:");
        printDogs(dogArray);

        System.out.println("dog size排序");
        Arrays.sort(dogArray,new AnimalSizeComparator());
        printDogs(dogArray);

        Cat c1 = new Cat(7,3);
        Cat c2 = new Cat(1,7);
        Cat c3 = new Cat(3,1);
        Cat[] catArray = {c1,c2,c3};
        System.out.println("cat:");
        printDogs(catArray);

        System.out.println("cat size 排序");
        Arrays.sort(catArray,new AnimalSizeComparator());
        printDogs(catArray);

        System.out.println("cat weight 排序");
        Arrays.sort(catArray,new CatWeightComparator());
        printCats(catArray);

        //Java中数组(Array)转ArrayList的最高效方法
        Dog[] array = {new Dog(1),new Dog(2)};
        List list = new ArrayList(array.length);
        Collections.addAll(list,array);
        list.add(new Dog(3));//动态添加一个项
        System.out.println("ArrayList length:"+list.size());
        System.out.println("ArrayList[0] object class:"+list.get(0).getClass());
        System.out.println("ArrayList[1] object value:"+((Dog)list.get(1)).size);//要强制类型转换成Dog

        //遍历数组（集合类）时，需要删除项，使用迭代器iterator来做循环，直接用for语法会报错
        Iterator iter = list.iterator();
        while (iter.hasNext()){
            Dog d=((Dog)iter.next());
            if(d.size==1){//找到要删除的项了
                iter.remove();
            }
        }
        System.out.println("after delete a item -> ArrayList length:"+list.size());


        //HashSet test
        System.out.println("HashSet test:");
        Set set = new HashSet();
        set.add("天天");
        set.add("编码");

        //直接在for语法会报错 删除元素 运行时会报错,应该改用迭代器iterator
        /*for(Object s:set){
            if(s.equals("编码")){
                System.out.println("HashSet will remove a item");
                set.remove(s);

            }
        }*/
        Iterator iterSet=set.iterator();
        while (iterSet.hasNext()){
            String s=(String)iterSet.next();
            if(s.equals("编码")){
                iterSet.remove();
                System.out.println("HashSet removed a item");
            }
        }



    }
    public static void printDogs(Animal[] animals){
        for(Animal a:animals){
            System.out.print("size="+a.size+"; ");
        }
        System.out.println();
    }
    public static void printCats(Cat[] cats){
        for(Cat a:cats){
            System.out.print("size="+a.size+" "+"weight="+a.weight+"; ");
        }
        System.out.println();
    }
}

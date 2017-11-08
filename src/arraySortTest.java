import java.util.Arrays;
import java.util.Comparator;


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

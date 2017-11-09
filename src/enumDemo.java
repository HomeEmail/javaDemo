
//普通枚举示例
enum Animals{
    //每个变量都是Animal的一个实例
    DOG,CAT,PUG;
}

enum Color{
    RED(1),YELLOW(2),BLUE(3);
    private int value;
    private Color(){}
    private Color(int i){
        this.value=i;
    }
    public void printValue(){
        System.out.println(this.value);
    }
}


public class enumDemo {

    public static void main(String[] args){
        //do you do
        System.out.println("普通枚举示例：");
        for (Animals a : Animals.values()){
            System.out.println(a);
            System.out.println(a.toString().equals("DOG"));
        }

        System.out.println("有构造函数的枚举示例：");
        for(Color c : Color.values()){
            System.out.println(c);
            System.out.println(c.compareTo(Color.BLUE));
            c.printValue();
        }
        System.out.println("Color.BLUE:"+Color.BLUE);
    }

}

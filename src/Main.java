public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("fuck u!");

        //神奇的字符串：参考http://www.tiantianbianma.com/java-string.html/
        //demo
        final String str = "ma.com";
        String strA = "www.tiantianbianma.com";
        String strB = "www.tiantian"+"bianma.com";
        String strC = "www.tiantianbian"+str;
        String strD = new String("www.tiantianbianma.com");

        System.out.println(strA.equals(strB));
        System.out.println(strA == strB);
        System.out.println(strA.equals(strC));
        System.out.println(strA == strC);

        System.out.println(strA==strD);
        System.out.println(strA.equals(strD));

        System.out.println(strA.intern()==strD.intern());
        System.out.println(strA.intern().equals(strD.intern()));


    }
}

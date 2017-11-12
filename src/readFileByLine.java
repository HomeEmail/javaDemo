/**
 * Created by ivan on 17/11/13.
 * 逐行读文件
 * 涉及文件读取的代码 方法声明里必须捕捉IO异常：throws IOException
 * 相对路径是当前项目根路径
 * 把 close() 方法放在了 finally 语句块 确保异常时可以关闭文件
 */
import java.util.*;
import java.io.*;

public class readFileByLine {
    
    private  static void readFile(File fin) throws IOException {
        FileInputStream fis=null;
        fis=new FileInputStream(fin);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = null;
        br=new BufferedReader(new InputStreamReader(fis,"UTF-8"));//UTF-8
        
        try{
            String line=null;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(br!=null){
                br.close();
            }
            
        }
        
        
    }
    private static void writeFile(File fin) throws IOException{
        FileOutputStream fos = null;
        fos=new FileOutputStream(fin);

        BufferedWriter bw = null;
        bw=new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        try{
            for (int i = 0; i < 10; i++) {
                bw.write("write something");
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            
            if(bw!=null){
                bw.close();
                System.out.println("write file ok!");
            }
            
        }
        

        
    }
    public static void main(String[] args) throws IOException {
        File dir=new File(".");
        System.out.println(dir.getCanonicalPath()+File.separator);
        File fin=new File(dir.getCanonicalPath()+File.separator+"README.RD");
        readFile(fin);
        writeFile(new File("out.log"));
    }
}

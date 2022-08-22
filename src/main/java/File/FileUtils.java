package File;

import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;

/**
 * @Author: wenzf
 * @Date 2021-8-23
 * @Description: FileUtil工具类的使用
 */
public class FileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
    private static final String WIN_NEW_LINE = "\r\n";     //windows


    /**
     * 获取reader对象，可以读文件。
     * @param filePath 读取的文件的路径及名称
     * @param encode 读取的文件的编码格式
     * @return reader对象
     */
    public static BufferedReader getReader(String filePath, String encode){
        BufferedReader reader = null;
        try {
            File filename = new File(filePath);
            if(!filename.exists()) {
                throw new FileNotFoundException(filePath+"file is not Found");
            }
            FileInputStream fileInputStream = new FileInputStream(filename);
            reader = new BufferedReader(new InputStreamReader(fileInputStream, encode));
        } catch(IOException e) {
            LOGGER.error("read file failure",e);
        }
        return reader;
    }

    /**
     * 获取reader对象，可以读文件。
     * @param filePath 读取的文件的路径及名称
     * @return reader对象
     */
    public static BufferedReader getReader(String filePath){
        return getReader(filePath,"utf-8");
    }


    /**
     * 获取得到写文件对象
     * @param writerFilePath 写出的文件的路径和保存的文件名
     * @param isAppend true:追加的方式保存，false：直接覆盖的方式保存
     * @return 写文件对象
     */
    public static BufferedWriter getWriter(String writerFilePath,Boolean isAppend){
        BufferedWriter writer = null;
        try {
            File writeFileName = new File(writerFilePath); // 相对路径，如果没有则要建立一个新的output.txt文件
            if(!writeFileName.exists()) {
                writeFileName.createNewFile(); // 创建新文件
            }
            //FileWriter fileWriter = new FileWriter(writeFileName);
            FileWriter fileWriter = new FileWriter(writeFileName,isAppend);     //true,代表着追加写入，不会讲之前已经录入的内容覆盖
            writer = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }

    /**
     * 获取得到写文件对象
     * @param writerFilePath 写出的文件的路径和保存的文件名
     * @return 写文件对象，默认是覆盖方式
     */
    public static BufferedWriter getWriter(String writerFilePath){
        return getWriter(writerFilePath,false);
    }


    /**
     * 写入文件,末尾自动添加\r\n
     * utf-8  追加
     * @param writerFilePath
     * @param context 要往文件写入的内容
     * @param isAppend 是否是将context内容追加到制定文件的末尾？true：追加。false：覆盖。默认是false。
     */
    public static void writeFile(String writerFilePath, String context,Boolean isAppend) {
        BufferedWriter writer = getWriter(writerFilePath,isAppend);
        StringBuffer buffer = new StringBuffer();
        buffer.append(context + WIN_NEW_LINE);
        try {
            writer.write(buffer.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件,末尾自动添加\r\n
     * utf-8  追加
     * @param writerFilePath
     * @param context 要往文件写入的内容
     */
    public static void writeFile(String writerFilePath, String context) {
        writeFile(writerFilePath,context,false);
    }


    /**
     * 加入编码
     * 整个文件以string放回，添加\r\n换行
     * @param filePath 读取的文件的路径及名称
     * @param encode 读取的文件的编码格式
     * @return 返回的是所有行的String类型的字符串
     */
    public static String readfileToString(String filePath,String encode) {
        StringBuffer sb=new StringBuffer();
        String line=null;
        BufferedReader reader = getReader(filePath,encode);
        try {
            while((line=reader.readLine())!=null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 整个文件以string放回，添加\r\n换行
     * @param filePath 读取的文件的路径及名称
     * @return 返回的是所有行的String类型的字符串
     */
    public static String readfileToString(String filePath) {
        return readfileToString(filePath,"utf-8");
    }



    /**
     * 按行读取文件，以list<String>的形式返回
     * @param filePath 读取文件的路劲及名称
     * @return 返回的是每行内容的list集合
     */
    public static List<String> readFileToList(String filePath,String encode) {
        List<String> lines = new ArrayList<String>();     //lines:文件所有行的数据
        String line = null;                               //line:一次读入一行的数据
        BufferedReader reader = getReader(filePath,encode);
        //line:一次读入一行的数据
        try {
            while((line = reader.readLine()) != null) {
                lines.add(line.toString());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * 按行读取文件，以list<String>的形式返回
     * @param filePath 读取文件的路劲及名称
     * @return 返回的是每行内容的list集合
     */
    public static List<String> readFileToList(String filePath) {
        return readFileToList(filePath,"utf-8");
    }


    /**
     * 创建目录
     * @param dirPath 所要创建的目录字符串
     */
    public static boolean mkDir(String dirPath) {
        File file = new File(dirPath);
        return file.mkdirs();
    }

    /**
     * 创建文件
     * @param filePath
     */
    public static boolean touch(String filePath) {
        File file = new File(filePath);
        boolean success = false;
        try {
            if (!file.exists()) {
                success = file.createNewFile();
            }
        }
        catch (Exception e) {
            LOGGER.error("新建文件操作出错",e);
        }
        return success;
    }

    /**
     * 递归删除文件或者目录
     * @param filePath
     */
    public static void deleteEveryThing(String filePath) {
        try{
            File file=new File(filePath);
            if(!file.exists()){
                return ;
            }
            if(file.isFile()){
                file.delete();
            }else{
                File[] files = file.listFiles();
                for(int i=0;i<files.length;i++){
                    String root=files[i].getAbsolutePath();//得到子文件或文件夹的绝对路径
                    deleteEveryThing(root);
                }
                file.delete();
            }
        } catch(Exception e) {
            LOGGER.error("删除文件失败",e);
        }
    }

    /**
     *
     * @param filePath
     * @return ture:文件存在。false：文件不存在。
     */
    public static boolean fileIsExists(String filePath){
        File file=new File(filePath);
        return file.exists();
    }

    /*
     * 得到一个文件夹下所有文件
     */
    public static List<String> getAllFileNameInFold(String fold_path) {
        List<String> file_paths = new ArrayList<String>();

        LinkedList<String> folderList = new LinkedList<String>();
        folderList.add(fold_path);
        while (folderList.size() > 0) {
            File file = new File(folderList.peekLast());
            folderList.removeLast();
            File[] files = file.listFiles();
            ArrayList<File> fileList = new ArrayList<File>();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    folderList.add(files[i].getPath());
                } else {
                    fileList.add(files[i]);
                }
            }
            for (File f : fileList) {
                file_paths.add(f.getAbsoluteFile().getPath());
            }
        }
        return file_paths;
    }

}


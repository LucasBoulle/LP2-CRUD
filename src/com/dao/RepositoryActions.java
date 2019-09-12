package com.dao;
import java.io.*;

public class RepositoryActions {

    public String readFile(String filename) throws IOException {
        File file = new File(filename);
        int len = (int) file.length();
        byte[] bytes = new byte[len];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            assert len == fis.read(bytes);
        } catch (IOException e) {
            close(fis);
            throw e;
        }
        return new String(bytes, "UTF-8");
    }

    public void writeFile(String filename, String text) throws IOException {
        try(FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("\r\n" + text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch(IOException ignored) {
        }
    }
}

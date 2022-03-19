package lesson5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        InputStream someInputStream = null;
//        int bytesCount = someInputStream.available(); // сколько байтов данных можно считать из потока
//        someInputStream.close(); // закрывает поток данных
//        int myByte = someInputStream.read(); // считывает один байт информации, если считывать нечего вернется -1 EOF
//
//        byte[] buffer = new byte[1024]; // буфер, в который кладем данные
//        someInputStream.read(buffer);
//
//        byte[] anotherBuffer = new byte[256];
//        int bufferOffset = 4; // куда в буфере будем класть данные
//        int dataLength = 200; // сколько мы хотим прочитать из источника
//        someInputStream.read(anotherBuffer, bufferOffset, dataLength);
//
//        // 123456789
//        // ^
//
//        int skipped = someInputStream.skip(3); // пропуск байтов в источнике, чтобы не считывать
//
//        // OutputStream
//
//        OutputStream someOutputStream = null;
//        someOutputStream.close(); //
//
//        int someByteInfo = 1;
//        someOutputStream.write(someByteInfo); // запись в ресурс
//
//        byte[] someData = {1,2,3,4,5,6,7,8,9};
//        someOutputStream.write(someData); //
//
//        int someDataOffset = 3;
//        int someDataLength = 2;
//        someOutputStream.write(someData, someDataOffset, someDataLength);
//
//        someOutputStream.flush();
//
        // FileInputStream, FileOutputStream
//
//        FileOutputStream fileOutputStream = null;
//        try {
//            FileOutputStream FileOutputStream = new FileOutputStream("hello.txt");
//
//            byte[] dataBytes = "HelloWorld!".getBytes(StandardCharsets.UTF_8);
//            fileOutputStream.write(dataBytes);
//            fileOutputStream.close();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException ex) {
//            }
//        }

//        try - with - recources

        try (FileOutputStream fileOutputStream = new FileOutputStream("bye.txt", true)) {
            byte[] dataBytes = "Bye-bye!".getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(dataBytes);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

//        FileInputStream
        try (FileInputStream fileInputStream = new FileInputStream("hello.txt")) {
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //        FileInputStream
        try (FileInputStream fileInputStream = new FileInputStream("hello.txt")) {
            ArrayList<Byte> newData = new ArrayList<>();

            final int EOF = -1;
            int temp = 0;

            while ((temp = fileInputStream.read()) != EOF) {
                newData.add((byte) temp);
            }

            byte[] bytes = convertToBytes(newData);
            System.out.println(new String(bytes));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static byte[] convertToBytes(ArrayList<Byte> list) {
        byte[] array = new byte[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}



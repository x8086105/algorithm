package com.example.socket.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过几种方式对比下文件拷贝的性能差异
 */
public class FileCopyTest {
    /**
     * 接口
     */
    interface FileCopy {
        /**
         * 文件从source拷贝成target
         *
         * @param source
         * @param target
         */
        void copy(File source, File target) throws IOException;
    }

    /**
     * 用来关闭流
     * @param closeable
     */
    private static void close(Closeable closeable){
        if(closeable != null){
            try {
                closeable.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileCopy noBufferStreamCopy = new FileCopy() {
            @Override
            public void copy(File source, File target) {
                FileInputStream fileInputStream = null;
                FileOutputStream fileOutputStream = null;
                try {
                    fileInputStream = new FileInputStream(source);
                    fileOutputStream = new FileOutputStream(target);
                    int result;
                    while ((result = fileInputStream.read()) != -1) {
                        fileOutputStream.write(result);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fileInputStream);
                    close(fileOutputStream);
                }
            }
        };
        FileCopy bufferStreamCopy = new FileCopy() {
            @Override
            public void copy(File source, File target) throws IOException {
                InputStream fin = null;
                OutputStream fout = null;
                try {
                    fin = new BufferedInputStream(new FileInputStream(source));
                    fout = new BufferedOutputStream(new FileOutputStream(target));
                    byte[] buffer = new byte[1024];
                    int result;
                    while ((result = fin.read(buffer)) != -1){
                        fout.write(buffer,0,result);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    close(fin);
                    close(fout);
                }
            }
        };
        FileCopy nioBufferCopy = new FileCopy() {
            @Override
            public void copy(File source, File target) throws IOException {
                FileChannel inputChannel = null;
                FileChannel outputChannel = null;
                try {
                    inputChannel = new FileInputStream(source).getChannel();
                    outputChannel = new FileOutputStream(target).getChannel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int i;
                    while ((i = inputChannel.read(byteBuffer)) != -1){
                        byteBuffer.flip();
                        while(byteBuffer.hasRemaining()){
                            outputChannel.write(byteBuffer);
                        }
                        byteBuffer.clear();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    close(inputChannel);
                    close(outputChannel);
                }
            }
        };
        FileCopy nioTransferCopy = new FileCopy() {
            @Override
            public void copy(File source, File target) throws IOException {
                FileChannel fin = null;
                FileChannel fout = null;
                try {
                    fin = new FileInputStream(source).getChannel();
                    fout = new FileOutputStream(target).getChannel();
                    long transferred = 0L;
                    long size = fin.size();
                    while (transferred != size){
                        transferred += fin.transferTo(0,size,fout);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    close(fin);
                    close(fout);
                }
            }
        };
    }
}

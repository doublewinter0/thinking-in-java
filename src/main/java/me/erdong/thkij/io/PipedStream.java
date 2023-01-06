package me.erdong.thkij.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {
    public static void main(String[] args) throws IOException, InterruptedException {
        final PipedInputStream pipedInputStream = new PipedInputStream();
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();

        /*Connect pipe*/
        pipedInputStream.connect(pipedOutputStream);

        /*Thread for writing data to pipe*/
        Runnable writeSide = () -> {
            for (int i = 65; i < 71; i++) {
                try {
                    pipedOutputStream.write(i);
                    Thread.sleep(500);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread pipeWriter = new Thread(writeSide);

        /*Thread for reading data from pipe*/
        Thread pipeReader = new Thread(() -> {
            try {
                int in;
                while ((in = pipedInputStream.read()) > 0) {
                    System.out.print(in);
                    System.out.println();
                    System.out.print((char) in);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        /*Start thread*/
        pipeWriter.start();
        pipeReader.start();

        /*Join Thread*/
        pipeWriter.join();
        pipeReader.join();

        /*Close stream*/
        pipedOutputStream.close();
        pipedInputStream.close();
    }
}

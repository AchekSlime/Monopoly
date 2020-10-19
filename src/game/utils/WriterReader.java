package game.utils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class WriterReader {
    private Scanner scanner;
    private PrintStream printer;

    public WriterReader(InputStream input, PrintStream output) {
        scanner = new Scanner(input);
        printer = output;
    }

    public void write(String message) {
        printer.print(message);
    }

    public void writeln(String message) {
        printer.println(message);
    }

    public String read(){
        return scanner.nextLine();
    }
//    public static class Factory {
//        public static WriterReader createConsoleScanner(){
//            return new WriterReader(System.in, System.out);
//        }
//    }
}

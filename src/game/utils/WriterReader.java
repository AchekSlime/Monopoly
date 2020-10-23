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

    public void write(double message) {
        printer.format("%.3f", message);
    }

    public void writeln(String message) {
        printer.println(message);
    }

    public void writeln(double message) {
        printer.format("%.3f", message);
        printer.println("");
    }

    public String read(){
        return scanner.nextLine();
    }
}

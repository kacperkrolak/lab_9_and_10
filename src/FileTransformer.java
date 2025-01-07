import java.io.*;

public class FileTransformer {
    public static void transformFile(String inputFileName, String outputFileName) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line.replace(" ", "-"));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred - " + e.getMessage());
        }
    }
}

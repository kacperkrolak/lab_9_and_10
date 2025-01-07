import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Scanner;

public class BankFinder {
    private static final String fileUrl = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

    // Pobieranie 3 pierwszych cyfr numeru konta.
    private static String readUserInput() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj trzy pierwsze cyfry numeru konta: ");
        String userInput = scanner.nextLine();

        if (userInput.length() != 3 || !userInput.matches("\\d{3}")) {
            throw new Exception("Podano nieprawidłowe dane. Wprowadź dokładnie 3 cyfry.");
        }

        return userInput;
    }

    // List of columns if found, else empty.
    private static String[] getBankInfo(String accountPrefix) {
        try (
                InputStreamReader streamReader = new InputStreamReader(new URI(fileUrl).toURL().openStream());
                BufferedReader reader = new BufferedReader(streamReader);
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split("\t");

                if (columns.length < 2) {
                    continue;
                }

                String bankAccountsPrefix = columns[0].trim();

                if (bankAccountsPrefix.equals(accountPrefix)) {
                    return columns;
                }
            }
        } catch (Exception e) {
            System.out.println("Wystąpił błąd podczas przetwarzania danych: " + e.getMessage());
        }

        return new String[]{};
    }

    public static void findBankInfo() {
        String accountPrefix;
        try {
            accountPrefix = readUserInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] bankInfo = getBankInfo(accountPrefix);
        if (bankInfo.length == 0) {
            System.out.println("Nie znaleziono banku, dla Twojego ciągu znaków.");
            return;
        }

        System.out.println("Nazwa banku: " + bankInfo[1]);
    }
}

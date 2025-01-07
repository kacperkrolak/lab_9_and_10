public class Main {
    public static void main(String[] args) {
        System.out.println("LAB 9 ZAD 1");
        ExceptionGenerator generator = new ExceptionGenerator();

        try {
            generator.generateNullPointerException(); // Wywołanie metody generującej wyjątek
        } catch (NullPointerException e) {
            System.out.println("Wystąpił wyjątek NullPointerException!"); // Komunikat dla użytkownika
            e.printStackTrace(); // Wypisanie stosu wywołań
            System.out.println(e.toString()); // Wypisanie obiektu reprezentującego wyjątek w formie tekstowej
        }

        System.out.println("\nLAB 9 ZAD 3");
        Account account = new Account("John Doe", 1000, "123");
        System.out.printf("Balance before operation: %d\n", account.getBalance());

        try {
            // Próba pobrania większej ilości środków niż to możliwe.
            account.Withdraw(2000);
        } catch (NotEnoughFundsException e) {
            // Obsługa błędu, oznaczającego niewystarczają ilość środków.
            System.out.printf("Error: %s\n", e.getMessage());
        } catch (Exception e) {
            // Obsługa wszystkich innych błędów.
            System.out.printf("Unexpected error: %s\n", e.getMessage());
        } finally {
            // Blok, który wykona się zawsze, niezależnie od tego czy wystąpił błąd.
            System.out.printf("Current balance: %d\n", account.getBalance());
        }

        System.out.println("\nLAB 10 ZAD 3");
        String inputFile = "input/lorem-ipsum.txt";
        String outputFile = "output/lorem-ipsum.txt";

        // Kopiowanie pliku, ale z zamianą spacji na myślniki.
        FileTransformer.transformFile(inputFile, outputFile);
        System.out.println("Zapisano wynik do pliku: " + outputFile);

        System.out.println("\nLAB 10 ZAD 5");
        BankFinder.findBankInfo();
    }
}

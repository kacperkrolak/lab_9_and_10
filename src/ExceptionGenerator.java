public class ExceptionGenerator
{
    public void generateNullPointerException() {
        String str = null; // Tworzymy zmienną o wartości null
        int length = str.length(); // Próba wywołania metody na null generuje wyjątek NullPointerException
    }
}

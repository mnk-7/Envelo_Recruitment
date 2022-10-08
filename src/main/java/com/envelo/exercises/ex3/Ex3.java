package com.envelo.exercises.ex3;

import com.envelo.exercises.ex3.connectionApi.QuotesApi;
import com.envelo.exercises.ex3.constants.Format;
import com.envelo.exercises.ex3.constants.Message;
import com.envelo.exercises.ex3.constants.Navigation;
import com.envelo.exercises.ex3.constants.Source;
import com.envelo.exercises.ex3.entities.Quote;
import com.envelo.exercises.ex3.fileService.QuotesFileService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*3. Napisz program, który wykorzysta API Kanye Rest https://kanye.rest/ by każdorazowo zaproponować nową perełkę
mądrości od Kanye Westa. Program powinien być obsługiwany z poziomu konsoli i obsługiwać komendę "next" by wywołać
następny cytat. Program nie potrzebuje oprawy graficznej. Zwróć uwagę na poprawną architekturę aplikacji oraz na
czystość kodu. Dla chętnych, za dodatkowe punkty: dodaj zapisywanie cytatów w pamięci, by upewnić się, że każdy
kolejny cytat jest nowy. */



//KOMENTARZ DO ROZWIĄZANIA:
//w ramach opcjonalnej części zadania dodałam zapisywanie wygenerowanych cytatów do pliku;
//zawartość pliku można wyświetlić za pomocą komendy "list", a usunąć za pomocą komendy "clear"

public class Ex3 {

    public static void main(String[] args) {
        displayWelcomeMessage();
        String input;
        do {
            displayMenu();
            input = gatherUserInput();
            navigate(input);
        } while (!shouldAppBeClosed(input));
    }


    private static void displayWelcomeMessage() {
        System.out.println(Format.FONT_PURPLE + Message.WELCOME_MSG + Format.FONT_RESET);
    }

    private static void displayMenu() {
        System.out.println(Message.NAVIGATION_HEADER + Message.NAVIGATION_MENU);
    }

    private static String gatherUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        while (!isInputValid(input)) {
            displayMenuAndInformAboutWrongInput();
            scanner = new Scanner(System.in);
            input = scanner.next();
        }
        return input.toUpperCase();
    }

    private static boolean isInputValid(String input) {
        return Arrays.stream(Navigation.values())
                .map(Enum::toString)
                .anyMatch(e -> e.equalsIgnoreCase(input));
    }

    private static void displayMenuAndInformAboutWrongInput() {
        System.out.println(Message.WRONG_INPUT_MSG + Message.NAVIGATION_MENU);
    }

    private static void navigate(String input) {
        switch (Navigation.valueOf(input)) {
            case NEXT:
                generateQuote();
                break;
            case LIST:
                displayStoredQuotes();
                break;
            case CLEAR:
                deleteStoredQuotes();
                break;
            case END:
                displayFarewellMessage();
                break;
        }
    }

    private static void generateQuote() {
        Quote quote;
        do {
            quote = QuotesApi.callApi();
        } while (quoteHasBeenAlreadyGenerated(quote));

        QuotesFileService.saveQuote(Source.QUOTE_FILE_PATH, quote);
        displayGeneratedQuote(quote);
    }

    private static boolean quoteHasBeenAlreadyGenerated(Quote quote) {
        return QuotesFileService.findQuote(Source.QUOTE_FILE_PATH, quote).isPresent();
    }

    private static void displayGeneratedQuote(Quote quote) {
        System.out.println(Format.FONT_BLUE + quote.getQuote() + Format.FONT_RESET);
    }

    private static void displayStoredQuotes() {
        List<Quote> quotes = QuotesFileService.getQuotes(Source.QUOTE_FILE_PATH);
        if (quotes.size() == 0) {
            System.out.println(Format.FONT_CYAN + Message.QUOTES_LIST_EMPTY_MSG + Format.FONT_RESET);
        } else {
            System.out.println(Format.FONT_CYAN + Message.QUOTES_LIST_HEADER + Format.FONT_RESET);
            for (Quote quote : quotes) {
                System.out.println(Format.FONT_BLUE + quote.getQuote() + Format.FONT_RESET);
            }
        }
    }

    private static void deleteStoredQuotes() {
        QuotesFileService.deleteQuotes(Source.QUOTE_FILE_PATH);
        displayInfoAboutRemovingQuotes();
    }

    private static void displayInfoAboutRemovingQuotes() {
        System.out.println(Format.FONT_CYAN + Message.QUOTES_DELETED_MSG + Format.FONT_RESET);
    }

    private static void displayFarewellMessage() {
        System.out.println(Format.FONT_PURPLE + Message.FAREWELL_MSG + Format.FONT_RESET);
    }

    private static boolean shouldAppBeClosed(String input) {
        return input.equals(Navigation.END.toString());
    }

}

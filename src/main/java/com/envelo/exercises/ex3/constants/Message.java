package com.envelo.exercises.ex3.constants;

public class Message {

    public final static String WELCOME_MSG = "\nWelcome to 'Wisdom of Kanye West' app!";

    public final static String FAREWELL_MSG = "\nWe hope Kanye West's wisdom inspired you." +
            "\nThank you for using the app.";

    public static final String WRONG_INPUT_MSG = "\nWrong input. Please enter one of the valid commends:";

    public final static String NAVIGATION_HEADER = "\nNavigation:";

    public final static String NAVIGATION_MENU = "\n\t- to generate a new random quote enter " + Navigation.NEXT +
            "\n\t- to see the list of already generated quotes enter " + Navigation.LIST +
            "\n\t- to clear the list of already generated quotes enter " + Navigation.CLEAR +
            "\n\t- to close the app enter " + Navigation.END;

    public static final String QUOTES_DELETED_MSG = "All stored quotes have been removed";

    public static final String QUOTES_LIST_EMPTY_MSG = "The quotes list is empty";

    public static final String QUOTES_LIST_HEADER = "List of stored quotes:";

}

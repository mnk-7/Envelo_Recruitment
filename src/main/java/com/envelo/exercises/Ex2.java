package com.envelo.exercises;

public class Ex2 {

    /* 2. Mając tablicę int[] numbers, wypełnioną liczbami całkowitymi i posortowaną malejąco
    ( numbers[i] > numbers[i+1] ), sprawdź czy występuje w niej liczba int x. Metoda powinna
    zwracać wartość TRUE, jeśli dana liczba występuje oraz FALSE w przeciwnym wypadku.
    W rozwiązaniu zależy nam na jak najmniejszej złożoności obliczeniowej (priorytet) oraz
    pamięciowej. Podaj szacowaną złożoność obliczeniową oraz pamięciową. Poniżej sygnatura
    metody do napisania. private boolean search(int[] numbers, int x){} */



    //KOMENTARZ DO ROZWIĄZANIA
    //aby możliwe było przetestowanie metody z wykorzystaniem testów jednostkowych w miejsce prywatnej metody utworzyłam
    //statyczną metodę publiczną; testy można znaleźć pod ścieżką - src/test/java/com/envelo/exercises/Ex2Test.java

    //ZŁOŻONOŚĆ OBLICZENIOWA ALGORYTMU: logarytmiczna, O(log n)
    //ZŁOŻONOŚĆ PAMIĘCIOWA ALGORYTMU: stała, O(1)

    public static boolean search(int[] numbers, int x){
        int startIndex = 0;
        int endIndex = numbers.length - 1;

        int middleIndex;
        int middleValue;

        do {
            middleIndex = (startIndex + endIndex) / 2;
            middleValue = numbers[middleIndex];

            if (x < middleValue) {
                startIndex = middleIndex + 1;
            } else if (x > middleValue) {
                endIndex = middleIndex - 1;
            } else {
                return true;
            }

        } while (startIndex <= endIndex);

        return false;
    }

}

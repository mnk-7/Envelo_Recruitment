package com.envelo.exercises;

public class Ex1 {

    /* 1.A.
    W jakim celu używa się klas abstrakcyjnych, a w jakim interfejsów?
        Klasy abstrakcyjne tworzy się, aby wydzielić części wspólne - pola i metody - logicznie powiązanych
        ze sobą klas do wyższej, nadrzędnej abstrakcji. Interfejsów używa się, gdy klasy wykazują podobne
        zachowanie jednak nie układają się w hierarchię.

        Np. klasy: MathTeacher, ChemistryTeacher, EnglishTeacher mogłyby dziedziczyć po klasie abstrakcyjnej Teacher;
        klasy: TaxiDriver, BusDriver, TrainDriver - po klasie klasie abstrakcyjnej Driver, a klasy: Driver i Teacher
        - po klasie abstrakcyjnej Profession; klasa Profession mogłaby implementować interfejs Workable z metodą work,
        ale interfejs ten mógłby również być implementowany przez klasę Machine; Machine i Profession nie są częścią
        wspólnej hierarchii, nie dałoby się sprowadzić ich do wspólnej klasy abstrakcyjnej.
    */


    /* 1.B.
    Czym różni się tablica od listy liniowej?
        Przy inicjalizacji tablicy należy wskazać, ile elementów będzie ona przechowywać - raz zdefiniowanej wielkości
        tablicy nie można już później zmienić. Rozszerzenie bądź zmniejszenie rozmiaru tablicy jest możliwe tylko
        poprzez utworzenie nowej tablicy i skopiowanie do niej danych ze starej tablicy. Dzięki temu, że już przy
        inicjalizacji tablicy wiadomo, ile miejsca w pamięci będzie ona wymagać, elementy tablicy ulokowane są w jednym
        miejscu w pamięci, co przekłada się na szybszy dostęp do danych podczas przetwarzania tablicy. Do danego
        elementu tablicy można odnieść się za pomocą jego indeksu.

        W przeciwieństwie do tablicy podczas inicjalizacji listy liniowej nie wskazuje się jej rozmiaru, ponadto
        można rozszerzać ją o dowolną liczbę elementów. W przypadku list jednokierunkowych każdy element zawiera
        odniesienie do kolejnego elementu, natomiast w przypadku list dwukierunkowych - zarówno do kolejnego jak
        i poprzedniego. Listy liniowe są więc wygodnym rozwiązaniem, jeśli nowy element należy wstawić w środku
        listy. Elementy listy liniowej mogą być ulokowane w różnych miejscach w pamięci, dlatego dostęp do danych
        i ich przetworzenie zawiera więcej czasu niż w przypadku tablic.
    */

}

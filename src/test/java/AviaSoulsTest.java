import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket_1 = new Ticket("Уфа", "Нижний Новгород", 8450, 10, 12);
    Ticket ticket_2 = new Ticket("Уфа", "Казань", 4700, 10, 22);
    Ticket ticket_3 = new Ticket("Уфа", "Санкт-Петербург", 4700, 10, 16);
    Ticket ticket_4 = new Ticket("Уфа", "Москва", 16000, 10, 18);
    Ticket ticket_5 = new Ticket("Уфа", "Ростов-на-Дону", 5500, 10, 20);
    Ticket ticket_6 = new Ticket("Уфа", "Сочи", 9600, 10, 14);

    @Test
    public void ComparedToAnotherTicket() {

        AviaSouls souls = new AviaSouls();
        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);
        souls.add(ticket_6);

        Ticket[] tickets = {ticket_1, ticket_3};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket_3, ticket_1};

        Assertions.assertArrayEquals(expected, tickets);
    }
    @Test
    public void CompareDepartureTime() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);
        souls.add(ticket_6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket_1, ticket_6};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket_1, ticket_6};


        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void SortingAndSearchingByTicketPrice() {
        AviaSouls souls = new AviaSouls();
        Ticket ticket_1 = new Ticket("Уфа", "Казань", 8450, 10, 12);
        Ticket ticket_2 = new Ticket("Уфа", "Казань", 4700, 10, 22);
        Ticket ticket_3 = new Ticket("Уфа", "Казань", 4700, 10, 16);
        Ticket ticket_4 = new Ticket("Уфа", "Казань", 16000, 10, 18);
        Ticket ticket_5 = new Ticket("Уфа", "Казань", 5500, 10, 20);
        Ticket ticket_6 = new Ticket("Уфа", "Казань", 9600, 10, 14);
        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);
        souls.add(ticket_6);

        Ticket[] tickets = souls.search("Уфа","Казань");
        Ticket[] expected = {ticket_2, ticket_3, ticket_5, ticket_1, ticket_6, ticket_4};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void SortingAndSearchingByFlightTime() {
        AviaSouls souls = new AviaSouls();
        Ticket ticket_1 = new Ticket("Уфа", "Казань", 8450, 10, 12);
        Ticket ticket_2 = new Ticket("Уфа", "Казань", 4700, 10, 22);
        Ticket ticket_3 = new Ticket("Уфа", "Казань", 4700, 10, 16);
        Ticket ticket_4 = new Ticket("Уфа", "Казань", 16000, 10, 18);
        Ticket ticket_5 = new Ticket("Уфа", "Казань", 5500, 10, 20);
        Ticket ticket_6 = new Ticket("Уфа", "Казань", 9600, 10, 14);
        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);
        souls.add(ticket_6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = souls.searchAndSortBy("Уфа","Казань", timeComparator);
        Ticket[] expected = {ticket_1, ticket_6, ticket_3, ticket_4, ticket_5, ticket_2};

        Assertions.assertArrayEquals(expected, tickets);
    }
}
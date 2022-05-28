package my.learning.javarush.st3.annotations.implAnnot;

/*
Тикеты
*/

import my.learning.javarush.st3.annotations.Ticket;

@Ticket(
        priority = Priority.HIGH,
        createdBy = "Noodles",
        tags = {"bug", "fix asap"}
)
public class TicketTask {
    public static void main(String[] args) {

    }
}

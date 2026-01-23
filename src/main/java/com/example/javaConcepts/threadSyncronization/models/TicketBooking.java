package com.example.javaConcepts.threadSyncronization.models;

public class TicketBooking {
    private int availableTickets = 10;

    public synchronized void bookTicket(int numberOfTickets) { // metodo sincronizado para evitar condicoes de corrida, ou seja, varios threads acessando o mesmo recurso ao mesmo tempo
        // neste caso, cada thread tera que esperar a outra terminar para acessar o metodo
        if (numberOfTickets <= availableTickets){
            
            availableTickets -= numberOfTickets;
            System.out.println(
                "Booked " + numberOfTickets + " tickets, "
                + "Remaining tickets: " + availableTickets);
        }
        else{
            System.out.println(
                "Not enough tickets available to book "
                + numberOfTickets);
        }
    }

    public int getAvailableTickets(){
        return availableTickets;
    }
}

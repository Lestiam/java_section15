package section176.solucaoBoa.application;

import section176.solucaoBoa.model.entities.Reservation;
import section176.solucaoBoa.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program { //meu programa agora tem esse formato, é uma execução normal considerando que tudo funcionou
    //o programa fica muito mais limpo, sem aquela quantidade de if e else
    public static void main(String[] args) {//eu tirei aquele trows ParserException pois agora a excessão será tratada e não propagada

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());//entro com a data como um texto e o sdf converte isso para um Date para mim
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());//entro com a data como um texto e o sdf converte isso para um Date para mim
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut); //este método agora não vai retornar uma string, ela vai lançar uma excessão caso ela ocorra
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        catch (DomainException e) { //esté catch pega aquele lançamento (throw) do método updateDates
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) { //qualquer outra excessão inesperada, o RuntimeException irá pegar (tipo genérico), a InputMismatchException é uma RuntimeException
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}


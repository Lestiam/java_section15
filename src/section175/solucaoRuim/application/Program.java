package section175.solucaoRuim.application;

import section175.solucaoRuim.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {//é a solução ruim pois enviar uma String derro para o usuário é um método das linguages antigas como o C
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());//entro com a data como um texto e o sdf converte isso para um Date para mim
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {//a Data tem um método chamado after que testa se uma data vem depois da outra, nesse caso, o checkout NÃO pode vir antes do checkIn
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());//entro com a data como um texto e o sdf converte isso para um Date para mim
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut); //agora tem que colocar esse metodo dentro de uma string pois agora ele retorna uma string e essa string que vai me devolver se teve um erro ou não
            if (error != null) { //é diferente de nulo pois o método updateDates retorna null se der tudo certo
                System.out.println("Error in reservation: " + error);
            } else { //se cair aqui é pq deu tudo certo e eu mostro os dados atualizados da reserva
                System.out.println("Reservation: " + reservation);
            }
        }
        sc.close();
    }
}


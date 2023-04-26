package section178.exercicio.correcaoProf.application;

import section178.exercicio.correcaoProf.model.entities.Account;
import section178.exercicio.correcaoProf.model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);
            //account.deposit(balance);
            System.out.print("Enter amount for withdraw: ");
            double amount =  sc.nextDouble();
        try {
            account.withdraw(amount);
            System.out.printf("New balance: %.2f%n" , account.getBalance());
        }
        catch (BusinessException e) { //quando eu capturar a BusinessException que eu apelidei de "e", dentro desse objeto e vai estar aquela mensagem
            System.out.println("Withdraw error: " + e.getMessage()); //aqui eu pego a mensagem e mostro ela
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }


        sc.close();
    }
}

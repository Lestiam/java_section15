package section172.abreArquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        File file = new File("D:\\teste\\in.txt");//Objeto do tipo arquivo, para abrir o arquivo
        Scanner sc = null;
        try {
            sc = new Scanner(file); //o scanner também serve para abrir arquivos, aqui, tento instanciar o scanner no arquivo, caso o arquivo exista
            while (sc.hasNextLine()) { //verifica se tem uma próxima linha
                System.out.println(sc.nextLine()); //imprime a linha e passa para a próxima linha
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());//se não encontrar o arquivo vai lançar essa excessão padrão de quando não localiza o arquivo
        }
        finally {//o finally sempre vai ser executado independemente se der certo ou não, o que está no bloco try
            if (sc != null) {
                sc.close();//caso ele localize e abra o arquivo, aqui eu encerro o scanner
            }
            System.out.println("Finally block executed!");
        }
    }
}

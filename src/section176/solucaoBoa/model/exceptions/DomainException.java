package section176.solucaoBoa.model.exceptions;
//essa é uma excessão personalizada
public class DomainException extends RuntimeException {//o RuntimeException é um tipo de excessão que o compilador não me obriga a tratar e o Exception ele obriga a tratar
    private static final long serialVersionUID = 1l;//é a versão da excessão

    public DomainException(String msg) {//construtor que receve um string como argumento
        super(msg);//repasso essa mensagem para o construtor da superclasse, no caso, a classe Exception
        //é para permitir que eu possa instanciar minha excessão personalizada passando uma excessão para ela
        //essa mensagem vai ficar armazenada dentro da minha excessão
    }
}

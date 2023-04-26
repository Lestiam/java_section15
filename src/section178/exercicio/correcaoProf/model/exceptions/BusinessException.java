package section178.exercicio.correcaoProf.model.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String msg) {
        super(msg); //o String foi armaenado aqui
    }
}

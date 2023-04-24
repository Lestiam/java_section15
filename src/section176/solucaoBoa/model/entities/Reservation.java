package section176.solucaoBoa.model.entities;

import section176.solucaoBoa.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //está como static para não seja instanciado um novo simpledateformat para cada objeto reservation que minha aplicação tiver, eu preciso de apenas um

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException { //como eu mudei a classe excessão para extender de RunTimeException eu nem precisaria mais desse throw
        if (!checkOut.after(checkIn)) { //programação defensiva, trata a excessão no inicio do método
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() { //é do tipo long pois vamos calcular diferença entre datas e essa diferença retorna um valor do tipo long
        long diff = checkOut.getTime() - checkIn.getTime(); //eu pego a diferença entre as datas em milisegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte o valor diff que estava em milisegundos para dias
    }


    public void updateDates(Date checkIn, Date checkOut) throws DomainException{

        Date now = new Date();//cria uma data com o horario de agora
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for update must be future dates "); //agora meu método lança uma excessão caso esse if seja verdadeiro, e pega da minha excessão personalizada
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}

package section175.solucaoRuim.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //está como static para não seja instanciado um novo simpledateformat para cada objeto reservation que minha aplicação tiver, eu preciso de apenas um

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte o valor diffque estava em milisegundos para dias
    }


    public String updateDates(Date checkIn, Date checkOut) {//agora o método de update retorna uma String, e as verificações saõ feitas aqui
        //se retornar alguma string que não seja nulo, é pq deu erro, se retornar nulo é pq não deu erro

        Date now = new Date();//cria uma data com o horario de agora
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Reservation dates for update must be future dates ";
        }
        if (!checkOut.after(checkIn)) {
            return "Error in reservation: Check-out date must be after check-in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null; //para indicar que não teve nenhum erro, eu vou retornar nulo!
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

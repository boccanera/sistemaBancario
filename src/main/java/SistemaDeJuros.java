import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SistemaDeJuros {



    public Date dataAtual() {
        long dataAtual = new Date().getTime(); //milisegundos de um dia
        Date dataAtual1 = new Date(dataAtual);
        return dataAtual1;
    }

    public static void dataDoJuros() {
        long umDiaEmMilisegundos = new Date().getTime() + 86400000; //milisegundos de um dia
        Date tempoDoJuros = new Date(umDiaEmMilisegundos);
        System.out.println(tempoDoJuros);
    }

    public void calcularJuros() {
    }

    public void calcularEmprestimo() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        String inputString1 = "23 01 1997";
        String inputString2 = "27 04 1997";
        double juros = 0.1;


//        LocalDateTime data1 = LocalDateTime.parse(entrada1, dtf);
//        LocalDateTime data2 = LocalDateTime.parse(entrada2, dtf);
//        long quantidadeDeDiasDoEmprestimo = Duration.between(data1, data2).toDays();
//        System.out.println("O juros do emprestimo é de: " + quantidadeDeDiasDoEmprestimo * juros);

        //long dias1 = ChronoUnit.DAYS.between(date1, date2);
    }
}





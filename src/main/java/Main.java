import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
        Banco banco = new Banco();
        Imprimir imprimir = new Imprimir();
        boolean loop = true;
        while (loop) {
            imprimir.menu();
            int choice = Integer.parseInt(input.next());
            switch (choice) {
                case 1:
                    banco.registrarConta();
                    break;
                case 2:
                    banco.fazerLogin();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }




        Date date = new Date();
        long milisegundos = date.getTime();
        System.out.println(milisegundos);
    }
}

//TESTANDO>>>>>>>>>
//        SimpleDateFormat formatoDeData = new SimpleDateFormat("dd-MM-yyyy");
//        Date data = null;
//        boolean loop = true;
//        do {
//            System.out.println("Qual data voce vai realizar o pagamento");
//            String date = scanner.next();
//            loop=false;
//            try {
//                data = formatoDeData.parse(date);
//            } catch (ParseException e) {
//                System.out.println("Eita, o formato da data esta errado, tenta de novo.");
//                loop=true;
//            }
//        } while(loop);
//            System.out.println(data);
//
//            date
//        LocalDateTime data1 = LocalDateTime.parse(entrada1, dtf);
//        LocalDateTime data2 = LocalDateTime.parse(entrada2, dtf);
//        long quantidadeDeDiasDoEmprestimo = Duration.between(data1, data2).toDays();
//        System.out.println("O juros do emprestimo é de: " + quantidadeDeDiasDoEmprestimo * juros);
//
//        long dias1 = ChronoUnit.DAYS.between(date1, date2);
//
//
//
//    }
//}



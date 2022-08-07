import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TiposDeConta extends Conta {

    public TiposDeConta(String nomeCompleto, String email, Integer senha, Date dataDeCriacao) {
        super(nomeCompleto, email, senha, dataDeCriacao);
    }


    public class ContaCorrente{
        public ContaCorrente() {

        }
    }

}

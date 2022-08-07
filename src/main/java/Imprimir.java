public class Imprimir implements IImprimir{


    @Override
    public void menu() {
        System.out.println("### Bem-vindo ao Santander Boot Camp Bank ###: " + "\n" +
                "\r" + "Escolha uma das opcoes abaixo:" + "\n" +
                "\r" + "1.Register" + "\n" +
                "\r" + "2.Log in" + "\n" +
                "\r" + "3.Exit");
    }

    @Override
    public void menuDaConta(){
        System.out.println("== Ola, o que deseja? ==" + "\n" +
                "\r" + "1.Informacoes" + "\n" +
                "\r" + "2.Depositar" + "\n" +
                "\r" + "3.Sacar" + "\n" +
                "\r" + "4.Transferir" + "\n" +
                "\r" + "5.Sair");
    }

}

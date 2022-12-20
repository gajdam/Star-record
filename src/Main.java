import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) 
    {
        System.out.println("Hello world!");
        Gwiazda g1 = new Gwiazda("AA3VDF2");
        Gwiazda g2=new Gwiazda("AB3CDF3");
        Gwiazda g3=new Gwiazda("D1B3DF3");
        Gwiazda g4=new Gwiazda("51BEDF3");
        ArrayList<Gwiazda> listaGwiazd=new ArrayList<Gwiazda>();
        g4.setNazwa("61BEDF3");
        listaGwiazd.add(g1);
        listaGwiazd.add(g2);
        listaGwiazd.add(g3);
        listaGwiazd.add(g4);

        for (int i = 0; i< listaGwiazd.toArray().length; i++) {
            listaGwiazd.get(i).Poka();
            System.out.println();
        }
        //test
    }
}

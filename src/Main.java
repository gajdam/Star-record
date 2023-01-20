import java.io.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


//TODO
//metoda wyświetlająca zapytania    ???
//wyszukiwanie gwiazdozbioru po nazwie  KC
//wyszukiwanie gwiazd po odległości parseków [przelicz z lat świetlnych na parseki]  KC
//wyszukiwanie gwiazd mieszczących się w zadanym przedziale temperaturowym  KC


//TODO ?????
//lista istniejących gwiazdozbiorów
//lista istniejących gwiazd (nazw)
//powyższe listy zapisywać do pliku txt
public class Main
{
    public static List<Gwiazdozbior> listaOdczyt = Odczyt();
    public static List<String> gwiazdozbioryNazwy = new ArrayList<>();
    public static void Zapis(List<Gwiazdozbior> gz1) throws IOException {
        FileOutputStream fos = new FileOutputStream("baza.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(gz1);
        oos.close();
        fos.close();
    }
    public static List<Gwiazdozbior> Odczyt() {
        List<Gwiazdozbior> pomoc = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("baza.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            ArrayList<Gwiazdozbior> tempList = (ArrayList<Gwiazdozbior>)ois.readObject();
            for(Gwiazdozbior g: tempList) {
                pomoc.add(g);
//                System.out.println(g.gwiazdozbior);
            }
            return pomoc;
        } catch (IOException e) {
            if (e instanceof java.io.EOFException) {
                System.out.println("Koniec pliku");
            } else {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void WyszukajSupernove() {                //Maciej Gajda
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                if (gwiazda.getMasa() > 1.44) {
                    gwiazda.Poka();
                    System.out.println();
                }
            }
        }
    }

    public static void WyszukajPolkule(String zapytanie) {      //Maciej Gajda
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                if (Objects.equals(gwiazda.getPolkula(), zapytanie)) {
                    gwiazda.Poka();
                    System.out.println();
                }
            }
        }
    }

    public static void WyszukajWielkoscGwiazdowa(double start, double end) {   //Maciej Gajda
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                if (gwiazda.getAbsolutnaWielkoscGwiazdy() >= start && gwiazda.getAbsolutnaWielkoscGwiazdy() <= end) {
                    gwiazda.Poka();
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        //wyświetlanie wszystkich gwiazd
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            System.out.println(gwiazdozbior.nazwa);
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                gwiazda.Poka();
                System.out.println();
            }
        }
        System.out.println("=============================");
        for (int i = 0; i < gwiazdozbioryNazwy.size(); i++) {
            System.out.println(gwiazdozbioryNazwy.get(i));
        }
//        WyszukajSupernove();
//        WyszukajPolkule("PN");
//        WyszukajWielkoscGwiazdowa(8.50,10);


//            System.out.println("Dodawanie gwiazdy");
//            String nazwa = scan.nextLine();
//            String deklinacja = scan.nextLine();
//            String rekta = scan.nextLine();
//            double obsWiel = scan.nextDouble();
//            double lata = scan.nextDouble();
//            String gwiazdozbior = scan.nextLine();
//            double masa = scan.nextDouble();
//            String temperatura = scan.nextLine();
//            Gwiazda gw = new Gwiazda(nazwa, deklinacja, rekta, obsWiel, lata, gwiazdozbior, masa, temperatura);
//            wolarz.DodajGwiazde(gw);
    }

}

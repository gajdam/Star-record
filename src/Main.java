import java.io.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


//TODO
//ściąganie pliku do listy po uruchomieniu MG
//metoda wyświetlająca zapytania    ???
//wyszukiwanie gwiazdozbioru po nazwie  KC
//wyszukiwanie gwiazd po odległości parseków [przelicz z lat świetlnych na parseki]  KC
//wyszukiwanie gwiazd mieszczących się w zadanym przedziale temperaturowym  KC
//wyszukiwanie gwiazd o wielkości gwiazdowej w zadanym przedziale  MG
//wyszukiwanie gwaizd po pólkuli     MG
//wyszukiwanie supernowych    MG


//TODO ?????
//lista istniejących gwiazdozbiorów
//lista istniejących gwiazd (nazw)
//powyższe listy zapisywać do pliku txt
public class Main
{
    public static List<Gwiazdozbior> listaOdczyt=Odczyt();
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
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Gwiazda g1 = new Gwiazda("ABC1234", "-02,12,21", "12,12,21", 2, 1, "wolarza", 1.1,"3000");
        Gwiazda g2 = new Gwiazda("DEF4215", "2,22,19", "10,32,19", 5, 7, "wolarza", 1.5,"3500");
        Gwiazda g3 = new Gwiazda("DEF4215", "2,22,19", "10,32,19", 5, 7, "ryb", 1.5,"3500");
        Gwiazda g4 = new Gwiazda("DEF4212", "2,22,19", "10,32,19", 5, 7, "wolarza", 1.5,"3500");
        Gwiazda g5 = new Gwiazda("DEF4211", "2,22,19", "10,32,19", 5, 7, "wolarza", 1.5,"3500");
        Gwiazdozbior wolarz = new Gwiazdozbior("Wolarz");
        Gwiazdozbior ryb = new Gwiazdozbior("Ryb");
        wolarz.DodajGwiazde(g1);
        wolarz.DodajGwiazde(g2);
        ryb.DodajGwiazde(g3);
        wolarz.DodajGwiazde(g4);
        wolarz.DodajGwiazde(g5);

        List<Gwiazdozbior> pomoc3 = new ArrayList<>();
        pomoc3.add(wolarz);
        pomoc3.add(ryb);
        Zapis(pomoc3);
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            System.out.println(gwiazdozbior.nazwa);
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                gwiazda.Poka();
                System.out.println();
            }
        }


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

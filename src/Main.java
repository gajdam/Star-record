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


        for (Gwiazda g : wolarz.gwiazdozbior) {
            g.Poka();
            System.out.println();
        }
        System.out.println("======================================");
//        wolarz.UsunGwiazde(g2);
//        System.out.println("============================================================");
//        for (Gwiazda g : wolarz.gwiazdozbior) {
//            g.Poka();
//            System.out.println();
//        }
        System.out.println("1 - zapis\n2 - odczyt");
        int action = scan.nextInt();

        //zapis do pliku
        if (action == 1) {

            FileOutputStream fos = new FileOutputStream("baza.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(wolarz);
            oos.writeObject(ryb);
            oos.close();
            fos.close();
        }


        //pobieranie z pliku i wyświetlanie
        else if (action == 2) {

            try (FileInputStream fis = new FileInputStream("baza.dat");
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                while (true) {
                    Gwiazdozbior g = (Gwiazdozbior) ois.readObject();
                    for (Gwiazda gwiazda : g.gwiazdozbior) {
                        gwiazda.Poka();
                        System.out.println();
                    }
                }
            } catch (IOException e) {
                // Obsługa wyjątku EOFException, który występuje, gdy osiągnięto koniec pliku
                if (e instanceof java.io.EOFException) {
                    System.out.println("Koniec pliku");
                } else {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

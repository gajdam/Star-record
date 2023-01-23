import java.io.*;
import java.math.BigDecimal;
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
    static void WyszukajNazwaKatalogowa(String inputNazwy)      //Jakub Czekajski
    {
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                if (Objects.equals(gwiazda.getNazwaKatalogowa(), inputNazwy))
                {
                    gwiazda.Poka();
                    System.out.println();
                }
            }
        }
    }
    static void WyszukajParseki (double parsek)         //Jakub Czekajski
    {
        double lataSwietlne=parsek*0.30661012859534;
//        List <Double> najmniejszaRoznica = new ArrayList<Double>();
//        List <Double> lataSwietlneLista=new ArrayList<Double>();
        double minRoznica = Double.MAX_VALUE;
        Gwiazda najblizszaGwiazda = null;
//        String gotowe=null;
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
//                double roznica = Math.abs(gwiazda.lataSwietlne - parsek);
                if (lataSwietlne==gwiazda.lataSwietlne) {
                    gwiazda.Poka();
                    System.out.println();
//                    gotowe="gotowe";
                }
                else
                {
                    double roznica = Math.abs(gwiazda.lataSwietlne - parsek);
                    if (roznica < minRoznica) {
                        minRoznica = roznica;
                        najblizszaGwiazda = gwiazda;
                    }
//                    najmniejszaRoznica.add(roznica);
//                    lataSwietlneLista.add(lataSwietlne);
                }
            }
        }
        if (najblizszaGwiazda != null) {
            System.out.println("\033[31mNie znaleziono gwiazdy w takiej odległości\033[0m, najbliższa gwiazda to: ");
            najblizszaGwiazda.Poka();
        }
//        double pomoc;
//        int indexListy;
//        if (gotowe ==null)
//        {
//            pomoc=Collections.min(najmniejszaRoznica);
//            indexListy=najmniejszaRoznica.indexOf(pomoc);
//
//            for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
//                for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
//                    if (gwiazda.lataSwietlne==lataSwietlneLista.get(indexListy))
//                    {
//                        System.out.println("Najbliższa gwiazda to:");
//                        gwiazda.Poka();
//                        System.out.println();
//                    }
//                }
//            }
//        }

    }
    public static void WyszukajTemperature(BigDecimal temp1, BigDecimal temp2)
    {
        int wart1;
        int wart2;
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                BigDecimal wartoscTemp=new BigDecimal(gwiazda.temperatura);
                wart1=wartoscTemp.compareTo(temp1);
                wart2=wartoscTemp.compareTo(temp2);
                if (wart1>0 && wart2<0)
                {
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


    }

}

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main
{
    public static List<Gwiazdozbior> listaOdczyt = Odczyt();
//    public static List<Gwiazdozbior> listaOdczyt = new ArrayList<>();
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
        return pomoc;
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
        double lataSwietlne=parsek*0.306;
//        List <Double> najmniejszaRoznica = new ArrayList<Double>();
//        List <Double> lataSwietlneLista=new ArrayList<Double>();
        double minRoznica = Double.MAX_VALUE;
        Gwiazda najblizszaGwiazda = null;
        String gotowe=null;
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
//                double roznica = Math.abs(gwiazda.lataSwietlne - parsek);
                if (lataSwietlne==gwiazda.lataSwietlne) {
                    gwiazda.Poka();
                    System.out.println();
                    gotowe="gotowe";
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

        if (najblizszaGwiazda != null && gotowe == null) {
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

    public static void WyszukajTemperature(BigDecimal temp1, BigDecimal temp2) //Jakub Czekajski
    {
        int wart1;
        int wart2;
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                BigDecimal wartoscTemp=new BigDecimal(gwiazda.temperatura);
                wart1=wartoscTemp.compareTo(temp1);
                wart2=wartoscTemp.compareTo(temp2);
                if (wart1>=0 && wart2<=0)
                {
                    gwiazda.Poka();
                    System.out.println();
                }
            }
        }
    }

    public static void WyszukajWGwiazdozbiorze(String inputNazwy)      //Jakub Czekajski
    {
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                if (Objects.equals(gwiazda.getGwiazdozbior(), inputNazwy)) {
                    gwiazda.Poka();
                    System.out.println();
                }
            }
        }
    }

    public static Gwiazdozbior SprawdzObiekt(String nazwa) {    //Maciej Gajda
        for (Gwiazdozbior g : listaOdczyt) {
            if (Objects.equals(nazwa, g.nazwa))
                return g;
        }
        return null;
    }

    public static Gwiazda SprawdzGwiazde(String nazwaKat) {     //Maciej Gajda
        for (Gwiazdozbior g : listaOdczyt) {
            for (Gwiazda gwiazda : g.gwiazdozbior) {
                System.out.println(nazwaKat);
                if (Objects.equals(nazwaKat, gwiazda.nazwaKatalogowa)) {
                    return gwiazda;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        for (Gwiazdozbior gwiazdozbior: listaOdczyt) {
            System.out.println(gwiazdozbior.nazwa);
            for (Gwiazda gwiazda: gwiazdozbior.gwiazdozbior) {
                gwiazda.Poka();
                System.out.println();
            }
        }

        System.out.println("Ewidencja Gwiazd");
        int wybor = 5;
        String nazwa, deklinacja, rekta, temperatura, gwiazdozbior;
        double obsWiel, lata, masa;
        while (wybor != 0) {
            System.out.println("1 - Dodaj\n2 - Usuń\n3 - Wyświetl\n0 - wyjdź");
            wybor = scan.nextInt();
            if (wybor == 1) {
                System.out.println("Dodawanie gwiazdy");
                System.out.println("Podaj nazwę");
                nazwa = scan.next();
                System.out.println("Podaj deklinację [xx,yy,zz]");
                deklinacja = scan.next();
                System.out.println("Podaj rektascensję [xx,yy,zz]");
                rekta = scan.next();
                System.out.println("Podaj obserwowaną wielkość gwiazdową");
                obsWiel = scan.nextDouble();
                System.out.println("Podaj odległość w latach świetlnych");
                lata = scan.nextDouble();
                System.out.println("Podaj nazwę gwiazdozbioru");
                scan.useDelimiter("\n");
                gwiazdozbior = scan.next();
                System.out.println("Podaj masę");
                masa = scan.nextDouble();
                System.out.println("Podaj temperaturę");
                temperatura = scan.next();

                Gwiazda gw = new Gwiazda(nazwa, deklinacja, rekta, obsWiel, lata, gwiazdozbior, masa, temperatura);
                Gwiazdozbior gwz = SprawdzObiekt(gwiazdozbior);
                if (gwz == null) {
                    gwz = new Gwiazdozbior((gwiazdozbior));
                    listaOdczyt.add(gwz);
                }
                gwz.DodajGwiazde(gw);
//                listaOdczyt.add(gwz);
            }
            if (wybor == 2) {
                System.out.println("Podaj nazwę katalogową: ");
                scan.useDelimiter("\n");
                String nazwKat = scan.next();
                Gwiazda gwiazda = SprawdzGwiazde(nazwKat);
                if (gwiazda == null) {
                    System.out.println("Sory nie ma takiej");
                    break;
                }
                Gwiazdozbior gwz = SprawdzObiekt(gwiazda.gwiazdozbior);
                if (gwz != null) {
                    gwz.UsunGwiazde(gwiazda);
                }
            }
            if (wybor == 3) {
                System.out.println("""
                        1 - Wyświetl wszystko
                        2 - Wyświetl supernove
                        3 - Wyświetl gwiazdy na danej półkuli
                        4 - Wyświetl gwiazdy w zadanym przedziale Wielkości Gwiazdowej
                        5 - Wyświetl po Nazwie Katalogowej
                        6 - Wyświetl gwiazdy w zadanej odległości (parseki)
                        7 - Wyświetl gwiazdy w zadanej temperaturze
                        8 - Wyświetl gwiazdy danego gwiazdozbioru""");
                int wyswietl_wybor = scan.nextInt();
                switch (wyswietl_wybor) {
                    case 1:
                        //wyświetlanie wszystkich gwiazd
                        for (Gwiazdozbior gwiazdozbior1: listaOdczyt) {
                            System.out.println(gwiazdozbior1.nazwa);
                            for (Gwiazda gwiazda: gwiazdozbior1.gwiazdozbior) {
                                gwiazda.Poka();
                                System.out.println();
                            }
                        }
                        break;
                    case 2:
                        WyszukajSupernove();
                        break;
                    case 3:
                        System.out.println("W jakiej półkuli?");
                        String polkula = scan.next();
                        WyszukajPolkule(polkula);
                        break;
                    case 4:
                        System.out.println("Podaj początek:");
                        double pocz = scan.nextDouble();
                        System.out.println("Podaj koniec:");
                        double koniec = scan.nextDouble();
                        WyszukajWielkoscGwiazdowa(pocz, koniec);
                        break;
                    case 5:
                        System.out.println("Podaj nazwę katalogową:");
                        scan.useDelimiter("\n");
                        String nK = scan.next();
                        WyszukajNazwaKatalogowa(nK);
                        break;
                    case 6:
                        System.out.println("Podaj wartość:");
                        double poczPar = scan.nextDouble();
                        WyszukajParseki(poczPar);
                        break;
                    case 7:
                        System.out.println("Podaj początek przedziału:");
                        BigDecimal p = scan.nextBigDecimal();
                        System.out.println("Podaj koniec przedziału:");
                        BigDecimal k = scan.nextBigDecimal();
                        WyszukajTemperature(p, k);
                        break;
                    case 8:
                        System.out.println("Podaj nazwę Gwiazdozbioru");
                        String nazwa_gwz = scan.next();
                        WyszukajWGwiazdozbiorze(nazwa_gwz);
                        break;
                    default:
                        System.out.println("Niepoprawny numer");
                }
            }
            Zapis(listaOdczyt);
        }
    }
}

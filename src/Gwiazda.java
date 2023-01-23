import java.io.Serializable;

public class Gwiazda implements Serializable
{
    public String[] literyGreckie={"Alfa","Beta","Gamma","Delta","Epsilon","Dzeta","Eta","Theta","Jota","Kappa",
            "Lambda","My","Ny","Ksi","Omikron","Pi","Rho","Sigma","Tau","Ipsylon","Phi","Chi","Psi","Omega"};
    String nazwa;
    String nazwaKatalogowa;
    String gwiazdozbior;
    String polkula;
    String rektascenjsa;
    String deklinacja;
    String temperatura;
    double masa;

    double obserwowanaWielkoscGwiazdy;
    double absolutnaWielkoscGwiazdy;
    double lataSwietlne;


    //Getters
    public String getNazwa() {
        return nazwa;
    }
    public String getNazwaKatalogowa() {
        return nazwaKatalogowa;
    }
    public String getGwiazdozbior() {
        return gwiazdozbior;
    }
    public String getPolkula() {
        return polkula;
    }
    public String getRektascenjsa() {
        return rektascenjsa;
    }
    public String getDeklinacja() {
        return deklinacja;
    }
    public double getObserwowanaWielkoscGwiazdy() {
        return obserwowanaWielkoscGwiazdy;
    }
    public double getAbsolutnaWielkoscGwiazdy() {
        return absolutnaWielkoscGwiazdy;
    }
    public double getLataSwietlne() {
        return lataSwietlne;
    }
    public String getTemperatura() {
        return temperatura;
    }
    public double getMasa() {
        return masa;
    }


    //Setters
    //TODO: dodać wyjątki, dodać erory dla usera
    public void setNazwa(String nazwa)
    {
        if (nazwa.length() != 7&& !CzyPoprawnaNazwa(nazwa))
        {
            throw new IllegalArgumentException();
        }
        else
            this.nazwa=nazwa;
    }
    public void setNazwaKatalogowa(String nazwaKatalogowa)
    {
        this.nazwaKatalogowa=nazwaKatalogowa;
    }
    public void setGwiazdozbior(String gwiazdozbior)
    {
        this.gwiazdozbior=gwiazdozbior;
    }
    public void setPolkula(String polkula)
    {
        this.polkula=polkula;
    }
    public void setRektascenjsa(String rektascenjsa)
    {
        this.rektascenjsa=rektascenjsa;
    }
    public void setDeklinacja(String deklinacja)
    {
        this.deklinacja=deklinacja;
    }
    public void setObserwowanaWielkoscGwiazdy(int obserwowanaWielkoscGwiazdy)
    {
        if (obserwowanaWielkoscGwiazdy<-26.74 || obserwowanaWielkoscGwiazdy>15.00)
        {
            throw new IllegalArgumentException();
        }
        else {
            this.obserwowanaWielkoscGwiazdy = obserwowanaWielkoscGwiazdy;
        }
    }
    public void setAbsolutnaWielkoscGwiazdy(double absolutnaWielkoscGwiazdy)
    {
        this.absolutnaWielkoscGwiazdy=absolutnaWielkoscGwiazdy;
    }
    public void setLataSwietlne(double lataSwietlne)
    {
        if (lataSwietlne<=0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.lataSwietlne=lataSwietlne;
        }
    }
    public void setTemperatura(String temperatura)
    {
        if (Double.parseDouble(temperatura)<2000)
        {
            throw new IllegalArgumentException();
        }
        else {
            this.temperatura = temperatura;
        }
    }
    public void setMasa(double masa) {
        if (masa<=0.1||masa>50)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.masa=masa;
        }

    }
    //konstruktor
    public Gwiazda(String nazwa, String deklinacja, String rektascenjsa, double obsWielkosc,
                   double odleglosc, String gwiazdozbior, double masa, String temperatura){   //Maciej Gajda
        this.nazwa = nazwa;
        this.deklinacja = deklinacja;
        this.rektascenjsa = rektascenjsa;
        this.obserwowanaWielkoscGwiazdy = obsWielkosc;
        this.lataSwietlne = odleglosc;
        this.absolutnaWielkoscGwiazdy = ObliczAbsWielGwi();
        this.polkula = JakaPolkula();
        this.gwiazdozbior = gwiazdozbior;
        this.masa = masa;
        this.temperatura = temperatura;

    }
    public boolean CzyPoprawnaNazwa(String nazwa) //Jakub Czekajski
    {
        StringBuilder tabLiter= new StringBuilder();
        StringBuilder tabLiczb= new StringBuilder();
        for (int i = 0; i < nazwa.length(); i++)
        {
            if(Character.isDigit(nazwa.charAt(i)))
            {
                tabLiter.append(nazwa.charAt(i));
            }
            else if (Character.isUpperCase(nazwa.charAt(i))&&Character.isLetter(nazwa.charAt(i)))
            {
                tabLiczb.append(nazwa.charAt(i));
            }
        }
        return tabLiter.length() == 3 && tabLiczb.length() == 4;
    }
    public double ObliczAbsWielGwi() //Jakub Czekajski
    {
        double r = lataSwietlne*0.3066; //parseki
        return obserwowanaWielkoscGwiazdy-5*Math.log10(r)+5;
    }
    public static double wydzielStopnie(String deklinacja) {  //razem XD
        String [] tabWartosci=deklinacja.split(",");
        try
        {
            return Double.parseDouble(tabWartosci[0]);
        }
        catch (NumberFormatException e)
        {
            return 0.0;
        }
    }
    public String JakaPolkula() {  //Maciej Gajda

        double stopnie=wydzielStopnie(deklinacja);
        if (stopnie > 0) {
            return "PN";
        }
        else if (stopnie < 0) {
            return "PD";
        }
        else {
            return "Równik";
        }
    }
    //metoda wyświetlająca
    //TODO: uporządkować sety
    public void Poka() {            //Maciej Gajda
        System.out.println("Nazwa: " + this.nazwa);
        System.out.println("Nazwa katalogowa: " + this.nazwaKatalogowa);
        System.out.println("Deklinacja: " + this.deklinacja);
        System.out.println("Rektascensja: " + this.rektascenjsa);
        System.out.println("Obserwowana wielkość gwiazdowa: " + this.obserwowanaWielkoscGwiazdy);
        System.out.println("Absolutna wielkość gwiazdowa: " + ObliczAbsWielGwi());
        System.out.println("Odległość: " + this.lataSwietlne);
        System.out.println("Masa: " + this.masa);
        System.out.println("Polkula: " + JakaPolkula());
        System.out.println("Gwiazdozbior: " + this.gwiazdozbior);
        System.out.println("Temperatura: " + this.temperatura);
    }

}

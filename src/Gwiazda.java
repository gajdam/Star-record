public class Gwiazda
{
    String nazwa;
    String nazwaKatalogowa;
    String gwiazdozbior;
    String polkula;
    String rektascenjsa;
    int deklinacja;
    int obserwowanaWielkoscGwiazdy;
    int absolutnaWielkoscGwiazdy;
    int lataSwietlne;
    int temperatura;
    int masa;

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
    public int getObserwowanaWielkoscGwiazdy() {
        return obserwowanaWielkoscGwiazdy;
    }
    public int getAbsolutnaWielkoscGwiazdy() {
        return absolutnaWielkoscGwiazdy;
    }
    public int getLataSwietlne() {
        return lataSwietlne;
    }
    public int getTemperatura() {
        return temperatura;
    }
    public int getMasa() {
        return masa;
    }

    //Setters
    //TODO: dodać wyjątki, dodać erory dla usera
    public void setNazwa(String nazwa)
    {
        //if (nazwa.charAt())
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
    public void setDeklinacja(int deklinacja)
    {
        this.deklinacja=deklinacja;
    }
    public void setObserwowanaWielkoscGwiazdy(int obserwowanaWielkoscGwiazdy)
    {
        this.obserwowanaWielkoscGwiazdy=obserwowanaWielkoscGwiazdy;
    }
    public void setAbsolutnaWielkoscGwiazdy(int absolutnaWielkoscGwiazdy)
    {
        this.absolutnaWielkoscGwiazdy=absolutnaWielkoscGwiazdy;
    }
    public void setLataSwietlne(int lataSwietlne)
    {
        this.lataSwietlne=lataSwietlne;
    }
    public void setTemperatura(int temperatura)
    {
        this.temperatura=temperatura;
    }
    public void setMasa(int masa)
    {
        this.masa=masa;
    }

    //konstruktor
    //TODO: uzupełnić kolejne zmienne
    public Gwiazda(String nazwa){   //Maciej Gajda
        this.nazwa = nazwa;
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
    //metoda wyświetlająca
    //TODO: uporządkować sety
    public void Poka() {
        setNazwa(nazwa);
        System.out.print(getNazwa());
    }
}

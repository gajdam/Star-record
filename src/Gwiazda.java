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
    public int getDeklinacja() {
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
}

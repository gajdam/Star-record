import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class Gwiazdozbior implements Serializable
{
    public String[] literyGreckie={"Alfa","Beta","Gamma","Delta","Epsilon","Dzeta","Eta","Theta","Jota","Kappa",
            "Lambda","My","Ny","Ksi","Omikron","Pi","Rho","Sigma","Tau","Ipsylon","Phi","Chi","Psi","Omega"};
    String nazwa;
    List<Gwiazda> gwiazdozbior;
    public Gwiazdozbior(String nazwa)
    {
        this.nazwa = nazwa;
        this.gwiazdozbior = new ArrayList<>();
    }
    public void UsunGwiazde(Gwiazda gwiazda) {   //Jakub Czekajski
        this.gwiazdozbior.remove(gwiazda);
        ustawNazwe();
    }
    public void DodajGwiazde(Gwiazda gwiazda)   //Jakub Czekajski
    {
        this.gwiazdozbior.add(gwiazda);
        ustawNazwe();
    }
    public void ustawNazwe() {  //Maciej Gajda
        for (int i = 0; i < this.gwiazdozbior.size(); i++) {
            this.gwiazdozbior.get(i).setNazwaKatalogowa(literyGreckie[i] + " " + this.nazwa);
        }
    }

}


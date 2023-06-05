package domain;

public class Medicament implements  Entity<Integer>{
    private int id;
    private String nume;
    private String categorie;
    private String prospect;
    private int pret;

    public Medicament(){}

    public Medicament(int id, String nume, String categorie, String prospect, int pret) {
        this.id = id;
        this.nume = nume;
        this.categorie = categorie;
        this.prospect = prospect;
        this.pret = pret;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer integer) {
        this.id = integer;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getProspect() {
        return prospect;
    }

    public void setProspect(String prospect) {
        this.prospect = prospect;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prospect='" + prospect+ '\'' +
                ", pret=" + pret +
                '}';
    }
}

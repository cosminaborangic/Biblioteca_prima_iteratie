package domain;

public class Medic implements User{
    private int id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String sectie;
    private String phone_number;

    public Medic(){}

    public Medic(int id, String username, String password, String first_name, String last_name, String sectie, String phone_number) {
        setId(id);
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.sectie = sectie;
        this.phone_number = phone_number;
    }

    public Medic(String username, String password, String first_name, String last_name, String sectie, String phone_number) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.sectie = sectie;
        this.phone_number = phone_number;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer integer) {
        this.id = integer;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSectie() {
        return sectie;
    }

    public void setSectie(String sectie) {
        this.sectie = sectie;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", sectie='" + sectie + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}

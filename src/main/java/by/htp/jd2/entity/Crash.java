package by.htp.jd2.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "crashbill")
public class Crash {

    @Id
    @Column(name = "idcrashbill")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private int amount;

    @Column(name = "cars_idcars")
    private int idCar;

    @Column(name = "users_iduser")
    private int idUser;

    @Column(name = "iscomplete")
    private Boolean isComplete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public boolean isComplete() {
        return isComplete == null ? false : isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }


    @Override
    public String toString() {
        return "Crash{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", idCar=" + idCar +
                ", idUser=" + idUser +
                ", isComplete=" + isComplete +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crash crash = (Crash) o;
        return id == crash.id &&
                amount == crash.amount &&
                idCar == crash.idCar &&
                idUser == crash.idUser &&
                isComplete == crash.isComplete &&
                Objects.equals(description, crash.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, idCar, idUser, isComplete);
    }
}

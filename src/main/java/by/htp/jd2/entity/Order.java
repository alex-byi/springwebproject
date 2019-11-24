package by.htp.jd2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "idorders")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "dateorder")
    private String dateOrder;

    @Column (name = "startdate")
    private String startDate;

    @Column (name = "enddate")
    private String endDate;

    @Column (name = "ispaid")
    private Boolean isPaid;

    @Column (name = "iscrash")
    private Boolean isCrash;

    @Column (name = "cars_idcars")
    private int idCar;

    @Column (name = "crashbill_idcrashbill")
    private Integer crashBill;

    @Column (name = "users_iduser")
    private int idUser;

    @Column (name = "amount")
    private int amount;

    @Column (name = "dayCol")
    private int dayCol;

    @Column (name = "iscanceled")
    private Boolean isCanceled;

    @Column (name = "iscomplete")
    private Boolean isComplete;

    @Column (name = "reject_reason")
    private String rejectReason;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isPaid() {
        return isPaid == null ? false : isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isCrash() {
        return isCrash == null ? false : isCrash ;
    }

    public void setCrash(boolean crash) {
        isCrash = crash;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getCrashBill() {
        return crashBill == null ? 0 : crashBill;
    }

    public void setCrashBill(int crashBill) {
        this.crashBill = crashBill;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDayCol() {
        return dayCol;
    }

    public void setDayCol(int dayCol) {
        this.dayCol = dayCol;
    }

    public boolean isCanceled() {
        return isCanceled == null ? false : isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public boolean isComplete() {
        return isComplete == null ? false : isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateOrder='" + dateOrder + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", isPaid=" + isPaid +
                ", isCrash=" + isCrash +
                ", idCar=" + idCar +
                ", crashBill=" + crashBill +
                ", idUser=" + idUser +
                ", amount=" + amount +
                ", dayCol=" + dayCol +
                ", isCanceled=" + isCanceled +
                ", isComplete=" + isComplete +
                ", rejectReason='" + rejectReason + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                isPaid == order.isPaid &&
                isCrash == order.isCrash &&
                idCar == order.idCar &&
                crashBill == order.crashBill &&
                idUser == order.idUser &&
                amount == order.amount &&
                dayCol == order.dayCol &&
                isCanceled == order.isCanceled &&
                isComplete == order.isComplete &&
                Objects.equals(dateOrder, order.dateOrder) &&
                Objects.equals(startDate, order.startDate) &&
                Objects.equals(endDate, order.endDate) &&
                Objects.equals(rejectReason, order.rejectReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOrder, startDate, endDate, isPaid, isCrash, idCar, crashBill, idUser, amount, dayCol, isCanceled, isComplete, rejectReason);
    }
}

package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetalleReserva")
public class DetailReservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_detail_reservation;
	
	@Column(name="cantidad", nullable=false)
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="id_ambiente", nullable=false)
	private Room room;
	
	@ManyToOne
	@JoinColumn(name="id_reserva", nullable=false)
	private Reservation reservation;
	
	public DetailReservation() {
		super();
	}

	public DetailReservation(int id_detail_reservation, int quantity, Room room, Reservation reservation) {
		super();
		this.id_detail_reservation = id_detail_reservation;
		this.quantity = quantity;
		this.room = room;
		this.reservation = reservation;
	}

	public int getId_detail_reservation() {
		return id_detail_reservation;
	}

	public void setId_detail_reservation(int id_detail_reservation) {
		this.id_detail_reservation = id_detail_reservation;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	//@ManyToOne (targetEntity = User.class)
	@ManyToOne
	@JoinTable(name="USER_CAR",
			joinColumns=@JoinColumn(name="OWNER_ID"),
			inverseJoinColumns=@JoinColumn(name="CAR_ID"))
	private User owner;

	private String carName;

	private Date dateCreated;

	public Car() {
	}

	public Car(User owner, String carName, Date dateCreated) {
		super();
		this.owner = owner;
		this.carName = carName;
		this.dateCreated = dateCreated;
	}

	public Car(String carName, Date dateCreated) {
		super();
		this.carName = carName;
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Car [owner=" + owner + ", carName=" + carName
				+ ", dateCreated=" + dateCreated + "]";
	}

}

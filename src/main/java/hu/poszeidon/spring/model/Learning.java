package hu.poszeidon.spring.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "LEARNING")
@Embeddable
public class Learning {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	*/
	@Column(name = "PATH", nullable = false)
	private String path;

	@Column(name = "TYPE", nullable = true)
	private String type;
/*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
*/
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Learning() {
	}

	@Override
	public String toString() {
		return "Learning [path=" + path + ", type=" + type + "]";
	}
	
	
}

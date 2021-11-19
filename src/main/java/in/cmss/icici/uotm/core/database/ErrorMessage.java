package in.cmss.icici.uotm.core.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "message")
@ToString
public class ErrorMessage {
	@Column
	@Id
	private Integer code;

	@Column
	private String message;

	@Column
	private String description;

	@Column
	private String resolution;
}

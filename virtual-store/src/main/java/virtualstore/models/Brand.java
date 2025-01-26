package virtualstore.models;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "brand")
@SequenceGenerator(name = "seq_product_brand", sequenceName = "seq_product_brand", allocationSize = 1, initialValue = 1)
public class Brand implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_brand")
	@Id
	private Long id;
	
	private String name;
}

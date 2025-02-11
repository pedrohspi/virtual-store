package virtualstore.models;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "user_data")
@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private LocalDate dateCurrentPassword;
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_access", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "access_id"}, 
			   name = "unique_user_access"), joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id",
	           table = "user", unique = false, foreignKey = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT)),
			   inverseJoinColumns = @JoinColumn(name = "access_id", unique = false, referencedColumnName = "id", table = "access",
			   foreignKey = @ForeignKey(name = "access_fk", value = ConstraintMode.CONSTRAINT)))
	private List<Access> accesses;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateCurrentPassword() {
		return dateCurrentPassword;
	}

	public void setDateCurrentPassword(LocalDate dateCurrentPassword) {
		this.dateCurrentPassword = dateCurrentPassword;
	}

	/*SÃO OS ACESSOS DO USUARIO: ROLE_ADMIN D*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.accesses.stream().collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		
		return this.username;
	}
}

package virtualstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "legal_entity")
public class LegalEntity extends Person {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, unique = true)
	private String cnpj ;
	
	@Column(nullable = false, unique = true)
	private String stateRegistration;
	
	@Column(nullable = false, unique = true)
	private String municipalRegistration;
	
	@Column(nullable = false)
	private String fantasyName;
	
	@Column(nullable = false)
	private String socialReason;
	
	@Column(nullable = false)
	private String category;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getStateRegistration() {
		return stateRegistration;
	}

	public void setStateRegistration(String stateRegistration) {
		this.stateRegistration = stateRegistration;
	}

	public String getMunicipalRegistration() {
		return municipalRegistration;
	}

	public void setMunicipalRegistration(String municipalRegistration) {
		this.municipalRegistration = municipalRegistration;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
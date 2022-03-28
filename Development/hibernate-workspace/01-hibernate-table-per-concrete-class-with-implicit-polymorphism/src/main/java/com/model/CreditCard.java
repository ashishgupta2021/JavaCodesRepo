package com.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@AttributeOverride(name = "owner", column = @Column(name = "CC_OWNER", nullable = false))
public class CreditCard extends BillingDetails {

	@Id
	protected Long id;

	@NotNull
	protected String cardNumber;

	@NotNull
	protected String expMonth;

	public CreditCard() {
	}

	public CreditCard(String owner, Long id, String cardNumber, String expMonth) {
		super(owner);
		this.id = id;
		this.cardNumber = cardNumber;
		this.expMonth = expMonth;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", cardNumber=" + cardNumber + ", expMonth=" + expMonth + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

}

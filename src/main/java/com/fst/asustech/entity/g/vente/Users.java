package com.fst.asustech.entity.g.vente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Users implements Serializable {

	private static final long serialVersionUID = -6979903632730892267L;

	@Id
	@Column
	private String username;

	@Column
	private @NonNull String password;

	@Column
	private int enabled;
}

package com.D.DolceForno;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_estoque")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CookieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String sabor;
    private Integer quantidade;
    private Boolean recheado;
}

package br.com.etechoracio.pw2av3.entity;

import br.com.etechoracio.pw2av3.enums.NivelDificuldadeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercicio_fisico")
public class ExercicioFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "grupo_muscular")
    private String grupoMuscular;

    private String imagem;

    private String descricao;

    @Column(name = "numero_series")
    private int numeroSeries;

    @Column(name = "numero_repeticoes")
    private int numeroRepeticoes;

    @Column(name = "carga_sugerida")
    private double cargaSugerida;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_dificuldade")
    private NivelDificuldadeEnum nivelDificuldade;
}

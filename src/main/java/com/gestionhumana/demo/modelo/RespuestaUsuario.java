package com.gestionhumana.demo.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "respuestas_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RespuestaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_survey_id", nullable = false)
    private EncuestaUsuario userSurvey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Pregunta question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_option_id", nullable = false)
    private OpcionRespuesta answerOption;
}


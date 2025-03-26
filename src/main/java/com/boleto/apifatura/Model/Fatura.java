package com.boleto.apifatura.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "faturas")
@Getter @Setter @NoArgsConstructor @ToString
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do cartão não pode estar vazio")
    @Pattern(regexp = "\\d{16}", message = "O número do cartão deve conter 16 digítos")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode estar em branco")
    @Size(min = 6, max = 100, message = "O nome do titular deve conter entre 6 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "O valor não pode ser nulo")
    @DecimalMin(value="10.0", message = "O valor mínimo é R$10,00")
    @DecimalMax(value="5000.0", message = "O valor máximo é de R$5.000")
    private Double valor;

    @NotNull(message = "A data de pagamento não pode ser nula")
    @FutureOrPresent(message = "A data de pagamento deve ser válida")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O email deve ser válido")
    private String emailContato;

}
package com.exemplo.cadastro.model;

import lombok.Data;
import java.util.List;

@Data
public class CadastroClienteRequest {
    private DadosIdentificacao dadosIdentificacao;
    private Endereco endereco;
    private Contatos contatos;
    private DadosProfissionais dadosProfissionais;
    private DadosFinanceiros dadosFinanceiros;
    private PerfilInvestidor perfilInvestidor;
    private Compliance compliance;
    private List<ReferenciaBancaria> referenciasBancarias;
}

@Data
class DadosIdentificacao {
    private String nomeCompleto;
    private String nomeMae;
    private String cpf;
    private String dataNascimento;
    private String genero;
    private String estadoCivil;
    private String nacionalidade;
    private boolean pep;
}

@Data
class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
    private String tipoResidencia;
    private int tempoResidenciaAnos;
}

@Data
class Contatos {
    private String emailPrincipal;
    private String telefoneCelular;
}

@Data
class DadosProfissionais {
    private String profissao;
    private String cargo;
    private String empresa;
    private String cnpjEmpresa;
    private int tempoEmpregoAnos;
    private double rendaMensal;
    private double patrimonioEstimado;
}

@Data
class DadosFinanceiros {
    private String faixaRenda;
    private int scoreCreditoExterno;
    private boolean possuiRestricao;
    private double limitePretendidoCredito;
}

@Data
class PerfilInvestidor {
    private String objetivoInvestimento;
    private String toleranciaRisco;
    private int horizonteInvestimentoAnos;
    private String experienciaInvestimentos;
}

@Data
class Compliance {
    private boolean residenteFiscalExterior;
    private boolean declaraFatca;
    private boolean aceiteLGPD;
    private boolean aceiteCompartilhamentoDados;
    private boolean aceiteTermos;
}

@Data
class ReferenciaBancaria {
    private String instituicao;
    private String agencia;
    private String conta;
    private int tempoRelacionamentoAnos;
}

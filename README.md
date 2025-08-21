# LkBank

LkBank é um projeto colaborativo desenvolvido por **dois estudantes**, Kevin Richard (Desenvolvedor Júnior) e Lucy (Desenvolvedora Júnior), como parte de sua jornada de aprendizado em programação. O projeto é escrito em **Java** e segue os princípios do paradigma de **Orientação a Objetos (OO)**.

O principal objetivo deste projeto é consolidar e aplicar conhecimentos adquiridos em cursos das plataformas [Alura](https://www.alura.com.br/) e [Udemy](https://www.udemy.com/), servindo como base de estudos, prática e experimentação.

## 🎓 Sobre os Autores

- **Kevin Richard** – Estudante de Desenvolvimento de Software
- **Lucy** – Estudante de Desenvolvimento de Software

## 📚 Cursos Utilizados como Referência

- **Java OO:** Entendendo a Orientação a Objetos
- **Java Polimorfismo:** Entenda Herança e Interfaces
- **Java Exceções:** Aprenda a Criar, Lançar e Controlar Exceções
- **Java e java.lang:** Programe com as classes Object e String
- **Java e java.util:** Coleções, Wrappers e Lambda Expressions

## 🚀 Funcionalidades

- Depósito em conta
- Saque de valores
- Transferência entre contas

```mermaid
---
config:
  layout: dagre
---
classDiagram
direction TB
    class ContaCorrente {
	    +sacar(double valorSaque) double
    }
    class ContaPoupanca {
	    +depositar(double saldo) double
    }
	link ContaPoupanca "https://github.com/k3vinrich4rd/lk-bank/blob/develop/src/service/ContaPoupanca.java" "Ir para a classe no projeto"
	link ContaCorrente "https://github.com/k3vinrich4rd/lk-bank/blob/develop/src/service/ContaCorrente.java" "Ir para a classe no projeto"
    class ContaService {
	    +sacar(double ValorSaque) double
	    +depositar(double valorDeposito) double
	    +transferir(double ValorTransferencia, ContaService conta) double
    }
	link ContaService "https://github.com/k3vinrich4rd/lk-bank/blob/develop/src/service/ContaService.java" "Ir para a classe no projeto"

    class ContaServiceImpl {
	    -int numeroConta
	    -String nomeTitular
	    -double saldo
	    -String CPF
	    +formatarCpf(String cpf) String$
	    +fileWriter(ContaServiceImpl conta) String
    }
	link ContaServiceImpl "https://github.com/k3vinrich4rd/lk-bank/blob/develop/src/service/ContaServiceImpl.java" "Ir para a classe no projeto"

    class FileService {
	    -String[] files
	    -List contas
	    -ContaServiceImpl c
	    -File f
	    +compararNomeDuplo(int numeroConta) boolean
	    +pesquisa(int numeroConta) ContaServiceImpl
	    +criarPasta() void
    }
	link FileService "https://github.com/k3vinrich4rd/lk-bank/blob/develop/src/service/FileService.java" "Ir para a classe no projeto"

    class ExceptionsEnum {
	    -String message$
	    +getMessage(Object... args) String
    }
	link ExceptionsEnum "https://github.com/k3vinrich4rd/lk-bank/blob/develop/src/enums/ExceptionsEnum.java" "Ir para a classe no projeto"

    class SaldoInsuficienteException {
	    SaldoInsuficienteException(String message)
    }
	link SaldoInsuficienteException "https://github.com/k3vinrich4rd/lk-bank/blob/develop/src/exception/SaldoInsuficienteException.java" "Ir para a classe no projeto"


	<<Interface>> ContaService
	<<Abstract>> ContaServiceImpl
	<<Service>> FileService
	<<enum>> ExceptionsEnum
	<<exception>> SaldoInsuficienteException

    ContaServiceImpl <|-- ContaService
    ContaCorrente <|-- ContaServiceImpl
    ContaPoupanca <|-- ContaServiceImpl
    FileService .. ContaServiceImpl
    ExceptionsEnum ..|> SaldoInsuficienteException

```


## 👨‍💻 Como Contribuir

. Faça um fork deste repositório: [LkBank](https://github.com/k3vinrich4rd/lk-bank)
. Crie uma branch para sua feature: `git checkout -b minha-feature`
. Faça commit das suas alterações: `git commit -m 'Adiciona nova feature'`
. Faça push para a branch: `git push origin minha-feature`
. Abra um Pull Request

## 📎 Links Úteis

- [Repositório no GitHub](https://github.com/k3vinrich4rd/lk-bank)

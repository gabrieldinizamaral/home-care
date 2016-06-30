# HOME-CARE

A home-care é o backend do projeto para criação de formulários de visita ao paciente que visa facilitar a vida de homecares.

### Para executar a aplicação

- Para rodar o projéto é preciso ter o gradle - (http://gradle.org/) instalado;
- No terminal entrar na pasta raiz do projeto
- Digitar o comando `gradle bootRun`

Obs. Na primeira vez o start pode ser mais lento, pois o gradle irá fazer o download de todas as dependências

### Endpoints

Estão implementados 4 endpoints:

- Endpoint de cadastro de carer (homecare): `/carer`
``` json
{
    "name": "Nome do homecare",
    "registry": "matrícula do homecare"
}
```
- Endpoint para consultar estrutura do formulário `/survey-forms/{id do formulário}`
- Endpoint para consultar lista de pacientes `/patients`
- Endpoint para cadastrar formulários preenchidos `/survey`
```json
{
	"carer": {
		"id": "1"
	},
	"patient": {
		"name": "Ana Maria",
		"registry": "1234567890",
		"birth": "2016-06-04",
		"gender": "feminino",
		"address": "Rua das flores, no 1, sao paulo - 1234567890 - SP, brasil"
	},
	"startAt": "2016-06-04T18:38:20.036Z",
	"endAt": "2016-06-04T18:38:20.036Z",
	"responses": [
      {
        "field": "1",
        "response": "casa"
      },
      {
        "field": "2",
        "response": "cachorro|gato"
      },
      {
        "field": "3",
        "response": "filho"
      }
    ]
}
```
- Endpoint para buscar formulário por paciente `/patients/{id do paciente}/surveys`

### Pontos de melhoria

- Usar oauth ou outra forma de validar as requisições do frontend
- Os endpoints estão anotados com `@CrossOrigin`, essa anotação é usada para testar a aplicação integrada ao front no ambiente local, ***em produção ela deve ser removida!!!***
- Hoje os templates dos formulários devem ser inseridos diretamente na base, criar um endpoint de criação de formulário, os mesmos também não deveriam poder ser alterados, se o mesmo for necessário uma nova versão do furmulário deveria ser criada
- Hoje o formulário respondido não contem o id do modelo do formulário usado nem a versão, os mesmos deveriam ser salvos
- Adicionar logs
- Adicionar testes unitários e de integração
- Atualmente apenas validações básicas foram adicionadas, se necessário adicionar outra validações de dados de acordo com a lógica de negócio
- Validar os errors de maneira mais robusta
- Expor os errors do serviço de uma forma clara para o frontend

### Frameworks

Para manutenção no projéto os principais frameworks que são necessários conhecer são:
- Spring - https://spring.io/
- Spring boot - http://projects.spring.io/spring-boot/
- Spring mvc - http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
- Spring data - http://projects.spring.io/spring-data/
- Jackson - https://github.com/FasterXML/jackson
- Hibernate - http://hibernate.org/

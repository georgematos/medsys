# Bem vindo ao MedSys!

Olá, esta é a documentação da **MedSys** uma simples aplicação RESTful feita como parte de um processo de selação na empresa Portifólio/Unimed.


# Como consultar esta API

Segue abaixo todos os endpoints com suas respectivas descrições

### GET /medicos
retorna uma lista com todos os médicos cadastrados

### GET /medicos/{id}
retorna o médico com o id informado

### GET /medicos/especialidade/{id}
retorna todos os médicos com a especialidade desejada

### POST /medicos
salva um médico, recebe um objeto JSON no seguinte formato
```
{
	"nome": "Marcelo Barros",
	"dataNascimento": "1981-04-26T00:00:00",
	"ativo": true,
	"especialidades": [
		{
			"id": 1
		}
	]
}
```

### PUT /medicos
atualiza um médico, recebe um objeto JSON no seguinte formato

```
{
	"nome": "Marcos Enny",
	"ativo": false,
	"dataNascimento": "1983-04-26T00:00:00",
	"especialidades": [
		{
			"id": 2
		},
		{
			"id": 1
		}
	]
}
``` 

### DEL /medicos/{id}
exclui o médico com o id passado

### GET /especialidades
retorna uma lista com todas as especialidades médicas cadastradas

### GET /especialidades/{id}
retorna a especialidade com o id informado

### POST /especialidades
salva uma especialidade, recebe um objeto JSON no seguinte formato
```
{
	"nome": "Endocrinologia",
	"descricao": "Especialidade médica com foco em doenças glandulares",
	"ativo": true
}
```

### PUT /especialidades
atualiza uma especialidade, recebe um objeto JSON no seguinte formato

```
{
	"nome": "Endocrinologia",
	"descricao": "Especialidade médica com foco em doenças glandulares",
	"ativo": true
}
``` 

### DEL /especialidades/{id}
exclui a especialidade com o id passado

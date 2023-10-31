# TechChallenge
Fase 1 - Pós 2ADJT
Introdução ao sistema: 
 
Sistema para locação de carros através do APP ou WEB onde empresas possam gerenciar seus veículos de locação e clientes locarem veículos. O sistema será responsável pela orquestração deste serviço, desde cadastro de usuários, locadoras, veículos, interfaces Web e Mobile para empresas e clientes, pagamentos, localização de pontos de entrega/retirada de veículos. 

 

Documentação do sistema: 

 

A documentação contendo o Event Storm, DDD, StoryTelling e introdução está no MIRO, segue o link público abaixo: 

 

https://miro.com/app/board/uXjVNYWuhlk=/?share_link_id=873839765585 

 

Código da implantação: 

O código está no github na branch de develop, link público abaixo: 

 

https://github.com/gabrielfellone/TechChallenge  

 

 

Para ajudar nos testes, segue os endpoints e payloads: 
 
 
 

GET  

LISTA CARROS: 
localhost:8080/v1/alugar/listaCarros 

 

 

 

POST  

ALUGA CARRO 
localhost:8080/v1/alugar/alugar 

{ 

	"id": "c2ef9792-8bd0-4cb2-9513-3f622d497df4", 

	"placa": "FA321321", 

	"cliente": { 

		"id": "edf6cdf3-ddbd-4525-95f1-3721ba0467f5", 

		"name": "Fulano", 

		"localidade": "SaoPaulo", 

		"email": "fulano@email.com.br", 

		"cpf": "4154948215" 

	}, 

	"dtaAluguelInicio": "1996-05-03", 

	"dtaAluguelFinal": "1996-07-10" 

} 

 

 

 

 

 

 

 

 

POST  

EXTENDE PRAZO ALUGUEL 
localhost:8080/v1/alugar/extensao 

 

{ 

	"id": "c2ef9792-8bd0-4cb2-9513-3f622d497df4", 

	"placa": "FA321321", 

	"cliente": { 

		"id": "edf6cdf3-ddbd-4525-95f1-3721ba0467f5", 

		"name": "Antonio Manuel", 

		"localidade": "SaoPaulo", 

		"email": "antonio.manuel@email.com.br", 

		"cpf": "54645678141" 

	}, 

	"dtaAluguelInicio": "1996-05-03", 

	"dtaAluguelFinal": "1996-07-10" 

} 

 

 

PUT  

NOTIFICA DEVOLUCAO CARRO 
localhost:8080/v1/alugar/devolucao 

 

{ 

	"id": "c2ef9792-8bd0-4cb2-9513-3f622d497df4", 

	"status": "INDISPONIVEL" 

} 

 

 

 

 

PUT  

ALTERA STATUS CARRO 
localhost:8080/v1/locadora/status 

 

{ 

	"id": "c2ef9792-8bd0-4cb2-9513-3f622d497df4", 

	"status": "INDISPONIVEL" 

} 

 

Sobre a arquitetura do código (resumida): 

config –  auxiliam na parte de configuração de um client, feign, api externa, properties etc. 
 
controller – as classes de chamadas de api, camada de application, onde possui os endpoints e requests, responses 
 
domain – as classes de entidades, dominios do sistema 

exceptions – exceções personalizadas 

integrations - integrações com outros serviços (exemplo: api google maps, api pagamentos, feign, etc.) 

properties – arquivos de properties, contendo valores de configurações, urls, etc 

repository – possui as classes/interfaces/entidades para banco de dados 

services – classes de serviços para manipular os domains, regras de negócio, etc 
